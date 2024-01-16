package Networking;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import Models.Player;
import Models.Token;
import UI.View.ViewFactory;
import Utils.AssetLoader;

import javax.swing.*;
import javax.swing.text.View;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class GameServer implements Publisher {
    private ServerSocket serverSocket;
    private ArrayList<Listener> listeners;
    
    private ConcurrentHashMap<ClientHandler, Boolean> clients = new ConcurrentHashMap<>();
    
    public GameServer(int port) throws IOException {
        this.listeners = new ArrayList<>();
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);
        

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
            add_player(action.getDetails(),action.getTokens());
            publishEvent(Type.PLAYER_ADDED);
        }
        
        System.out.println("IN: GameAction type: " + action.getActionType());
        System.out.println("            Details: " + action.getDetails());
        
        broadcastUpdate(action);
    }
    private void add_player(String name, AssetLoader.Tokens tokens){
        new Player(name, new Token("Player Token",tokens.getPath()));
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
        GameServer server = new GameServer(12345); // Port number
        server.start();
        SwingUtilities.invokeLater(() -> {
            ViewFactory.getInstance().getWaitingRoomView();
        });
    }
}
