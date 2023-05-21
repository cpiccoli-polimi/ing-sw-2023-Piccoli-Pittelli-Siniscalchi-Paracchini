package it.polimi.client;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Client {

    private String ip;
    private int port;
    private boolean active;
    public Client(String ip, int port){}
    public boolean isActive(){return active;}
    public void setActive(boolean active){}
    public Thread asyncReadFromSocket(ObjectInputStream socketIn){}
    public Thread asyncWriteToSocket(Scanner stdin, PrintWriter socketOut){}
    public void run(){}
}
