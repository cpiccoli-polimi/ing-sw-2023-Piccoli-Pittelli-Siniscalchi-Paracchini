package it.polimi.client;

import it.polimi.model.*;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class GameSceneController{
    @FXML
    StackPane scenePane;
    @FXML
    FlowPane gamePane;
    @FXML
    BorderPane tablePane;
    @FXML
    StackPane boardPane;
    @FXML
    ImageView boardImage;
    @FXML
    ImageView endGameToken;
    @FXML
    GridPane boardItemsPane;
    @FXML
    BorderPane goalsPane;
    @FXML
    ImageView personalGoal;
    @FXML
    FlowPane commonGoalsPane;
    @FXML
    StackPane commonGoal1Pane;
    @FXML
    ImageView pointsCommonGoal1;
    @FXML
    StackPane commonGoal2Pane;
    @FXML
    ImageView pointsCommonGoal2;
    @FXML
    StackPane myPane;
    @FXML
    TextFlow myTextPane;
    @FXML
    Text myText;
    @FXML
    GridPane myBookshelfItemsPane;
    @FXML
    ImageView myBookshelfImage;
    @FXML
    ImageView myFirstChairToken;
    @FXML
    ImageView myEndGameToken;
    @FXML
    HBox columnSelectionPane;
    @FXML
    FlowPane opponentsPane;
    @FXML
    FlowPane messagePane;
    @FXML
    TextFlow messageTextPane;
    @FXML
    Text messageText;
    @FXML
    Separator separator;
    @FXML
    Button confirmButton;
    @FXML
    TextFlow leaderboardTextPane;
    @FXML
    Text leaderboardText;

    public void showScene(double sceneWidth, double sceneHeight){

        scenePane.setPrefWidth(sceneWidth);
        scenePane.setPrefHeight(sceneHeight);
        scenePane.setBackground(new Background(new BackgroundImage(new Image("/GraphicalResources/Miscellaneous/parquetBackground.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false))));
        scenePane.setAlignment(leaderboardTextPane, Pos.CENTER);

        gamePane.setPrefWidth(scenePane.getPrefWidth());
        gamePane.setPrefHeight(scenePane.getPrefHeight());
        gamePane.setPadding(new Insets(gamePane.getPrefHeight()*0.03, gamePane.getPrefWidth()*0.03, gamePane.getPrefHeight()*0.03, gamePane.getPrefWidth()*0.03));
        gamePane.setHgap(sceneWidth*0.01);
        gamePane.setVgap(sceneHeight*0.01);

        tablePane.setPrefWidth(sceneWidth*0.30);
        tablePane.setPrefHeight(sceneHeight*0.84);
        tablePane.setMargin(goalsPane, new Insets(tablePane.getPrefHeight()*0.01, 0, 0, 0));

        boardPane.setPrefWidth(tablePane.getPrefWidth());
        boardPane.setPrefHeight(tablePane.getPrefHeight()*0.65);
        boardPane.setMinWidth(boardPane.getPrefWidth());
        boardPane.setMinHeight(boardPane.getPrefHeight());
        boardPane.setMaxWidth(boardPane.getPrefWidth());
        boardPane.setMaxHeight(boardPane.getPrefHeight());
        boardPane.setAlignment(boardItemsPane, Pos.CENTER);
        boardPane.setAlignment(endGameToken, Pos.BOTTOM_RIGHT);
        boardPane.setMargin(boardItemsPane, new Insets(0, boardPane.getPrefWidth()*0.01, 0, 0));
        boardPane.setMargin(endGameToken, new Insets(0, boardPane.getPrefWidth()*0.09, boardPane.getPrefHeight()*0.20, 0));

        boardImage.setFitWidth(boardPane.getPrefWidth());
        boardImage.setFitHeight(boardPane.getPrefHeight());
        boardImage.setSmooth(true);
        boardImage.setImage(new Image("/GraphicalResources/Boards/livingroom.png", boardImage.getFitWidth(), boardImage.getFitHeight(), true, true));

        endGameToken.setFitWidth(boardPane.getPrefWidth()*0.11);
        endGameToken.setFitHeight(boardPane.getPrefHeight()*0.11);
        endGameToken.setImage(new Image("/GraphicalResources/ScoringTokens/endGameToken.jpg", endGameToken.getFitWidth(), endGameToken.getFitHeight(), true, false));
        endGameToken.setRotate(10);

        boardItemsPane.setPrefWidth(boardPane.getPrefWidth()*0.88);
        boardItemsPane.setPrefHeight(boardPane.getPrefHeight()*0.91);
        boardItemsPane.setMinWidth(boardItemsPane.getPrefWidth());
        boardItemsPane.setMinHeight(boardItemsPane.getPrefHeight());
        boardItemsPane.setMaxWidth(boardItemsPane.getPrefWidth());
        boardItemsPane.setMaxHeight(boardItemsPane.getPrefHeight());
        boardItemsPane.setGridLinesVisible(false);

        goalsPane.setPrefWidth(tablePane.getPrefWidth());
        goalsPane.setPrefHeight(tablePane.getPrefHeight()*0.34);
        goalsPane.setMargin(personalGoal, new Insets(0,0,0,goalsPane.getPrefWidth()*0.05));

        commonGoalsPane.setPrefWidth(goalsPane.getPrefWidth()*0.50);
        commonGoalsPane.setPrefHeight(goalsPane.getPrefHeight()*0.99);
        commonGoalsPane.setAlignment(Pos.CENTER);
        commonGoalsPane.setVgap(goalsPane.getPrefHeight()*0.01);

        commonGoal1Pane.setPrefWidth(commonGoalsPane.getPrefWidth());
        commonGoal1Pane.setPrefHeight(commonGoalsPane.getPrefHeight()*0.5);/
        commonGoal1Pane.setMargin(pointsCommonGoal1, (new Insets(0,0,commonGoal1Pane.getPrefHeight()*0.10,commonGoal1Pane.getPrefWidth()*0.35)));

        commonGoal2Pane.setPrefWidth(commonGoalsPane.getPrefWidth());
        commonGoal2Pane.setPrefHeight(commonGoalsPane.getPrefHeight()*0.5);
        commonGoal2Pane.setMargin(pointsCommonGoal2, (new Insets(0,0,commonGoal2Pane.getPrefHeight()*0.10,commonGoal2Pane.getPrefWidth()*0.35)));

        myPane.setPrefWidth(sceneWidth*0.44);
        myPane.setPrefHeight(sceneHeight*0.84);
        myPane.setAlignment(myTextPane, Pos.TOP_CENTER);
        myPane.setAlignment(myBookshelfImage, Pos.BOTTOM_CENTER);
        myPane.setAlignment(myBookshelfItemsPane, Pos.CENTER);
        myPane.setAlignment(columnSelectionPane, Pos.CENTER);
        myPane.setAlignment(myFirstChairToken, Pos.BOTTOM_RIGHT);
        myPane.setAlignment(myEndGameToken, Pos.TOP_RIGHT);
        myPane.setMargin(myTextPane, new Insets(myPane.getPrefHeight()*0.01, 0, 0, 0));
        myPane.setMargin(myFirstChairToken, new Insets(0, myPane.getPrefWidth()*0.03, 0, 0));
        myPane.setMargin(myEndGameToken, new Insets(myPane.getPrefHeight()*0.03, myPane.getPrefWidth()*0.10, 0, 0));

        myTextPane.setPrefWidth(myPane.getPrefWidth()*0.98);
        myTextPane.setPrefHeight(myPane.getPrefHeight()*0.025);
        myTextPane.setTextAlignment(TextAlignment.CENTER);

        myText.setText("Your Bookshelf");
        myText.setFont(new Font("Arial Bold", 20));

        myBookshelfItemsPane.setPrefWidth(myPane.getPrefWidth()*0.75);
        myBookshelfItemsPane.setPrefHeight(myPane.getPrefHeight()*0.77);
        myBookshelfItemsPane.setMinWidth(myBookshelfItemsPane.getPrefWidth());
        myBookshelfItemsPane.setMinHeight(myBookshelfItemsPane.getPrefHeight());
        myBookshelfItemsPane.setMaxWidth(myBookshelfItemsPane.getPrefWidth());
        myBookshelfItemsPane.setMaxHeight(myBookshelfItemsPane.getPrefHeight());
        myBookshelfItemsPane.setHgap(myPane.getPrefWidth()*0.04);
        myBookshelfItemsPane.setVgap(myPane.getPrefHeight()*0.02);
        myBookshelfItemsPane.setGridLinesVisible(false);

        myBookshelfImage.setFitWidth(myPane.getPrefWidth());
        myBookshelfImage.setFitHeight(myPane.getPrefHeight()*0.95);
        myBookshelfImage.setImage(new Image("/GraphicalResources/Boards/bookshelf.png", myBookshelfImage.getFitWidth(), myBookshelfImage.getFitHeight(), true, false));

        columnSelectionPane.setPrefWidth(myPane.getPrefWidth()*0.73);
        columnSelectionPane.setPrefHeight(myPane.getPrefHeight()*0.78);
        columnSelectionPane.setMinWidth(columnSelectionPane.getPrefWidth());
        columnSelectionPane.setMinHeight(columnSelectionPane.getPrefHeight());
        columnSelectionPane.setMaxWidth(columnSelectionPane.getPrefWidth());
        columnSelectionPane.setMaxHeight(columnSelectionPane.getPrefHeight());
        columnSelectionPane.setSpacing(myPane.getPrefWidth()*0.03);

        opponentsPane.setPrefWidth(sceneWidth*0.17);
        opponentsPane.setPrefHeight(sceneHeight*0.84);
        opponentsPane.setMinWidth(opponentsPane.getPrefWidth());
        opponentsPane.setMinHeight(opponentsPane.getPrefHeight());
        opponentsPane.setMaxWidth(opponentsPane.getPrefWidth());
        opponentsPane.setMaxHeight(opponentsPane.getPrefHeight());
        opponentsPane.setVgap(opponentsPane.getPrefHeight()*0.02);

        messagePane.setPrefWidth(sceneWidth*0.94);
        messagePane.setPrefHeight(sceneHeight*0.09);
        messagePane.setMinWidth(messagePane.getPrefWidth());
        messagePane.setMinHeight(messagePane.getPrefHeight());
        messagePane.setMaxWidth(messagePane.getPrefWidth());
        messagePane.setMaxHeight(messagePane.getPrefHeight());
        messagePane.setOrientation(Orientation.HORIZONTAL);

        messageTextPane.setPrefWidth(messagePane.getPrefWidth()*0.92);
        messageTextPane.setPrefHeight(messagePane.getPrefHeight());
        messageTextPane.setBackground(new Background(new BackgroundFill(Color.CORNSILK, null, null)));
        messageTextPane.setTextAlignment(TextAlignment.LEFT);
        messageTextPane.setPadding(new Insets(0, messageTextPane.getPrefWidth()*0.0075, 0, messageTextPane.getPrefWidth()*0.0075));

        Rectangle messagePaneShape = new Rectangle(messageTextPane.getPrefWidth(), messageTextPane.getPrefHeight());
        messagePaneShape.setArcWidth(30);
        messagePaneShape.setArcHeight(30);
        messageTextPane.setShape(messagePaneShape);

        messageText.setText("");
        messageText.setFont(new Font("Arial Bold", 15));

        separator.setPrefWidth(messagePane.getPrefWidth()*0.005);
        separator.setPrefHeight(messagePane.getPrefHeight()*0.025);
        separator.setOrientation(Orientation.HORIZONTAL);
        separator.setVisible(false);

        confirmButton.setPrefWidth(confirmButton.getPrefHeight());
        confirmButton.setPrefHeight(messageTextPane.getPrefHeight() * 0.50);
        confirmButton.setMinWidth(confirmButton.getPrefWidth());
        confirmButton.setMinHeight(confirmButton.getPrefHeight());
        confirmButton.setMaxWidth(confirmButton.getPrefWidth());
        confirmButton.setMaxHeight(confirmButton.getPrefHeight());
        confirmButton.setText(null);
        confirmButton.setBackground(null);
        confirmButton.setGraphic(new ImageView(new Image("/GraphicalResources/Miscellaneous/sendIconNotPressed.png", confirmButton.getPrefWidth(), confirmButton.getPrefHeight(), true, true)));

        confirmButton.pressedProperty().addListener((observable, wasPressed, pressed) -> {
            if (pressed) {
                confirmButton.setGraphic(new ImageView(new Image("/GraphicalResources/Miscellaneous/sendIconPressed.png", confirmButton.getPrefWidth(), confirmButton.getPrefHeight(), true, true)));
            } else {
                confirmButton.setGraphic(new ImageView(new Image("/GraphicalResources/Miscellaneous/sendIconNotPressed.png", confirmButton.getPrefWidth(), confirmButton.getPrefHeight(), true, true)));
            }
        });

        Rectangle confirmButtonShape = new Rectangle(confirmButton.getPrefWidth(), confirmButton.getPrefHeight());
        confirmButtonShape.setArcWidth(30);
        confirmButtonShape.setArcHeight(30);
        confirmButton.setShape(confirmButtonShape);

        leaderboardTextPane.setPrefWidth(sceneWidth*0.25);
        leaderboardTextPane.setPrefHeight(sceneHeight*0.50);
        leaderboardTextPane.setMaxWidth(leaderboardTextPane.getPrefWidth());
        leaderboardTextPane.setMaxHeight(leaderboardTextPane.getPrefHeight());
        leaderboardTextPane.setBackground(new Background(new BackgroundFill(Color.CORNSILK, null, null)));
        leaderboardTextPane.setTextAlignment(TextAlignment.CENTER);
        leaderboardTextPane.setPadding(new Insets(leaderboardTextPane.getPrefHeight()*0.10));
        leaderboardTextPane.setVisible(false);

        Rectangle leaderboardPaneShape = new Rectangle(leaderboardTextPane.getPrefWidth(), leaderboardTextPane.getPrefHeight());
        leaderboardPaneShape.setArcWidth(30);
        leaderboardPaneShape.setArcHeight(30);
        leaderboardTextPane.setShape(leaderboardPaneShape);
        leaderboardTextPane.setVisible(false);

        leaderboardText.setText("");
        leaderboardText.setFont(new Font("Arial Bold", 15));
    }

    public void showBoardItems(LivingRoomBoard board){

        for(int i = 0; i < board.getTiles().length; i++){
            for(int j = 0; j < board.getTiles()[i].length; j++) {
                ToggleButton button = new ToggleButton();

                button.setPrefWidth(boardItemsPane.getPrefWidth()/9);
                button.setPrefHeight(boardItemsPane.getPrefHeight()/9);
                button.setMinWidth(button.getPrefWidth());
                button.setMinHeight(button.getPrefHeight());
                button.setMaxWidth(button.getPrefWidth());
                button.setMaxHeight(button.getPrefHeight());
                button.setAlignment(Pos.CENTER);
                button.setText(null);
                button.setBackground(null);

                if (board.getTiles()[i][j].getObject() != null) {
                    String itemPath = new String("/GraphicalResources/ItemTiles/");
                    itemPath = itemPath + board.getTiles()[i][j].getObject().getType().toString().toLowerCase() + ".png";
                    button.setGraphic(new ImageView(new Image(itemPath, boardItemsPane.getPrefWidth()/12, boardItemsPane.getPrefHeight()/12, true, false)));
                }
                else{
                    button.setDisable(true);
                }

                boardItemsPane.add(button, j, i, 1, 1);
            }
        }
    }
    public void showPersonalGoal(PersonalGoalCard goal){

        String goalPath = new String("/GraphicalResources/PersonalGoalCards/personalGoal");
        goalPath = goalPath + String.valueOf(goal.getId()) + ".png";

        personalGoal.setFitWidth(goalsPane.getPrefWidth()*0.50);
        personalGoal.setFitHeight(goalsPane.getPrefHeight());
        personalGoal.setSmooth(true);
        personalGoal.setImage(new Image(goalPath, personalGoal.getFitWidth(), personalGoal.getFitHeight(), true, true));

    }
    public void showCommonGoals(CommonGoalCard[] goals){

        for(int i = 0; i < goals.length; i++){
            CommonGoalCard goal = goals[i];
            String goalPath;
            String pointPath;
            StackPane goalPane = (StackPane) commonGoalsPane.getChildren().get(i);
            ImageView goalImage = (ImageView) goalPane.getChildren().get(0);
            ImageView pointImage = (ImageView) goalPane.getChildren().get(1);

            goalPath = new String("/GraphicalResources/CommonGoalCards/commonGoal");
            goalPath = goalPath + String.valueOf(goal.getGoalID()) + ".jpg";

            goalImage.setFitWidth(goalPane.getPrefWidth());
            goalImage.setFitHeight(goalPane.getPrefHeight());
            goalImage.setImage(new Image(goalPath, goalImage.getFitWidth(), goalImage.getFitHeight(), true, false));

            if(goal.getPoints().size() > 0){
                pointPath = new String("/GraphicalResources/ScoringTokens/scoringToken");
                pointPath = pointPath + String.valueOf(goal.getPoints().get(0).getValue().getI()) + ".jpg";

                pointImage.setFitWidth(goalPane.getPrefWidth()*0.45);
                pointImage.setFitHeight(goalPane.getPrefHeight()*0.45);
                pointImage.setImage(new Image(pointPath, pointImage.getFitWidth(), pointImage.getFitHeight(), true, false));
                pointImage.setRotate(-8);
            }
        }
    }
    public void showPlayer(Player player){

        ImageView firstChairToken = (ImageView) myPane.getChildren().get(3);
        ImageView endGameToken = (ImageView) myPane.getChildren().get(4);

        showBookshelf(player.getBookshelf(), (GridPane) myPane.getChildren().get(1));

        firstChairToken.setFitWidth(myPane.getPrefWidth()*0.15);
        firstChairToken.setFitHeight(myPane.getPrefHeight()*0.15);
        firstChairToken.setImage(new Image("/GraphicalResources/Miscellaneous/firstPlayerToken.png", firstChairToken.getFitWidth(), firstChairToken.getFitHeight(), true, false));

        if(player.getIsFirst() == true){
            firstChairToken.setVisible(true);
        }
        else{
            firstChairToken.setVisible(false);
        }

        endGameToken.setFitWidth(myPane.getPrefWidth()*0.12);
        endGameToken.setFitHeight(myPane.getPrefHeight()*0.12);
        endGameToken.setImage(new Image("/GraphicalResources/ScoringTokens/endGameToken.jpg", endGameToken.getFitWidth(), endGameToken.getFitHeight(), true, false));
        endGameToken.setRotate(15);

        if(player.getHasFinished() == true){
            endGameToken.setVisible(true);
            this.endGameToken.setVisible(false);
        }
        else{
            endGameToken.setVisible(false);
            this.endGameToken.setVisible(true);
        }

    }

    public void showOpponent(Player opponent, StackPane opponentPane){

        String opponentTextString = new String(opponent.getNickname() + "'s Bookshelf");

        TextFlow opponentTextPane = (TextFlow) opponentPane.getChildren().get(0);
        Text opponentText = (Text) opponentTextPane.getChildren().get(0);
        GridPane opponentBookshelfItemsPane = (GridPane) opponentPane.getChildren().get(1);
        ImageView opponentBookshelfImage = (ImageView) opponentPane.getChildren().get(2);
        ImageView opponentFirstChairToken = (ImageView) opponentPane.getChildren().get(3);
        ImageView opponentEndGameToken = (ImageView) opponentPane.getChildren().get(4);

        opponentPane.setPrefWidth(opponentsPane.getPrefWidth());
        opponentPane.setPrefHeight(opponentsPane.getPrefHeight()*0.32);
        opponentPane.setMinWidth(opponentPane.getPrefWidth());
        opponentPane.setMinHeight(opponentPane.getPrefHeight());
        opponentPane.setMaxWidth(opponentPane.getPrefWidth());
        opponentPane.setMaxHeight(opponentPane.getPrefHeight());
        opponentPane.setAlignment(opponentTextPane, Pos.TOP_CENTER);
        opponentPane.setAlignment(opponentBookshelfItemsPane, Pos.CENTER);
        opponentPane.setAlignment(opponentBookshelfImage, Pos.BOTTOM_CENTER);
        opponentPane.setAlignment(opponentFirstChairToken, Pos.BOTTOM_RIGHT);
        opponentPane.setAlignment(opponentEndGameToken, Pos.TOP_RIGHT);
        opponentPane.setMargin(opponentTextPane, new Insets(opponentPane.getPrefHeight()*0.01, 0, 0, 0));
        opponentPane.setMargin(opponentBookshelfItemsPane, new Insets(opponentPane.getPrefHeight()*0.05, 0, 0, 0));
        opponentPane.setMargin(opponentFirstChairToken, new Insets(0, opponentPane.getPrefWidth()*0.13, 0, 0));
        opponentPane.setMargin(opponentEndGameToken, new Insets(opponentPane.getPrefHeight()*0.10, opponentPane.getPrefWidth()*0.15, 0, 0));

        opponentTextPane.setPrefWidth(opponentPane.getPrefWidth()*0.98);
        opponentTextPane.setPrefHeight(opponentPane.getPrefHeight()*0.025);
        opponentTextPane.setMinWidth(opponentTextPane.getPrefWidth());
        opponentTextPane.setMinHeight(opponentTextPane.getPrefHeight());
        opponentTextPane.setMaxWidth(opponentTextPane.getPrefWidth());
        opponentTextPane.setMaxHeight(opponentTextPane.getPrefHeight());
        opponentTextPane.setTextAlignment(TextAlignment.CENTER);

        opponentText.setText(opponentTextString);
        opponentText.setFont(new Font("Arial Bold", 15));

        opponentBookshelfItemsPane.setPrefWidth(opponentPane.getPrefWidth()*0.60);
        opponentBookshelfItemsPane.setPrefHeight(opponentPane.getPrefHeight()*0.73);
        opponentBookshelfItemsPane.setMinWidth(opponentBookshelfItemsPane.getPrefWidth());
        opponentBookshelfItemsPane.setMinHeight(opponentBookshelfItemsPane.getPrefHeight());
        opponentBookshelfItemsPane.setMaxWidth(opponentBookshelfItemsPane.getPrefWidth());
        opponentBookshelfItemsPane.setMaxHeight(opponentBookshelfItemsPane.getPrefHeight());
        opponentBookshelfItemsPane.setHgap(opponentPane.getPrefWidth()*0.025);
        opponentBookshelfItemsPane.setVgap(opponentPane.getPrefHeight()*0.01);
        opponentBookshelfItemsPane.setGridLinesVisible(false);

        showBookshelf(opponent.getBookshelf(), opponentBookshelfItemsPane);

        opponentBookshelfImage.setFitWidth(opponentPane.getPrefWidth());
        opponentBookshelfImage.setFitHeight(opponentPane.getPrefHeight()*0.90);
        opponentBookshelfImage.setImage(new Image("/GraphicalResources/Boards/bookshelf.png", opponentBookshelfImage.getFitWidth(), opponentBookshelfImage.getFitHeight(), true, false));

        opponentFirstChairToken.setFitWidth(opponentPane.getPrefWidth()*0.15);
        opponentFirstChairToken.setFitHeight(opponentPane.getPrefHeight()*0.15);
        opponentFirstChairToken.setImage(new Image("/GraphicalResources/Miscellaneous/firstPlayerToken.png", opponentFirstChairToken.getFitWidth(), opponentFirstChairToken.getFitHeight(), true, false));

        if(opponent.getIsFirst() == true){
            opponentFirstChairToken.setVisible(true);
        }
        else{
            opponentFirstChairToken.setVisible(false);
        }

        opponentEndGameToken.setFitWidth(opponentPane.getPrefWidth()*0.12);
        opponentEndGameToken.setFitHeight(opponentPane.getPrefHeight()*0.12);
        opponentEndGameToken.setImage(new Image("/GraphicalResources/ScoringTokens/endGameToken.jpg", opponentEndGameToken.getFitWidth(), opponentEndGameToken.getFitHeight(), true, false));
        opponentEndGameToken.setRotate(15);

        if(opponent.getHasFinished() == true){
            opponentEndGameToken.setVisible(true);
            this.endGameToken.setVisible(false);
        }
        else{
            opponentEndGameToken.setVisible(false);
            this.endGameToken.setVisible(true);
        }

    }
    public void showBookshelf(Bookshelf bookshelf, GridPane itemsPane){

        for(int i = 0; i < itemsPane.getRowCount(); i++){
            for(int j =0; j < itemsPane.getColumnCount(); j++){
                if(bookshelf.getShelf()[i][j] != null){
                    String itemPath = new String("/GraphicalResources/ItemTiles/");
                    itemPath = itemPath + bookshelf.getShelf()[i][j].getType().toString().toLowerCase() + ".png";

                    ImageView itemImage = new ImageView();
                    itemImage.setFitWidth(((itemsPane.getPrefWidth()*1.04 - (itemsPane.getHgap() * (itemsPane.getColumnCount() - 1))) / itemsPane.getColumnCount())*1.01);
                    itemImage.setFitHeight(((itemsPane.getPrefHeight() - (itemsPane.getVgap() * (itemsPane.getRowCount() - 1))) / itemsPane.getRowCount())*1.01);
                    itemImage.setImage(new Image(itemPath, itemImage.getFitWidth(), itemImage.getFitHeight(), true, false));

                    itemsPane.add(itemImage, j, i);
                }
            }
        }

    }
    public void showMessage(String message){
        char squareCharacter = 9632;

        if(message.startsWith("Choose up to 3")){
            message = "\n" + message;
            message = message + "\nTo choose an object card you have to click on it" +
                    "\nClick the send button on the right when you have chosen all the cards you want to remove from the board\n";
        }
        else if(message.startsWith("In which bookshelf column")){
            message = "\n" + message;
            message = message + "\nTo choose a column you have to click on it" +
                    "\nClick the send button on the right when you have chosen the column\n";
        }
        else{
            message = "\n" + message + "\n";
        }

        messageText.setFont(new Font("Arial", (messageTextPane.getPrefHeight() / (message.lines().count() + 2))));
        messageText.setText(message);
    }
    public void showLeaderboard(Player[] leaderboard){

        BoxBlur blurBox = new BoxBlur(12, 12, 1);
        gamePane.setEffect(blurBox);

        String leaderboardString = new String("LEADERBOARD:\n");

        int i = 1;
        for(Player player : leaderboard){
            leaderboardString = leaderboardString + i + ". " + player.getNickname() + " with " + player.getPoints() + "points\n";
            i += 1;
        }

        leaderboardText.setText(leaderboardString);
        leaderboardTextPane.setVisible(true);
    }

}
