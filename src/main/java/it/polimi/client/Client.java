package it.polimi.client;

import it.polimi.model.GameView;
import it.polimi.model.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {

    private String ip;
    private int port;
    private boolean active = true;
    public Client(String ip, int port){
        this.ip = ip;
        this.port = port;
    }
    public boolean isActive(){
        return active;
    }
    public synchronized void setActive(boolean active){
        this.active = active;
    }
    public Thread asyncReadFromSocket(ObjectInputStream socketIn){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(isActive()){
                        Object inputObject = socketIn.readObject();
                        if(inputObject instanceof String){
                            System.out.println((String) inputObject);
                        }
                        else if(inputObject instanceof GameView){
                            if (((GameView) inputObject).getLeaderboard()[0] == null){
                                System.out.println("GAME BOARD:");
                                ((GameView) inputObject).getBoard().showBoard(((GameView) inputObject).getTable().length);
                                for(Player player : ((GameView) inputObject).getTable()){
                                    System.out.println(player.getNickname() + "'s BOOKSHELF:");
                                    player.getBookshelf().showBookshelf();
                                }
                            }
                            else{
                                System.out.println("LEADERBOARD:");
                                int i = 1;
                                for(Player player : ((GameView) inputObject).getLeaderboard()){
                                    System.out.println(i + ": " + player.getNickname() + " with " + player.getPoints() + "points");
                                }
                            }
                        }
                    }
                }
                catch(Exception e){
                    setActive(false);
                }
            }
        });
        t.start();
        return t;
    }
    public Thread asyncWriteToSocket(Scanner stdin, PrintWriter socketOut){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(isActive()){
                        String inputLine = stdin.nextLine();
                        socketOut.println(inputLine);;
                        socketOut.flush();
                    }
                }
                catch(Exception e){
                    setActive(false);
                }
            }
        });
        t.start();
        return t;
    }
    public void run() throws IOException {
        Socket socket = new Socket(ip, port);
        System.out.println("Connection established");
        ObjectInputStream socketIn = new ObjectInputStream((socket.getInputStream()));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
        Scanner stdin = new Scanner(System.in);

        try{
            Thread t0 = asyncReadFromSocket(socketIn);
            Thread t1 = asyncWriteToSocket(stdin, socketOut);
            t0.join();
            t1.join();
        }
        catch(InterruptedException | NoSuchElementException e){
            System.out.println("Connection closed from the client side");
        }
        finally{
            stdin.close();
            socketIn.close();
            socketOut.close();
            socket.close();
        }
    }
}
