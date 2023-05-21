package it.polimi.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class Server {

    private int PORT;
    private ServerSocket serverSocket;
    private ExecutorService executor;
    private Map<String, ClientConnection> waitingConnection;

    public Server(){};
    public void deregisterConnection(ClientConnection c){}
    public void lobby(ClientConnection c, String name, Socket socket){}
    public void run(){}
}
