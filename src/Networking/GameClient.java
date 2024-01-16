package Networking;

import java.io.*;
import java.net.*;

public class GameClient {
    private Socket socket;
    private ObjectInputStream objectIn;
    private ObjectOutputStream objectOut;
    
    public GameClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        objectOut = new ObjectOutputStream(socket.getOutputStream());
        objectIn = new ObjectInputStream(socket.getInputStream());
        new Thread(this::listenToServer).start();
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
        System.out.println("IN    : processing action type: " + action.getActionType());
        System.out.println("      : processing action details: " + action.getDetails());
    }
    
    public static void main(String[] args) throws IOException {
        GameClient client = new GameClient("localhost", 12345);
        // Example: send an action
        GameAction action = new GameAction(GameAction.ActionType.UPDATE_PLAYER, "Player1 got 2 Feather ingredient.");
        client.sendAction(action);
        
        GameAction action1 = new GameAction(GameAction.ActionType.UPDATE_DECK, "Drew 1 card from deck");
        client.sendAction(action1);
    }
}

