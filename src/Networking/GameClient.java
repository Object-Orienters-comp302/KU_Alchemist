package Networking;

import Domain.GameController;
import Models.Player;
import Models.Token;
import UI.Components.Player.PlayerDisplayer;
import UI.View.ForageGroundsView;
import UI.View.ViewFactory;
import Utils.AssetLoader;

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
        }
        System.out.println("IN    : processing action type: " + action.getActionType());
        System.out.println("      : processing action details: " + action.getDetails());
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

