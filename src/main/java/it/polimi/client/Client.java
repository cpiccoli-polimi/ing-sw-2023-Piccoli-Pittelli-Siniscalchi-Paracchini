package it.polimi.client;

import java.io.IOException;

public abstract class Client {
    private String ip;
    private int port;
    private boolean active = true;
    public Client(String ip, int port){
        this.ip = ip;
        this.port = port;
    }
    protected String getIP(){
        return this.ip;
    }
    protected int getPort(){
        return this.port;
    }
    public boolean isActive(){
        return active;
    }
    public synchronized void setActive(boolean active){
        this.active = active;
    }
    public void run() throws IOException {}
}
