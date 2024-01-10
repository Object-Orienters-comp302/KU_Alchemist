package Networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class GameServer {
    private ServerSocket serverSocket;
    private ConcurrentHashMap<ClientHandler, Boolean> clients = new ConcurrentHashMap<>();
    
    public GameServer(int port) throws IOException {
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
    
    public synchronized GameServer broadcastUpdate(GameAction updateAction) {
        
        for (ClientHandler client : clients.keySet()) {
            System.out.println("OUT: Broadcasting update to " + client.toString());
            client.sendMessage(updateAction);
        }
        
        return this;
    }
    
    public synchronized GameServer processAction(GameAction action) {
        // TODO: Process action and update game state
        // For now, just echo the action
        
        System.out.println("IN: GameAction type: " + action.getActionType());
        System.out.println("            Details: " + action.getDetails());
        
        broadcastUpdate(action);
        
        return this;
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
        
        public ClientHandler sendMessage(Object message) {
            try {
                objectOut.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return this;
        }
    }
    
    public static void main(String[] args) throws IOException {
        new GameServer(12345).start();
    }
}
