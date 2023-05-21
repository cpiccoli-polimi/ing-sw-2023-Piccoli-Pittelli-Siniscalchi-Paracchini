package it.polimi.server;

import it.polimi.observer.Observable;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClientConnection extends Observable<String> implements ClientConnection, Runnable{

    private Socket socket;
    private ObjectOutputStream out;
    private boolean active;
    private Server server;
    public SocketClientConnection(Socket socket, Server server){}
    private boolean isActive(){return active;}
    public void send(Object message){}
    @Override
    public void closeConnection(){}
    private void close(){}
    @Override
    public void asyncSend(Object message){}
    @Override
    public void run(){}
}
