package it.polimi.client;

import it.polimi.model.GameView;
import it.polimi.model.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;

public class ClientSceneController {
    private String ip;
    private int port;
    private boolean active = true;
    private String myPlayerName;
    Player myPlayer = null;
    Socket socket;
    ObjectInputStream socketIn;
    PrintWriter socketOut;
    FXMLLoader fxmlLoader;
    Parent root;
    Scene scene;
    WelcomeSceneController welcomeSceneController;
    GameSceneController gameSceneController;
    Stage stage;
    @FXML
    StackPane clientPane;

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
                            if(((String)inputObject).startsWith("YOURPLAYERIS:")){
                                myPlayerName = new String(((String)inputObject).substring(13));
                            }
                            else if(((String)inputObject).equals("Welcome\nWhat is your name?")){
                                showWelcomeScene();
                                showMessage((String)inputObject);
                            }
                            else{
                                showMessage((String) inputObject);
                            }
                        }
                        else if(inputObject instanceof GameView){

                            showGameScene((GameView) inputObject);
                            /*if (((GameView) inputObject).getLeaderboard()[0] == null) {
                            }
                            else{
                                System.out.println("LEADERBOARD:");
                                int i = 1;
                                for(Player player : ((GameView) inputObject).getLeaderboard()){
                                    System.out.println(i + ": " + player.getNickname() + " with " + player.getPoints() + "points");
                                }
                            }*/
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
    public void showScene(double sceneWidth, double sceneHeight) {

        clientPane.setMinWidth(sceneWidth);
        clientPane.setMinHeight(sceneHeight);
        clientPane.setPrefWidth(clientPane.getMinWidth());
        clientPane.setPrefHeight(clientPane.getMinHeight());
        clientPane.setMaxWidth(clientPane.getMinWidth());
        clientPane.setPrefHeight(clientPane.getMinHeight());
        clientPane.setBackground(new Background(new BackgroundImage(new Image("/GraphicalResources/Miscellaneous/parquetBackground.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false))));
        welcomeSceneController = null;
        gameSceneController = null;
    }
    public void showWelcomeScene(){

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        fxmlLoader = new FXMLLoader(getClass().getResource("/WelcomeScene.fxml"));
                        root = fxmlLoader.load();
                        if(gameSceneController == null){
                            stage = (Stage) clientPane.getScene().getWindow();
                        }
                        else{
                            stage = (Stage) gameSceneController.scenePane.getScene().getWindow();
                        }
                        scene = new Scene(root, clientPane.getPrefWidth(), clientPane.getPrefHeight());
                        stage.setScene(scene);
                        welcomeSceneController = fxmlLoader.getController();
                        welcomeSceneController.showScene(scene.getWidth(), scene.getHeight());
                        gameSceneController = null;
                        stage.show();

                        welcomeSceneController.confirmButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                String message = new String(welcomeSceneController.getMessage());
                                if(message.isEmpty() != true){
                                    socketOut.println(message);
                                    socketOut.flush();
                                }
                            }
                        });

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

    }
    public void showGameScene(GameView gameView){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    fxmlLoader = new FXMLLoader(getClass().getResource("/GameScene.fxml"));
                    root = fxmlLoader.load();
                    if(welcomeSceneController == null){
                        stage = (Stage) clientPane.getScene().getWindow();
                    }
                    else{
                        stage = (Stage) welcomeSceneController.welcomePane.getScene().getWindow();
                    }
                    scene = new Scene(root, clientPane.getPrefWidth(), clientPane.getPrefHeight());
                    stage.setScene(scene);
                    gameSceneController = fxmlLoader.getController();
                    gameSceneController.showScene(scene.getWidth(), scene.getHeight());
                    welcomeSceneController = null;

                    if(myPlayer == null){
                        for(Player player : gameView.getTable()){
                            if(myPlayerName.equals(player.getNickname())){
                                myPlayer = player;
                            }
                        }
                    }
                    gameSceneController.showBoardItems(gameView.getBoard());
                    gameSceneController.showPersonalGoal(myPlayer.getPersonalGoal());
                    gameSceneController.showCommonGoals(gameView.getBoard().getCommonGoals());
                    gameSceneController.showPlayer(myPlayer);
                    int i = 0;
                    for(Player opponent : gameView.getTable()){
                        if(myPlayer.getNickname().equals(opponent.getNickname()) == false){
                            gameSceneController.showOpponent(opponent, (StackPane) gameSceneController.opponentsPane.getChildren().get(i));
                            i++;
                        }
                    }
                    while(i < 3){
                        gameSceneController.opponentsPane.getChildren().get(i).setVisible(false);
                        i++;
                    }

                    if(myPlayer.getPosition() == gameView.getCurrPlayer()){
                        showMessage(gameView.getTurnPlayerMessage());

                        gameSceneController.confirmButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                //System.out.println("è il tuo turno");
                            }
                        });
                    }
                    else{
                        showMessage(gameView.getOtherPlayersMessage());

                        gameSceneController.confirmButton.setOnAction(null);
                    }

                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
    public void showMessage(String message){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(welcomeSceneController != null){
                    welcomeSceneController.showMessage(message + "\n");
                }
                else if(gameSceneController != null){
                    gameSceneController.showMessage(message);
                }
            }
        });
    }
    public void startCommunication(String ip, int port){
        try {
            socket = new Socket(ip, port);
            System.out.println("Connection established");
            socketIn = new ObjectInputStream((socket.getInputStream()));
            socketOut = new PrintWriter(socket.getOutputStream());

            Thread t0 = asyncReadFromSocket(socketIn);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
