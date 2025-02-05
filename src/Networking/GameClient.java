package Networking;

import Domain.GameController;
import Domain.RoundTwoController;
import Models.*;
import UI.Components.Player.PlayerDisplayer;
import UI.Components.SuperViews.ArtifactTargetSelectorView;
import UI.Components.SuperViews.ElixirOfInsightView;
import UI.View.ForageGroundsView;
import UI.View.MarketView;
import UI.View.MenuView;
import UI.View.ViewFactory;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class GameClient {
    private static GameClient instance;
    private Socket socket;
    private ObjectInputStream objectIn;
    private ObjectOutputStream objectOut;
    
    private GameClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        objectOut = new ObjectOutputStream(socket.getOutputStream());
        objectIn = new ObjectInputStream(socket.getInputStream());
        new Thread(this::listenToServer).start();
    }
    
    // Must be called once per client.
    public static synchronized void init(String host, int port) throws IOException {
        if (instance == null) {
            instance = new GameClient(host, port);
        }
    }
    
    public static GameClient getInstance() throws IllegalStateException {
        if (instance == null) {
            throw new IllegalStateException("GameClient is not initialized. Call init() first.");
        }
        return instance;
    }
    
    private void listenToServer() {
        try {
            Object fromServer;
            while ((fromServer = objectIn.readObject()) != null) {
                if (fromServer instanceof GameAction) {
                    GameAction action = (GameAction) fromServer;
                    // Process the received action
                    this.processAction(action);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void sendAction(GameAction action) {
        try {
            System.out.println("OUT:          GameAction type: " + action.getActionType());
            System.out.println("         : GameAction details: " + action.getDetails());
            objectOut.writeObject(action);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void processAction(GameAction action){
        if(action.getActionType() == GameAction.ActionType.GOLD){
            findPlayer(action.getTargetPlayerName()).getInventory().setGold(action.getGold());
        } else if (action.getActionType() == GameAction.ActionType.INIT_PLAYER ) {
            new Player(action.getDetails(), action.getToken());
        } else if (action.getActionType() == GameAction.ActionType.START_GAME) {
            ViewFactory.getInstance().getOnlineLoginView().publishStartMenu();
        } else if(action.getActionType() == GameAction.ActionType.NEXT_ROUND){
            GameController.getInstance().incrementTotalNextTurns();
            Player.nextPlayer();
            ViewFactory.getInstance().getMenuView().getRoundLabel().setText(GameController.getInstance().getRound().toString());
            PlayerDisplayer.repaintAll();
            if(!GameController.getInstance().getPlayerName().equals(Player.getCurrPlayer().getID())){
                ViewFactory.getInstance().getMenuView().showDeduction();
            }
            
            
        } else if (action.getActionType() == GameAction.ActionType.DEAL_INGREDIENT) {
            Player player = findPlayer(action.getTargetPlayerName());
            player.getInventory().addIngredient(action.getIngredientType(), 1);
            
        } else if (action.getActionType() == GameAction.ActionType.DECK_INGREDIENT) {
            Player player = findPlayer(action.getTargetPlayerName());
            player.getInventory().addIngredient(action.getIngredientType(), 1);
            player.setForageRight(player.getForageRight()-1);
            if(action.getTargetPlayerName().equals(GameController.getInstance().getPlayerName())) {
                ViewFactory.getInstance().getMenuView().getForagePanel().getTextField().setText(String.format(
                        ForageGroundsView.Texts.Success.getText(), action.getIngredientType().getTypeString()));
                
                SwingUtilities.invokeLater(() -> ViewFactory.getInstance().getMenuView().getForagePanel().RunForageAnimation(action.getIngredientType()));//TODO CHANGE THIS TO MVC
            }
        } else if (action.getActionType() == GameAction.ActionType.TRANSMUTE) {
            GameController.getInstance().getRoundOneController().TransmuteIngredient(findPlayer(action.getTargetPlayerName()),action.getIngredientType());
            
        } else if(action.getActionType() == GameAction.ActionType.SELL_POTION){
            GameController.getInstance().getRoundTwoController().sellPotion(action.getIdentityType());
        } else if (action.getActionType() == GameAction.ActionType.GET_ARTIFACT) {
            if(action.getArtifact() != null){
                Player player = findPlayer(action.getTargetPlayerName());
                player.getInventory().addArtifactCard(action.getArtifact());
                player.getInventory().setGold(player.getInventory().getGold()-3);
                if(action.getTargetPlayerName().equals(GameController.getInstance().getPlayerName())){
                    ViewFactory.getInstance().getMenuView().getMarketPanel().getTextField().setText(String.format(MarketView.Texts.Success.getText(), action.getArtifact().getName()));
                    ViewFactory.getInstance().getMenuView().getMarketPanel().artifactAnimation(action.getArtifact());
                }

            }else {
                if (action.getTargetPlayerName().equals(GameController.getInstance().getPlayerName())){
                    ViewFactory.getInstance().getMenuView().getMarketPanel().getTextField().setText(MarketView.Texts.Fail.getText());
                }
                
            }
        } else if (action.getActionType() == GameAction.ActionType.SEND_POTION) {
            if(action.getPot() != null){
                
                Player player = Player.getCurrPlayer();
                player.getInventory().addPotions(action.getPot(), 1);
                GameController.getInstance().getRoundOneController().removeIngredient(player,action.getIngredientType());
                GameController.getInstance().getRoundOneController().removeIngredient(player,action.getIngredientType1());
                ViewFactory.getInstance().getMenuView().getPotionBrewingPanel().MakeExperiments(action.getPot(),player,action.isTestOnStudent());
                GameController.getInstance().getRoundOneController().MagicMortar(player, Artifact.Name.Magic_Mortar, action.getIngredientType1());
                if(Player.getCurrPlayer().getID().equals(GameController.getInstance().getPlayerName())){
                    ViewFactory.getInstance().getMenuView().getPotionBrewingPanel().OnlinePotionAnimation(action.getPot());
                };
            }
            
        } else if (action.getActionType() == GameAction.ActionType.REQUEST_PUBLISH) {
            Player cur = GameController.getInstance().getMenuController().getCurrentPlayer();
            RoundTwoController cont2 = GameController.getInstance().getRoundTwoController();
            cont2.publishTheory(cur, action.getIngredientType(), Ingredient.getTrioFromPath(action.getVal()));
            ViewFactory.getInstance().getMenuView().getTheoriesPanel().reset();
        } else if (action.getActionType() == GameAction.ActionType.REQUEST_DEBUNK) {
            GameController.getInstance().getRoundThreeController().debunkTheory(Player.getCurrPlayer(),findPublicationCard(
                    findPlayer(action.getTargetPlayerName()),action.getIngredientType()),action.getAspectColorToDebunk());
            ViewFactory.getInstance().getMenuView().getTheoriesPanel().reset();
        } else if (action.getActionType() == GameAction.ActionType.ENDORSE) {
            GameController.getInstance().getRoundThreeController().endorseTheory(Player.getCurrPlayer(),findPublicationCard(
                    findPlayer(action.getTargetPlayerName()),action.getIngredientType()),action.getCount());
                    ViewFactory.getInstance().getMenuView().getTheoriesPanel().reset();
        }else if (action.getActionType() == GameAction.ActionType.ELIXIR_REQUEST){
            GameController.getInstance().getMenuController().getCurrentPlayer().getInventory().removeArtifact(Artifact.Name.Elixir_of_Insight);
            if(Player.getCurrPlayer().getID().equals(GameController.getInstance().getPlayerName())) {
                MenuView menu = GameController.getInstance().getMenuController().getMenuView();
                menu.Blockade();
                menu.addAndRunPage(new ElixirOfInsightView(action.firstThree));
            }
        }else if (action.getActionType() == GameAction.ActionType.REQUEST_PISTOL){
            GameController.getInstance().getMenuController().getCurrentPlayer().getInventory().removeArtifact(action.getArtifactName());
            
            if(Player.getCurrPlayer().getID().equals(GameController.getInstance().getPlayerName())){
                MenuView menu= GameController.getInstance().getMenuController().getMenuView();
                menu.Blockade();
                menu.addAndRunPage(new ArtifactTargetSelectorView(action.getArtifactName()));
            }
            
        }else if (action.getActionType() == GameAction.ActionType.USE_PISTOL){
            
            Player player = findPlayer(action.getTargetPlayerName());
            GameController.getInstance().getRoundOneController().PistolOfSicknessAbility(player, action.getDamage());
            
        }else if( action.getActionType() == GameAction.ActionType.REQUEST_REPATTACK){
            
            GameController.getInstance().getMenuController().getCurrentPlayer().getInventory().removeArtifact(action.getArtifactName());
            
            if(Player.getCurrPlayer().getID().equals(GameController.getInstance().getPlayerName())){
                MenuView menu= GameController.getInstance().getMenuController().getMenuView();
                menu.Blockade();
                menu.addAndRunPage(new ArtifactTargetSelectorView(action.getArtifactName()));
            }
        }else if(action.getActionType() == GameAction.ActionType.USE_LETTER){
            
            Player player = findPlayer(action.getTargetPlayerName());
            GameController.getInstance().getRoundOneController().ArtifactReputationAbility(player, action.getDamage());
        }
        System.out.println("IN    : processing action type: " + action.getActionType());
        System.out.println("      : processing action details: " + action.getDetails());
    }
    
    private PublicationCard findPublicationCard(Player player, Ingredient.IngredientTypes ingredientTypes) {
        for(PublicationCard publicationCard: PublicationTrack.getInstance().getPublicationCards()){
            
            if(publicationCard.getOwner().getID().equals(player.getID()) && publicationCard.getIngredient() == ingredientTypes){
               return publicationCard;
            }
        }
        return null;
    }
    
    public Player findPlayer(String name){
        for(Player player:Player.getPlayers()){
            if(name.equals(player.getID())){
                return player;
            }
        }
        return null;
    }
    
    public static void main(String[] args) throws IOException {
        // Once per client
        GameClient.init("localhost", 12345);
        
        // Example: send an action
        // GameAction action = new GameAction(GameAction.ActionType.PLAYER_JOINED, "Player Name Placeholder",
        // new Token("Player Name Placeholder",AssetLoader.Tokens.RED));
        // GameClient.getInstance().sendAction(action);
        
        GameAction action1 = new GameAction(GameAction.ActionType.UPDATE_DECK, "Drew 1 card from deck");
        GameClient.getInstance().sendAction(action1);
    }
}

