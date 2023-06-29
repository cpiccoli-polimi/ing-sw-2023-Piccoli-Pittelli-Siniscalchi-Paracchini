package it.polimi.client;

import it.polimi.controller.exception.NotYourTurnException;
import it.polimi.model.GameView;
import it.polimi.model.ObjectCard;
import it.polimi.model.Player;
import it.polimi.model.Type;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientTUI{

    private String ip;
    private int port;
    private boolean active = true;
    private String myPlayerName;
    Player myPlayer = null;

    public ClientTUI(String ip, int port){
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
    public void printTurnMessage(String message, ObjectCard[] chosenObjects){
        char squareCharacter = 9632;

        if(message.startsWith("Choose up to 3")){
            message = message + "\nThe red numbers above and to the left of the board are the object cards coordinate" +
                    "\nTo choose an object card you have to type his coordinates written as follows: ROW, COLUMN" +
                    "\nTo choose multiple object cards you have to type their coordinates separate by a space";
        }
        else if(message.startsWith("In which bookshelf column")){
            message = message + "\nThe columns are numbered from 1 to 5, from left to right" +
                    "\nTo choose a column you have to type its corresponding number";
        }
        else if(message.startsWith("In which order")){
            String stringToPrecede = new String("These are the object cards you have removed from the board: ");
            int i = 1;
            for(ObjectCard card : chosenObjects){
                stringToPrecede = stringToPrecede + i + " " + card.getType().getColor() + squareCharacter + Type.RESET + "   ";
                i += 1;
            }
            stringToPrecede = stringToPrecede + "\n";
            stringToPrecede = stringToPrecede + message;
            stringToPrecede = stringToPrecede + "\nTo choose an order you have to type the numbers corresponding to each card in the desired order (the first card that will be inserted in the column is the one corresponding to the number 1)" +
                    "\nEach number must be separated by a space";
            message = new String(stringToPrecede);
        }
        System.out.println(message);
    }
    public Thread asyncReadFromSocket(ObjectInputStream socketIn){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(isActive()){
                        Object inputObject = socketIn.readObject();
                        if(inputObject instanceof String){
                            if(((String)inputObject).startsWith("YOURPLAYERIS:")){
                                myPlayerName = new String(((String)inputObject).substring(13));
                            }
                            else{
                                System.out.println((String) inputObject);
                            }
                        }
                        else if(inputObject instanceof GameView){
                            for(Player player : ((GameView) inputObject).getTable()){
                                if(myPlayerName.equals(player.getNickname())){
                                    myPlayer = player;
                                }
                            }
                            System.out.println("GAME BOARD:");
                            ((GameView) inputObject).getBoard().showBoard(((GameView) inputObject).getTable().length);
                            int j = 0;
                            for(int i = 0; i < ((GameView) inputObject).getBoard().getCommonGoals().length; i++){
                                j += 1;
                                if(((GameView) inputObject).getBoard().getCommonGoals()[i].getPoints().isEmpty()){
                                    System.out.println("Common goal " + j + ": " + ((GameView) inputObject).getBoard().getCommonGoals()[i].getGoalDescription() + "(0 points will be assigned to the next who achieves the described pattern)");

                                }
                                else{
                                    System.out.println("Common goal " + j + ": " + ((GameView) inputObject).getBoard().getCommonGoals()[i].getGoalDescription() + "("+ ((GameView) inputObject).getBoard().getCommonGoals()[i].getPoints().get(0).getValue() +" points will be assigned to the next who achieves the described pattern)");
                                }
                            }
                            for(Player player : ((GameView) inputObject).getTable()){
                                System.out.print(player.getNickname() + "'s BOOKSHELF:    \t ");
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
                            if(myPlayer.getPosition() == ((GameView) inputObject).getCurrPlayer()){
                                printTurnMessage(((GameView) inputObject).getTurnPlayerMessage(), myPlayer.getChosenObjects());
                            }
                            else{
                                System.out.println(((GameView) inputObject).getOtherPlayersMessage());
                            }
                            if (((GameView) inputObject).getLeaderboard()[0] != null){
                                System.out.println("The game has ended\nThis is the LEADERBOARD:");
                                int i = 1;
                                for(Player player : ((GameView) inputObject).getLeaderboard()){
                                    System.out.println(i + ": " + player.getNickname() + " with " + player.getPoints() + "points");
                                }
                                System.out.println("\n\n\nIf you want to play another game, relaunch the app");
                            }
                        }
                        else if(inputObject instanceof Exception){
                            String exceptionMessage = new String(((Exception) inputObject).getMessage());
                            if(inputObject instanceof NotYourTurnException == false){
                                exceptionMessage = exceptionMessage + "\nPlease retry";
                            }
                            System.out.println(exceptionMessage);
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
        Socket socket = new Socket(getIP(), getPort());
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
