package it.polimi.server;

import it.polimi.controller.exception.NotYourTurnException;
import it.polimi.model.Game;
import it.polimi.model.GameView;
import it.polimi.model.Player;
import it.polimi.observer.Observable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SocketClientConnection extends Observable<String> implements ClientConnection, Runnable {

    private Socket socket;
    private ObjectOutputStream out;
    private boolean active = true;
    private Server server;
    private boolean notYourTurnFlag = false;
    private int expectedMessageNumber = 0;
    private Game model;
    public SocketClientConnection(Socket socket, Server server){
        this.socket = socket;
        this.server = server;
    }
    private boolean isActive(){
        return active;
    }
    public synchronized void send(Object message){
        try{
            out.reset();
            out.writeObject(message);
            out.flush();
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
    @Override
    public synchronized void closeConnection(String closingMessage){
        send(closingMessage);
        try{
            wait(3000);
            socket.close();
        }
        catch(IOException e){
            System.err.println("Error when closing socket");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        active = false;
    }
    protected void close(String closingMessage){
        closeConnection(closingMessage);
        System.out.println("Deregistering client...");
        if(closingMessage.startsWith("Closed")){
            server.deregisterConnection(this);
        }
        System.out.println("Done");
    }
    @Override
    public void asyncSend(final Object message){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(message instanceof Exception){
                    if(message instanceof NotYourTurnException){
                        notYourTurnFlag = true;
                    }
                    else{
                        notYourTurnFlag = false;
                        if(expectedMessageNumber == 0){
                            expectedMessageNumber = 0;
                        }
                        else{
                            expectedMessageNumber -= 1;
                        }
                    }
                }
                else if(message instanceof GameView){
                    if(((GameView) message).getTurnPlayerMessage().equals("Choose up to 3 object cards from the board that you want to put in a column of your own library")){
                        notYourTurnFlag = false;
                        expectedMessageNumber = 0;
                    }
                }
                send(message);
            }
        }).start();
    }
    @Override
    public void run(){
        Scanner in;
        String nickname;

        try{
            in = new Scanner(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            send("Welcome\nWhat is your name?");
            String message = in.nextLine();
            nickname = message;
            server.lobby(this, nickname, socket);
            while(isActive()){
                while(model.getDone() == false){
                    message = in.nextLine();
                    if(notYourTurnFlag == false){
                        if(expectedMessageNumber==3){
                            expectedMessageNumber=0;
                        }
                        else if(expectedMessageNumber == 0){
                            message = "OBJECTCARDSCHOICE:" + message;
                            expectedMessageNumber++;
                        }
                        else if(expectedMessageNumber == 1){
                            message = "BOOKSHELFCOLUMNCHOICE:" + message;
                            expectedMessageNumber++;
                        }
                        else if(expectedMessageNumber == 2){
                            message = "INSERTIONORDERCHOICE:" + message;
                            expectedMessageNumber++;
                        }

                    }
                    notify(message);
                }
                int i = 0;
                while(model.getTable()[i].getPosition() != model.getCurrentPlayer()){
                    i += 1;
                }
                Player currentPlayer = model.getTable()[i];
                while(currentPlayer.getIsFirst() == false){
                    message = in.nextLine();
                    if(notYourTurnFlag == false){
                        if(expectedMessageNumber==3){
                            expectedMessageNumber=0;
                        }
                        else if(expectedMessageNumber == 0){
                            message = "OBJECTCARDSCHOICE:" + message;
                            expectedMessageNumber++;
                        }
                        else if(expectedMessageNumber == 1){
                            message = "BOOKSHELFCOLUMNCHOICE:" + message;
                            expectedMessageNumber++;
                        }
                        else if(expectedMessageNumber == 2){
                            message = "INSERTIONORDERCHOICE:" + message;
                            expectedMessageNumber++;
                        }
                    }
                    notify(message);
                }
            }
        }
        catch(IOException | NoSuchElementException e){
            System.err.println("Error " + e.getMessage());
        }
        finally{
            close("Closed connection");
        }
    }
    public void setModel(Game model) {
        this.model = model;
    }
}
