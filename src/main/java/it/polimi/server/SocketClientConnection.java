package it.polimi.server;

import it.polimi.model.Player;
import it.polimi.observer.Observable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SocketClientConnection extends Observable<String> implements ClientConnection, Runnable{

    private Socket socket;
    private ObjectOutputStream out;
    private boolean active = true;
    private Server server;
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
    public synchronized void closeConnection(){
        send("Connection closed");
        try{
            socket.close();
        }
        catch(IOException e){
            System.err.println("Error when closing socket");
        }
        active = false;
    }
    private void close(){
        closeConnection();
        System.out.println("Deregistering client...");
        server.deregisterConnection(this);
        System.out.println("Done");
    }
    @Override
    public void asyncSend(final Object message){
        new Thread(new Runnable() {
            @Override
            public void run() {
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
            while(isActive() && server.getModel().getDone() == false){
                message = in.nextLine();
                message = "OBJECTCARDSCHOICE:" + message;
                notify(message);
                message = in.nextLine();
                message = "BOOKSHELFCOLUMNCHOICE:" + message;
                notify(message);
                message = in.nextLine();
                message = "INSERTIONORDERCHOICE:" + message;
                notify(message);
            }
            while(isActive() && server.getModel().getCurrentPlayer() != 0){
                message = in.nextLine();
                message = "OBJECTCARDSCHOICE:" + message;
                notify(message);
                message = in.nextLine();
                message = "BOOKSHELFCOLUMNCHOICE:" + message;
                notify(message);
                message = in.nextLine();
                message = "INSERTIONORDERCHOICE:" + message;
                notify(message);
            }
            if(isActive()){
                message = "LEADERBOARD:";
                notify(message);
            }
        }
        catch(IOException | NoSuchElementException e){
            System.err.println("Error " + e.getMessage());
        }
        finally{
            close();
        }
    }
}
