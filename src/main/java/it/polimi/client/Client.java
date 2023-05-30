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
    private String myPlayerName = new String("");
    Player myPlayer = null;

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
                            String[] splitAttempt = ((String) inputObject).split(":");
                            if(splitAttempt[0].equals("YOURPLAYERIS")){
                                myPlayerName = myPlayerName.concat(splitAttempt[1]);
                            }
                            else{
                                System.out.println((String) inputObject);
                            }
                        }
                        else if(inputObject instanceof GameView){
                            if (((GameView) inputObject).getLeaderboard()[0] == null){
                                if(myPlayer == null){
                                    for(Player player : ((GameView) inputObject).getTable()){
                                        if(myPlayerName.equals(player.getNickname())){
                                            myPlayer = player;
                                        }
                                    }
                                }
                                System.out.println("GAME BOARD:");
                                ((GameView) inputObject).getBoard().showBoard(((GameView) inputObject).getTable().length);
                                int j = 0;
                                for(int i = 0; i < ((GameView) inputObject).getBoard().getCommonGoals().length; i++){
                                    j += 1;
                                    System.out.println("Common goal " + j + ": " + ((GameView) inputObject).getBoard().getCommonGoals()[i].getGoalDescription());
                                }
                                for(Player player : ((GameView) inputObject).getTable()){
                                    System.out.print(player.getNickname() + "'s BOOKSHELF: \t ");
                                }
                                System.out.println("YOUR PERSONAL GOAL:");
                                System.out.println();
                                for(int i = 0; i < ((GameView) inputObject).getTable()[0].getBookshelf().getShelf().length; i++){
                                    for(Player player : ((GameView) inputObject).getTable()){
                                        System.out.print(player.getBookshelf().showBookshelf(i));
                                        for(char character : player.getNickname().toCharArray()){
                                            System.out.print(" ");
                                        }
                                        System.out.print("    \t ");
                                    }
                                    System.out.print(myPlayer.getPersonalGoal().getGoal().showBookshelf(i));
                                    System.out.println();
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
                        else if(inputObject instanceof Exception){
                            System.out.println(((Exception) inputObject).getMessage());
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
