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

    Game model = null;
    GameController controller;
    int playersNumber;
    int commonGoalsNumber;
    public Server() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    };
    public void deregisterConnection(ClientConnection c){
        for(String nickname : waitingConnection.keySet()){
            if(waitingConnection.get(nickname) == c){
                waitingConnection.remove(nickname);
            }
        }
        for(Player player : clientConnections.keySet()){
            if(clientConnections.get(player) == c){
                clientConnections.remove(player);
                playerRemoteViews.remove(player);
            }
        }
    }
    public synchronized void lobby(ClientConnection c, String nickname, Socket socket){
        List<String> keys = new ArrayList<>(waitingConnection.keySet());
        while(waitingConnection.containsKey(nickname) == true || nickname.isBlank()){
            try{
                if(waitingConnection.containsKey(nickname) == true){
                    c.asyncSend("A player with your same nickname is already present in this game\nPlease try submitting a different nickname");
                }
                else if(nickname.isBlank()){
                    c.asyncSend("A player nickname can't be blank\nPlease try submitting a nickname");
                }
                Scanner in = new Scanner(socket.getInputStream());
                nickname = in.nextLine();
            }
            catch(IOException e){
                throw new RuntimeException(e);
            }
        }
        c.asyncSend("YOURPLAYERIS:" + nickname);
        if(model != null){
            ((SocketClientConnection)c).setModel(model);
        }
        waitingConnection.put(nickname, c);
        if(waitingConnection.size() == 1){
            try{
                Scanner in = new Scanner(socket.getInputStream());
                String message;

                c.asyncSend("How many players will play this game?");
                message = in.nextLine();
                try {
                    playersNumber = Integer.valueOf(message);
                } catch (NumberFormatException e) {
                    playersNumber = 0;
                }
                while(playersNumber < 2 || playersNumber > 4){
                    c.asyncSend("The players number can only go from 2 to 4 and it must contain only digits. Please try submitting a different players number");
                    message = in.nextLine();
                    try {
                        playersNumber = Integer.valueOf(message);
                    } catch (NumberFormatException e) {
                        playersNumber = 0;
                    }
                }

                c.asyncSend("With how many common goals do you want to play this game?");
                message = in.nextLine();
                try {
                    commonGoalsNumber = Integer.valueOf(message);
                } catch (NumberFormatException e) {
                    commonGoalsNumber = 0;
                }
                while(commonGoalsNumber != 1 && commonGoalsNumber != 2){
                    c.asyncSend("The common goals number can only go from 1 to 2 and it must contain only digits. Please try submitting a different common goals number");
                    message = in.nextLine();
                    try {
                        commonGoalsNumber = Integer.valueOf(message);
                    } catch (NumberFormatException e) {
                        commonGoalsNumber = 0;
                    }
                }
                model = new Game(playersNumber, commonGoalsNumber);
                ((SocketClientConnection)c).setModel(model);
            }
            catch(IOException | PlayersNumberException | CommonGoalsNumberException e){
                throw new RuntimeException(e);
            }
        }
        c.asyncSend("Waiting for the others players to join the game");
        keys = new ArrayList<>(waitingConnection.keySet());
        if(waitingConnection.size() == playersNumber){
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
            controller.setup();
            waitingConnection.clear();
            i = 0;
            while(model.getTable()[i].getPosition() != model.getCurrentPlayer()){
                i += 1;
            }
            Player currentPlayer = model.getTable()[i];
            String turnPlayerMessage = new String("Choose up to 3 object cards from the board that you want to put in a column of your own library");
            String otherPlayersMessage = new String("Now it's " + currentPlayer.getNickname() + "'s turn\nWait your turn");
            for(Player player : model.getTable()){
                clientConnections.get(player).asyncSend(new GameView(model, turnPlayerMessage, otherPlayersMessage));
            }
            playersNumber = -1;
            commonGoalsNumber = -1;
            model = null;
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
