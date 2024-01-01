package Utils.Networking;

import java.net.Socket;

class Connection {
    private Socket socket;
    
    
    public Connection(String ip, int port) throws Exception {
        this.socket = new Socket(ip, port);
    }
    
    public boolean isAlive() {
        return socket != null && socket.isConnected() && !socket.isClosed();
    }
}
