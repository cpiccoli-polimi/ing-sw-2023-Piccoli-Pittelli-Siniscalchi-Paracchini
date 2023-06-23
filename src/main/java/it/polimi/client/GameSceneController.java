package it.polimi.client;

import it.polimi.model.*;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
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

public class GameSceneController {
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
    StackPane myBookshelfPane;
    @FXML
    TextFlow myBookshelfTextPane;
    @FXML
    Text myBookshelfText;
    @FXML
    GridPane myBookshelfItemsPane;
    @FXML
    ImageView myBookshelfImage;
    @FXML
    ImageView myFirstChairToken;
    @FXML
    ImageView myEndGameToken;
    @FXML
    FlowPane opponentsBookshelvesPane;
    @FXML
    TextFlow messageTextPane;
    @FXML
    Text messageText;
    @FXML
    TextFlow leaderboardTextPane;
    @FXML
    Text leaderboardText;

    public void showScene(double sceneWidth, double sceneHeight){

        scenePane.setMinWidth(sceneWidth);
        scenePane.setMinHeight(sceneHeight);
        scenePane.setPrefWidth(scenePane.getMinWidth());
        scenePane.setPrefHeight(scenePane.getMinHeight());
        scenePane.setMaxWidth(scenePane.getMinWidth());
        scenePane.setPrefHeight(scenePane.getMinHeight());
        scenePane.setBackground(new Background(new BackgroundImage(new Image("/GraphicalResources/Miscellaneous/parquetBackground.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false))));
        scenePane.setAlignment(leaderboardTextPane, Pos.CENTER);

        gamePane.setMinWidth(scenePane.getPrefWidth());
        gamePane.setMinHeight(scenePane.getPrefHeight());
        gamePane.setPrefWidth(gamePane.getMinWidth());
        gamePane.setPrefHeight(gamePane.getMinHeight());
        gamePane.setMaxWidth(gamePane.getMinWidth());
        gamePane.setPrefHeight(gamePane.getMinHeight());
        gamePane.setPadding(new Insets(gamePane.getPrefHeight()*0.03, gamePane.getPrefWidth()*0.03, gamePane.getPrefHeight()*0.03, gamePane.getPrefWidth()*0.03));
        gamePane.setHgap(sceneWidth*0.01);
        gamePane.setVgap(sceneHeight*0.01);

        tablePane.setPrefWidth(sceneWidth*0.30);
        tablePane.setPrefHeight(sceneHeight*0.84);
        tablePane.setMinWidth(tablePane.getPrefWidth());
        tablePane.setMinHeight(tablePane.getPrefHeight());
        tablePane.setMaxWidth(tablePane.getPrefWidth());
        tablePane.setMaxHeight(tablePane.getPrefHeight());
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
        goalsPane.setMinWidth(goalsPane.getPrefWidth());
        goalsPane.setMinHeight(goalsPane.getPrefHeight());
        goalsPane.setMaxWidth(goalsPane.getPrefWidth());
        goalsPane.setMaxHeight(goalsPane.getPrefHeight());
        goalsPane.setMargin(personalGoal, new Insets(0,0,0,goalsPane.getPrefWidth()*0.05));

        commonGoalsPane.setPrefWidth(goalsPane.getPrefWidth()*0.50);
        commonGoalsPane.setPrefHeight(goalsPane.getPrefHeight()*0.99);
        commonGoalsPane.setMinWidth(commonGoalsPane.getPrefWidth());
        commonGoalsPane.setMinHeight(commonGoalsPane.getPrefHeight());
        commonGoalsPane.setMaxWidth(commonGoalsPane.getPrefWidth());
        commonGoalsPane.setMaxHeight(commonGoalsPane.getPrefHeight());
        commonGoalsPane.setAlignment(Pos.CENTER);
        commonGoalsPane.setVgap(goalsPane.getPrefHeight()*0.01);

        commonGoal1Pane.setPrefWidth(commonGoalsPane.getPrefWidth());
        commonGoal1Pane.setPrefHeight(commonGoalsPane.getPrefHeight()*0.5);
        commonGoal1Pane.setMinWidth(commonGoal1Pane.getPrefWidth());
        commonGoal1Pane.setMinHeight(commonGoal1Pane.getPrefHeight());
        commonGoal1Pane.setMaxWidth(commonGoal1Pane.getPrefWidth());
        commonGoal1Pane.setMaxHeight(commonGoal1Pane.getPrefHeight());
        commonGoal1Pane.setMargin(pointsCommonGoal1, (new Insets(0,0,commonGoal1Pane.getPrefHeight()*0.10,commonGoal1Pane.getPrefWidth()*0.35)));

        commonGoal2Pane.setPrefWidth(commonGoalsPane.getPrefWidth());
        commonGoal2Pane.setPrefHeight(commonGoalsPane.getPrefHeight()*0.5);
        commonGoal2Pane.setMinWidth(commonGoal2Pane.getPrefWidth());
        commonGoal2Pane.setMinHeight(commonGoal2Pane.getPrefHeight());
        commonGoal2Pane.setMaxWidth(commonGoal2Pane.getPrefWidth());
        commonGoal2Pane.setMaxHeight(commonGoal2Pane.getPrefHeight());
        commonGoal2Pane.setMargin(pointsCommonGoal2, (new Insets(0,0,commonGoal2Pane.getPrefHeight()*0.10,commonGoal2Pane.getPrefWidth()*0.35)));

        myBookshelfPane.setPrefWidth(sceneWidth*0.44);
        myBookshelfPane.setPrefHeight(sceneHeight*0.84);
        myBookshelfPane.setMinWidth(myBookshelfPane.getPrefWidth());
        myBookshelfPane.setMinHeight(myBookshelfPane.getPrefHeight());
        myBookshelfPane.setMaxWidth(myBookshelfPane.getPrefWidth());
        myBookshelfPane.setMaxHeight(myBookshelfPane.getPrefHeight());
        myBookshelfPane.setAlignment(myBookshelfTextPane, Pos.TOP_CENTER);
        myBookshelfPane.setAlignment(myBookshelfImage, Pos.BOTTOM_CENTER);
        myBookshelfPane.setAlignment(myBookshelfItemsPane, Pos.CENTER);
        myBookshelfPane.setAlignment(myFirstChairToken, Pos.BOTTOM_RIGHT);
        myBookshelfPane.setAlignment(myEndGameToken, Pos.TOP_RIGHT);
        myBookshelfPane.setMargin(myBookshelfTextPane, new Insets(myBookshelfPane.getPrefHeight()*0.01, 0, 0, 0));
        myBookshelfPane.setMargin(myFirstChairToken, new Insets(0, myBookshelfPane.getPrefWidth()*0.03, 0, 0));
        myBookshelfPane.setMargin(myEndGameToken, new Insets(myBookshelfPane.getPrefHeight()*0.03, myBookshelfPane.getPrefWidth()*0.10, 0, 0));

        myBookshelfTextPane.setPrefWidth(myBookshelfPane.getPrefWidth()*0.98);
        myBookshelfTextPane.setPrefHeight(myBookshelfPane.getPrefHeight()*0.025);
        myBookshelfTextPane.setMinWidth(myBookshelfTextPane.getPrefWidth());
        myBookshelfTextPane.setMinHeight(myBookshelfTextPane.getPrefHeight());
        myBookshelfTextPane.setMaxWidth(myBookshelfTextPane.getPrefWidth());
        myBookshelfTextPane.setMaxHeight(myBookshelfTextPane.getPrefHeight());
        myBookshelfTextPane.setTextAlignment(TextAlignment.CENTER);

        myBookshelfText.setText("Your Bookshelf");
        myBookshelfText.setFont(new Font("Arial Bold", 20));

        myBookshelfItemsPane.setPrefWidth(myBookshelfPane.getPrefWidth()*0.75);
        myBookshelfItemsPane.setPrefHeight(myBookshelfPane.getPrefHeight()*0.78);
        myBookshelfItemsPane.setMinWidth(myBookshelfItemsPane.getPrefWidth());
        myBookshelfItemsPane.setMinHeight(myBookshelfItemsPane.getPrefHeight());
        myBookshelfItemsPane.setMaxWidth(myBookshelfItemsPane.getPrefWidth());
        myBookshelfItemsPane.setMaxHeight(myBookshelfItemsPane.getPrefHeight());
        myBookshelfItemsPane.setHgap(myBookshelfPane.getPrefWidth()*0.04);
        myBookshelfItemsPane.setVgap(myBookshelfPane.getPrefHeight()*0.02);
        myBookshelfItemsPane.setGridLinesVisible(false);

        myBookshelfImage.setFitWidth(myBookshelfPane.getPrefWidth());
        myBookshelfImage.setFitHeight(myBookshelfPane.getPrefHeight()*0.95);
        myBookshelfImage.setImage(new Image("/GraphicalResources/Boards/bookshelf.png", myBookshelfImage.getFitWidth(), myBookshelfImage.getFitHeight(), true, false));
        myBookshelfImage.setScaleY(1.01);

        opponentsBookshelvesPane.setPrefWidth(sceneWidth*0.17);
        opponentsBookshelvesPane.setPrefHeight(sceneHeight*0.84);
        opponentsBookshelvesPane.setMinWidth(opponentsBookshelvesPane.getPrefWidth());
        opponentsBookshelvesPane.setMinHeight(opponentsBookshelvesPane.getPrefHeight());
        opponentsBookshelvesPane.setMaxWidth(opponentsBookshelvesPane.getPrefWidth());
        opponentsBookshelvesPane.setMaxHeight(opponentsBookshelvesPane.getPrefHeight());
        opponentsBookshelvesPane.setVgap(opponentsBookshelvesPane.getPrefHeight()*0.02);

        messageTextPane.setPrefWidth(sceneWidth*0.94);
        messageTextPane.setPrefHeight(sceneHeight*0.09);
        messageTextPane.setMinWidth(messageTextPane.getPrefWidth());
        messageTextPane.setMinHeight(messageTextPane.getPrefHeight());
        messageTextPane.setMaxWidth(messageTextPane.getPrefWidth());
        messageTextPane.setMaxHeight(messageTextPane.getPrefHeight());
        messageTextPane.setBackground(new Background(new BackgroundFill(Color.CORNSILK, null, null)));
        messageTextPane.setTextAlignment(TextAlignment.LEFT);
        messageTextPane.setPadding(new Insets(messageTextPane.getPrefHeight()*0.20));

        Rectangle messagePaneShape = new Rectangle(messageTextPane.getPrefWidth(), messageTextPane.getPrefHeight());
        messagePaneShape.setArcWidth(30);
        messagePaneShape.setArcHeight(30);
        messageTextPane.setShape(messagePaneShape);

        messageText.setText("");
        messageText.setFont(new Font("Arial Bold", 15));

        leaderboardTextPane.setPrefWidth(sceneWidth*0.25);
        leaderboardTextPane.setPrefHeight(sceneHeight*0.50);
        leaderboardTextPane.setMinWidth(leaderboardTextPane.getPrefWidth());
        leaderboardTextPane.setMinHeight(leaderboardTextPane.getPrefHeight());
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

        leaderboardText.setText("");
        leaderboardText.setFont(new Font("Arial Bold", 15));
        leaderboardText.setVisible(false);
    }

    public void showBoardItems(LivingRoomBoard board){

        for(Node child : boardItemsPane.getChildren()){
            ToggleButton button = (ToggleButton) child;
            button.setText(null);
            button.setBackground(null);
            int row = boardItemsPane.getRowIndex(child);
            int column = boardItemsPane.getColumnIndex(child);
            if(board.getTiles()[row][column].getObject() != null){
                String itemPath = new String("/GraphicalResources/ItemTiles/");
                itemPath = itemPath + board.getTiles()[row][column].getObject().getType().toString().toLowerCase() + ".png";
                button.setGraphic(new ImageView(new Image(itemPath, boardItemsPane.getPrefWidth()/12, boardItemsPane.getPrefHeight()/12, true, false)));
                button.setAlignment(Pos.CENTER);
                button.setContentDisplay(ContentDisplay.CENTER);
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

            pointPath = new String("/GraphicalResources/ScoringTokens/scoringToken");
            pointPath = pointPath + String.valueOf(goal.getPoints().get(0).getValue().getI()) + ".jpg";

            goalImage.setFitWidth(goalPane.getPrefWidth());
            goalImage.setFitHeight(goalPane.getPrefHeight());
            goalImage.setImage(new Image(goalPath, goalImage.getFitWidth(), goalImage.getFitHeight(), true, false));

            pointImage.setFitWidth(goalPane.getPrefWidth()*0.45);
            pointImage.setFitHeight(goalPane.getPrefHeight()*0.45);
            pointImage.setImage(new Image(pointPath, pointImage.getFitWidth(), pointImage.getFitHeight(), true, false));
            pointImage.setRotate(-8);
        }
    }

    public void showPlayer(Player player, StackPane playerPane){

        ImageView firstChairToken = (ImageView) playerPane.getChildren().get(3);
        ImageView endGameToken = (ImageView) playerPane.getChildren().get(4);

        showBookshelf(player.getBookshelf(), (GridPane) playerPane.getChildren().get(1));

        firstChairToken.setFitWidth(playerPane.getPrefWidth()*0.15);
        firstChairToken.setFitHeight(playerPane.getPrefHeight()*0.15);
        firstChairToken.setImage(new Image("/GraphicalResources/Miscellaneous/firstPlayerToken.png", firstChairToken.getFitWidth(), firstChairToken.getFitHeight(), true, false));

        if(player.getIsFirst() == true){
            firstChairToken.setVisible(true);
        }
        else{
            firstChairToken.setVisible(false);
        }

        endGameToken.setFitWidth(playerPane.getPrefWidth()*0.12);
        endGameToken.setFitHeight(playerPane.getPrefHeight()*0.12);
        endGameToken.setImage(new Image("/GraphicalResources/ScoringTokens/endGameToken.jpg", endGameToken.getFitWidth(), endGameToken.getFitHeight(), true, false));
        endGameToken.setRotate(15);

        if(player.getHasFinished() == true){
            endGameToken.setVisible(true);
        }
        else{
            endGameToken.setVisible(false);
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

        opponentPane.setPrefWidth(opponentsBookshelvesPane.getPrefWidth());
        opponentPane.setPrefHeight(opponentsBookshelvesPane.getPrefHeight()*0.32);
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
        opponentBookshelfImage.setScaleY(1.0);

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
        }
        else{
            opponentEndGameToken.setVisible(false);
        }

    }
    public void showBookshelf(Bookshelf bookshelf, GridPane itemsPane){

        for(int i = 0; i < itemsPane.getColumnCount(); i++){
            for(int j =0; j < itemsPane.getRowCount(); j++){
                if(bookshelf.getShelf()[i][j] != null){
                    String itemPath = new String("/GraphicalResources/ItemTiles/");
                    itemPath = itemPath + bookshelf.getShelf()[i][j].getType().toString().toLowerCase() + ".png";

                    ImageView itemImage = new ImageView();
                    itemImage.setFitWidth(((itemsPane.getPrefWidth() - (itemsPane.getHgap() * (itemsPane.getColumnCount() - 1))) / itemsPane.getColumnCount())*1.01);
                    itemImage.setFitHeight(((itemsPane.getPrefHeight() - (itemsPane.getVgap() * (itemsPane.getRowCount() - 1))) / itemsPane.getRowCount())*1.01);
                    itemImage.setImage(new Image(itemPath, itemImage.getFitWidth(), itemImage.getFitHeight(), true, false));
                    itemsPane.add(itemImage, i, j);
                }
            }
        }

    }

    public void showMessage(String message){

        messageText.setText(message);

    }

    public void showLeaderboard(Player[] leaderboard, TextFlow leaderboardTextPane){

        BoxBlur blurBox = new BoxBlur(12, 12, 1);
        gamePane.setEffect(blurBox);

        String leaderboardString = new String("LEADERBOARD:\n");

        int i = 1;
        for(Player player : leaderboard){
            leaderboardString = leaderboardString + i + ". " + player.getNickname() + " with " + player.getPoints() + "points\n";
        }

        leaderboardText.setText(leaderboardString);

    }

}
