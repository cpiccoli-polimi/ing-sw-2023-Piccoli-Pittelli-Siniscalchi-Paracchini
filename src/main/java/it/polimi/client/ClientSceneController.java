package it.polimi.client;

import it.polimi.controller.exception.NotYourTurnException;
import it.polimi.model.GameView;
import it.polimi.model.ObjectCard;
import it.polimi.model.Player;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
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
    Pane activePane;
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
                            else{
                                if(((String)inputObject).equals("Welcome\nWhat is your name?")){
                                    showWelcomeScene();
                                }
                                showMessage((String)inputObject);
                            }
                        }
                        else if(inputObject instanceof GameView){
                            showGameScene((GameView) inputObject, ((GameView) inputObject).getLeaderboard()[0] != null);
                        }
                        else if(inputObject instanceof Exception){
                            String exceptionMessage = new String(((Exception) inputObject).getMessage());
                            if(inputObject instanceof NotYourTurnException == false){
                                exceptionMessage = exceptionMessage + "\nPlease retry";
                            }
                            showMessage(exceptionMessage);
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
        activePane = clientPane;
    }
    public void showWelcomeScene(){

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        fxmlLoader = new FXMLLoader(getClass().getResource("/ScenesFXMLs/WelcomeScene.fxml"));
                        root = fxmlLoader.load();
                        stage = (Stage) activePane.getScene().getWindow();
                        scene = new Scene(root, clientPane.getPrefWidth(), clientPane.getPrefHeight());

                        stage.setScene(scene);
                        welcomeSceneController = fxmlLoader.getController();
                        welcomeSceneController.showScene(scene.getWidth(), scene.getHeight());
                        activePane = welcomeSceneController.welcomePane;
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

                        welcomeSceneController.playerTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent event) {
                                if(event.getCode().equals(KeyCode.ENTER)) {
                                    String message = new String(welcomeSceneController.getMessage());
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
    public void showGameScene(GameView gameView, boolean showLeaderboard){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    fxmlLoader = new FXMLLoader(getClass().getResource("/ScenesFXMLs/GameScene.fxml"));
                    root = fxmlLoader.load();
                    stage = (Stage) activePane.getScene().getWindow();
                    scene = new Scene(root, clientPane.getPrefWidth(), clientPane.getPrefHeight());
                    stage.setScene(scene);
                    gameSceneController = fxmlLoader.getController();
                    gameSceneController.showScene(scene.getWidth(), scene.getHeight());
                    activePane = gameSceneController.scenePane;

                    for(Player player : gameView.getTable()){
                        if(myPlayerName.equals(player.getNickname())){
                            myPlayer = player;
                        }
                    }

                    gameSceneController.showBoardItems(gameView.getBoard());
                    gameSceneController.showPersonalGoal(myPlayer.getPersonalGoal());
                    gameSceneController.showCommonGoals(gameView.getBoard().getCommonGoals());
                    gameSceneController.showPlayer(myPlayer);
                    int tmpCounter = 0;
                    for(Player opponent : gameView.getTable()){
                        if(myPlayer.getNickname().equals(opponent.getNickname()) == false){
                            gameSceneController.showOpponent(opponent, (StackPane) gameSceneController.opponentsPane.getChildren().get(tmpCounter));
                            tmpCounter++;
                        }
                    }
                    while(tmpCounter < 3){
                        gameSceneController.opponentsPane.getChildren().get(tmpCounter).setVisible(false);
                        tmpCounter++;
                    }

                    if(myPlayer.getPosition() == gameView.getCurrPlayer()){

                        if(gameView.getTurnPlayerMessage().startsWith("Choose up to 3")){
                            showMessage(gameView.getTurnPlayerMessage());

                            for(Node child : gameSceneController.boardItemsPane.getChildren()){

                                if(((ToggleButton)child).isDisable() != true){

                                    ((ToggleButton)child).setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            if(((ToggleButton)child).isSelected()){
                                                ((ToggleButton)child).setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
                                            }
                                            else{
                                                ((ToggleButton)child).setBorder(null);
                                            }
                                        }
                                    });
                                }
                            }
                            gameSceneController.confirmButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    String message = new String("");
                                    for(int i = 0; i < gameSceneController.boardItemsPane.getRowCount(); i++){
                                        for(int j =0; j < gameSceneController.boardItemsPane.getColumnCount(); j++){
                                            if(((ToggleButton)gameSceneController.boardItemsPane.getChildren().get((i * gameSceneController.boardItemsPane.getRowCount())+ j)).isSelected()){
                                                int h = i;
                                                int k = j;
                                                h += 1;
                                                k += 1;
                                                message = message + h + "," + k + " ";

                                            }
                                        }
                                    }
                                    socketOut.println(message);
                                    socketOut.flush();
                                }
                            });
                        }
                        else if(gameView.getTurnPlayerMessage().startsWith("In which bookshelf column")){
                            showMessage(gameView.getTurnPlayerMessage());

                            ToggleGroup toggleGroup = new ToggleGroup();

                            toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                                    if (toggleGroup.getSelectedToggle() != null) {
                                        ((ToggleButton)new_toggle).setBorder(new Border(new BorderStroke(Color.LIGHTGREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
                                        if(old_toggle != null){
                                            ((ToggleButton)old_toggle).setBorder(null);
                                        }
                                    }
                                }
                            });

                            for(int i = 0; i < gameSceneController.myBookshelfItemsPane.getColumnCount(); i++){
                                ToggleButton button = new ToggleButton();

                                button.setPrefWidth((gameSceneController.columnSelectionPane.getPrefWidth() - gameSceneController.columnSelectionPane.getSpacing()*(gameSceneController.myBookshelfItemsPane.getColumnCount()-1))/gameSceneController.myBookshelfItemsPane.getColumnCount());
                                button.setPrefHeight(gameSceneController.columnSelectionPane.getPrefHeight());
                                button.setMinWidth(button.getPrefWidth());
                                button.setMinHeight(button.getPrefHeight());
                                button.setMaxWidth(button.getPrefWidth());
                                button.setMaxHeight(button.getPrefHeight());
                                button.setText(null);
                                button.setBackground(null);

                                button.setToggleGroup(toggleGroup);

                                gameSceneController.columnSelectionPane.getChildren().add(button);
                            }
                            gameSceneController.confirmButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    String message = new String("");
                                    for(Node child : gameSceneController.columnSelectionPane.getChildren()){
                                        if(((ToggleButton)child).isSelected()){
                                            int h = gameSceneController.columnSelectionPane.getChildren().indexOf(child);
                                            h += 1;
                                            message = message + h;
                                        }
                                    }
                                    socketOut.println(message);
                                    socketOut.flush();
                                }
                            });
                        }
                        else if(gameView.getTurnPlayerMessage().startsWith("In which order")){

                            String newTurnMessage = new String("These are the cards you have removed from the board");
                            newTurnMessage = newTurnMessage + gameView.getTurnPlayerMessage();
                            newTurnMessage = newTurnMessage + "\nTo choose an order, use the MenuButtons on the right" +
                                    "\nClick the send button on the right when you have chosen the desired insertion order";
                            showMessage(newTurnMessage);

                            gameSceneController.messageTextPane.setPrefWidth(gameSceneController.messageTextPane.getPrefWidth() - ((gameSceneController.messageTextPane.getPrefHeight() + gameSceneController.separator.getPrefWidth()) *  myPlayer.getChosenObjects().length));
                            gameSceneController.messageTextPane.setMinWidth(gameSceneController.messageTextPane.getPrefWidth());
                            gameSceneController.messageTextPane.setMaxWidth(gameSceneController.messageTextPane.getPrefWidth());

                            int i = 0;
                            for(ObjectCard card : myPlayer.getChosenObjects()){


                                Separator separator = new Separator(Orientation.HORIZONTAL);
                                separator.setPrefWidth(gameSceneController.separator.getPrefWidth());
                                separator.setPrefHeight(gameSceneController.separator.getPrefHeight());
                                separator.setVisible(false);

                                i += 1;
                                gameSceneController.messagePane.getChildren().add(i, separator);

                                FlowPane pane = new FlowPane(Orientation.VERTICAL);
                                pane.setPrefWidth(gameSceneController.messageTextPane.getPrefHeight());
                                pane.setPrefHeight(gameSceneController.messageTextPane.getPrefHeight());
                                pane.setMinWidth(pane.getPrefWidth());
                                pane.setMinHeight(pane.getPrefHeight());
                                pane.setMaxWidth(pane.getPrefWidth());
                                pane.setMaxHeight(pane.getPrefHeight());
                                pane.setAlignment(Pos.CENTER);

                                i += 1;
                                gameSceneController.messagePane.getChildren().add(i, pane);

                                String cardPath = new String("/GraphicalResources/ItemTiles/");
                                cardPath = cardPath + card.getType().toString().toLowerCase() + ".png";

                                ImageView cardImage = new ImageView();
                                cardImage.setFitHeight(pane.getPrefHeight() * 0.73);
                                cardImage.setFitWidth(cardImage.getFitHeight());
                                cardImage.setImage(new Image(cardPath, cardImage.getFitWidth(), cardImage.getFitHeight(), true, false));

                                ToggleGroup toggleGroup = new ToggleGroup();

                                HBox buttonPane = new HBox();
                                buttonPane.setPrefWidth(pane.getPrefWidth());
                                buttonPane.setPrefHeight(pane.getPrefHeight() * 0.25);
                                buttonPane.setSpacing(buttonPane.getPrefWidth()*0.05);

                                for(int j = 1; j < myPlayer.getChosenObjects().length + 1; j++){
                                    ToggleButton button = new ToggleButton(String.valueOf(j));
                                    button.setPrefWidth((cardImage.getFitWidth() - (buttonPane.getSpacing() * (myPlayer.getChosenObjects().length - 1)) ) / myPlayer.getChosenObjects().length);
                                    button.setPrefHeight(buttonPane.getPrefHeight());
                                    button.setMinWidth(button.getPrefWidth());
                                    button.setMinHeight(button.getPrefHeight());
                                    button.setMaxWidth(button.getPrefWidth());
                                    button.setMaxHeight(button.getPrefHeight());
                                    button.setTextAlignment(TextAlignment.CENTER);

                                    if(button.getPrefHeight() > button.getPrefWidth()){
                                        button.setFont(new Font("Arial", button.getPrefWidth() * 0.50));
                                    }
                                    else{
                                        button.setFont(new Font("Arial", button.getPrefHeight() * 0.50));
                                    }
                                    button.setToggleGroup(toggleGroup);

                                    buttonPane.getChildren().add(button);
                                }

                                pane.getChildren().add(cardImage);
                                pane.getChildren().add(buttonPane);
                                pane.setMargin(cardImage, new Insets(0, 0, pane.getPrefHeight() * 0.01, 0));

                            }

                            gameSceneController.confirmButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    String message = new String("");

                                    for(int i = 1; i < myPlayer.getChosenObjects().length + 1; i++) {
                                        FlowPane pane = (FlowPane) gameSceneController.messagePane.getChildren().get(2 * i);
                                        HBox buttonPane = (HBox) pane.getChildren().get(1);
                                        for(Node child : buttonPane.getChildren()){
                                            if(((ToggleButton)child).isSelected()){
                                                message = message + ((ToggleButton)child).getText() + " ";
                                            }
                                        }
                                    }

                                    socketOut.println(message);
                                    socketOut.flush();
                                }
                            });
                        }
                    }
                    else{
                        showMessage(gameView.getOtherPlayersMessage());

                        gameSceneController.confirmButton.setOnAction(null);
                    }

                    if(showLeaderboard == true){
                        gameSceneController.showLeaderboard(gameView.getLeaderboard());
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
                if(activePane == welcomeSceneController.welcomePane){
                    welcomeSceneController.showMessage(message + "\n");
                }
                else if(activePane == gameSceneController.scenePane){
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
