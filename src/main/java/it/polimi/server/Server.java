package it.polimi.server;

import it.polimi.controller.GameController;
import it.polimi.model.Game;
import it.polimi.model.GameView;
import it.polimi.model.Player;
import it.polimi.model.exception.CommonGoalsNumberException;
import it.polimi.model.exception.PlayersNumberException;
import it.polimi.view.RemoteView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Remote;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private int PORT = 12345;
    private ServerSocket serverSocket;
    private ExecutorService executor = Executors.newFixedThreadPool(128);
    private Map<String, ClientConnection> waitingConnection = new HashMap<>();
    private Map<Player, ClientConnection> clientConnections = new HashMap<>();
    private Map<Player, RemoteView> playerRemoteViews = new HashMap<>();

    Game model;
    GameController controller;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    };
    public void deregisterConnection(ClientConnection c){
        for(Player player : clientConnections.keySet()){
            if(clientConnections.get(player) == c){
                clientConnections.remove(player);
                playerRemoteViews.remove(player);
            }
        }
    }
    public void lobby(ClientConnection c, String nickname, Socket socket){
        int playersNumber = -1;
        int commonGoalsNumber = -1;
        List<String> keys = new ArrayList<>(waitingConnection.keySet());
        for(int i = 0; i < keys.size(); i++){
            ClientConnection connection = waitingConnection.get(keys.get(i));
            connection.asyncSend("Connected user: " + keys.get(i));
        }
        while(waitingConnection.containsKey(nickname) == true){
            try{
                c.asyncSend("A player with your same nickname is already present in this game. Please try submitting a different nickname");
                Scanner in = new Scanner(socket.getInputStream());
                nickname = in.nextLine();
            }
            catch(IOException e){
                throw new RuntimeException(e);
            }
        }
        waitingConnection.put(nickname, c);
        if(waitingConnection.size() == 1){
            try{
                Scanner in = new Scanner(socket.getInputStream());
                String message;
                while(playersNumber == -1){
                    c.asyncSend("How many players will play this game?");
                    message = in.nextLine();
                    playersNumber = Integer.valueOf(message);
                    if(playersNumber < 2 || playersNumber > 4){
                        playersNumber = -1;
                    }
                }
                while(commonGoalsNumber == -1){
                    c.asyncSend("With how many common goals do you want to play this game?");
                    message = in.nextLine();
                    commonGoalsNumber = Integer.valueOf(message);
                    if(commonGoalsNumber != 1 || commonGoalsNumber != 2){
                        commonGoalsNumber = -1;
                    }
                }
            }
            catch(IOException e){
                throw new RuntimeException(e);
            }
        }
        keys = new ArrayList<>(waitingConnection.keySet());
        if(waitingConnection.size() == playersNumber){
            try {
                model = new Game(playersNumber, commonGoalsNumber);
                controller = new GameController(model);
                int i = 0;
                for(ClientConnection connection : waitingConnection.values()) {
                    model.setTable(new Player(keys.get(i), model.getCommonGoalsNumber()), i);
                    Player player = model.getTable()[i];
                    RemoteView playerView = new RemoteView(player, connection);
                    playerView.addObserver(controller);
                    model.addObserver(playerView);
                    clientConnections.put(player, connection);
                    playerRemoteViews.put(player, playerView);
                    i++;
                }
                waitingConnection.clear();
                for(Player player : model.getTable()){
                    clientConnections.get(player).asyncSend(new GameView(model, ""));
                    if(player == model.getTable()[model.getCurrentPlayer()]){
                        clientConnections.get(player).asyncSend("Choose up to 3 object cards from the board that you want to put in a column of your own library");
                    }
                    else{
                        clientConnections.get(player).asyncSend("Now it's " + model.getTable()[model.getCurrentPlayer()].getNickname() + "'s turn. Wait your turn");
                    }
                }
            } catch (PlayersNumberException | CommonGoalsNumberException | FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public void run(){
        int connections = 0;
        System.out.println("Server is running");
        while(true){
            try{
                Socket newSocket = serverSocket.accept();
                connections++;
                System.out.println("Ready for the new connection - " + connections);
                SocketClientConnection socketConnection = new SocketClientConnection(newSocket, this);
                executor.submit(socketConnection);
            }
            catch(IOException e){
                System.out.println("Connection error!");
            }
        }
    }

    public Game getModel(){
        return model;
    }
}
