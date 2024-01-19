package Networking;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import Domain.GameController;
import Models.*;
import UI.View.PotionBrewingView;
import UI.View.ViewFactory;
import Utils.AssetLoader;

import javax.swing.*;
import javax.swing.text.View;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class GameServer implements Publisher {
    private static GameServer instance;
    private ServerSocket serverSocket;
    private ArrayList<Listener> listeners;
    
    private ConcurrentHashMap<ClientHandler, Boolean> clients = new ConcurrentHashMap<>();
    
    private GameServer(int port) throws IOException {
        this.listeners = new ArrayList<>();
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);
    }
    
    public static synchronized void init(int port) throws IOException {
        if (instance == null) {
            instance = new GameServer(port);
        }
    }
    
    public static GameServer getInstance() throws IllegalStateException {
        if (instance == null) {
            throw new IllegalStateException("GameServer is not initialized. Call init() first.");
        }
        return instance;
    }
    
    public void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                clients.put(clientHandler, true);
                new Thread(clientHandler).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public synchronized void broadcastUpdate(GameAction updateAction) {
        
        for (ClientHandler client : clients.keySet()) {
            System.out.println("OUT: Broadcasting update to " + client.toString());
            client.sendMessage(updateAction);
        }
    }
    
    public synchronized void processAction(GameAction action) {
        // TODO: Process action and update game state
        // For now, just echo the action
        if(action.getActionType() == GameAction.ActionType.PLAYER_JOINED){
            //This does not send the background if there is any errors, send background.
            add_player(action.getDetails(), action.getToken());
            publishEvent(Type.PLAYER_ADDED);
        }
        if(action.getActionType() == GameAction.ActionType.NEXT_ROUND){
            GameController.getInstance().incrementTotalNextTurns();
            Player.nextPlayer();
        }
        if(action.getActionType() == GameAction.ActionType.FORAGE){
            Ingredient.IngredientTypes ingredientType = GameController.getInstance().getRoundOneController().ForageForIngredient(Player.getCurrPlayer());
            broadcastUpdate(new GameAction(GameAction.ActionType.DECK_INGREDIENT, "Drew one ingredient from deck",Player.getCurrPlayer().getID(),ingredientType));
        }
        if(action.getActionType() == GameAction.ActionType.TRANSMUTE){
            GameController.getInstance().getRoundOneController().TransmuteIngredient(Player.getCurrPlayer(),action.getIngredientType());
        }
        if(action.getActionType() == GameAction.ActionType.SELL_POTION){
            GameController.getInstance().getRoundTwoController().sellPotion(action.getIdentityType());
        }
        if(action.getActionType() == GameAction.ActionType.REQUEST_ARTIFACT){
            Artifact
                    artifact = GameController.getInstance().getRoundOneController().BuyArtifacts(Player.getCurrPlayer());
            broadcastUpdate(new GameAction(GameAction.ActionType.GET_ARTIFACT,"Sent artifact",Player.getCurrPlayer()
                    .getID(),artifact));
        }
        if(action.getActionType() == GameAction.ActionType.MAKE_EXPERIMENT){
            
            Potion
                    pot = ViewFactory.getInstance().getMenuView().getPotionBrewingPanel().MakePotion(action.getIngredientType(), action.getIngredientType1(), Player.getCurrPlayer());
            if(pot != null){
                broadcastUpdate(new GameAction(GameAction.ActionType.SEND_POTION,"SEND_POTION", pot,action.isTestOnStudent(),action.getIngredientType(), action.getIngredientType1()));
                ViewFactory.getInstance().getMenuView().getPotionBrewingPanel().MakeExperiments(action.getPot(),Player.getCurrPlayer(),action.isTestOnStudent());
                GameController.getInstance().getRoundOneController().MagicMortar(Player.getCurrPlayer(), Artifact.Name.Magic_Mortar, action.getIngredientType1());
                
            }
            
        }
        System.out.println("IN: GameAction type: " + action.getActionType());
        System.out.println("            Details: " + action.getDetails());
        
        broadcastUpdate(action);
    }
    private void add_player(String name, Token token){
        new Player(name, token);
    }
    
    @Override
    public void addListener(Listener lis) {
        listeners.add(lis);
    }
    @Override
    public void publishEvent(Type type) {
        for (Listener listener : listeners) {
            listener.onEvent(type);
        }
    }
    
    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private ObjectInputStream objectIn;
        private ObjectOutputStream objectOut;
        private GameServer server;
        
        public ClientHandler(Socket socket, GameServer server) throws IOException {
            this.clientSocket = socket;
            this.server = server;
            objectOut = new ObjectOutputStream(clientSocket.getOutputStream());
            objectIn = new ObjectInputStream(clientSocket.getInputStream());
        }
        
        @Override
        public void run() {
            try {
                Object inputObject;
                while ((inputObject = objectIn.readObject()) != null) {
                    if (inputObject instanceof GameAction) {
                        GameAction action = (GameAction) inputObject;
                        server.processAction(action);
                    }
                }
            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    objectIn.close();
                    objectOut.close();
                    clientSocket.close();
                    clients.remove(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        public void sendMessage(Object message) {
            try {
                objectOut.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        GameServer.init(12345); // Port number
        GameServer.getInstance().start();
        SwingUtilities.invokeLater(() -> {
            ViewFactory.getInstance().getWaitingRoomView();
        });
    }
}
