package Utils.Networking;

import java.net.Socket;

public class NetworkingManager {
    private static NetworkingManager single_instance = null;
    private static Connection single_connection = null;
    
    private NetworkingManager() { }
    
    // Singleton pattern for NetworkingManager
    public static NetworkingManager getInstance() throws Exception {
        if (single_instance == null || single_connection == null || !single_connection.isAlive()) {
            throw new Exception("Cannot obtain NetworkingManager instance without an active connection");
        }
        return single_instance;
    }
    
    // Initializes the connection with IP and port, throws exception if not valid.
    public static void initManager(String ip, int port) throws Exception {
        if (single_connection == null) {
            single_connection = new Connection(ip, port);
            
            if (!single_connection.isAlive()) {
                throw new Exception("Failed to initialize the connection");
            }
        }
        
        if (single_instance == null) {
            single_instance = new NetworkingManager();
        }
    }
}

