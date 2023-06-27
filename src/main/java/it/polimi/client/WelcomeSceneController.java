package it.polimi.client;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class WelcomeSceneController{

    @FXML
    StackPane welcomePane;
    @FXML
    ImageView titleImage;
    @FXML
    TextFlow messageTextPane;
    @FXML
    Text messageText;
    @FXML
    TextField playerTextField;
    @FXML
    Separator separator;
    @FXML
    Button confirmButton;

    public void showScene(double sceneWidth, double sceneHeight) {
        welcomePane.setPrefWidth(sceneWidth);
        welcomePane.setPrefHeight(sceneHeight);
        welcomePane.setMinWidth(welcomePane.getPrefWidth());
        welcomePane.setMinHeight(welcomePane.getPrefHeight());
        welcomePane.setMaxWidth(welcomePane.getPrefWidth());
        welcomePane.setMaxHeight(welcomePane.getPrefHeight());
        welcomePane.setBackground(new Background(new BackgroundImage(new Image("/GraphicalResources/Miscellaneous/parquetBackground.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false))));
        welcomePane.setAlignment(titleImage, Pos.TOP_CENTER);
        welcomePane.setAlignment(messageTextPane, Pos.CENTER);
        welcomePane.setMargin(titleImage, new Insets(welcomePane.getPrefHeight()*0.10, 0, 0, 0));
        welcomePane.setMargin(messageTextPane, new Insets(0, 0, welcomePane.getPrefHeight()*0.30, 0));

        titleImage.setFitWidth(welcomePane.getPrefWidth()*0.50);
        titleImage.setFitHeight(welcomePane.getPrefHeight()*0.20);
        titleImage.setSmooth(true);
        titleImage.setImage(new Image("/GraphicalResources/Miscellaneous/title.png", titleImage.getFitWidth(), titleImage.getFitHeight(), true, true));

        messageTextPane.setPrefWidth(welcomePane.getPrefWidth()*0.50);
        messageTextPane.setPrefHeight(welcomePane.getPrefHeight()*0.025);
        messageTextPane.setMinWidth(messageTextPane.getPrefWidth());
        messageTextPane.setMinHeight(messageTextPane.getPrefHeight());
        messageTextPane.setMaxWidth(messageTextPane.getPrefWidth());
        messageTextPane.setMaxHeight(messageTextPane.getPrefHeight());
        messageTextPane.setTextAlignment(TextAlignment.CENTER);

        messageText.setText("\n");
        messageText.setFont(new Font("Arial", 20));

        playerTextField.setPrefWidth(welcomePane.getPrefWidth()*0.20);
        playerTextField.setPrefHeight(welcomePane.getPrefHeight()*0.025);
        playerTextField.setMinWidth(playerTextField.getPrefWidth());
        playerTextField.setMinHeight(playerTextField.getPrefHeight());
        playerTextField.setMaxWidth(playerTextField.getPrefWidth());
        playerTextField.setMaxHeight(playerTextField.getPrefHeight());

        separator.setPrefWidth(welcomePane.getPrefWidth()*0.005);
        separator.setPrefHeight(welcomePane.getPrefHeight()*0.025);
        separator.setMinWidth(separator.getPrefWidth());
        separator.setMinHeight(separator.getPrefHeight());
        separator.setMaxWidth(separator.getPrefWidth());
        separator.setMaxHeight(separator.getPrefHeight());
        separator.setOrientation(Orientation.HORIZONTAL);
        separator.setVisible(false);

        confirmButton.setPrefWidth(welcomePane.getPrefWidth()*0.02);
        confirmButton.setPrefHeight(confirmButton.getPrefWidth());
        confirmButton.setMinWidth(confirmButton.getPrefWidth());
        confirmButton.setMinHeight(confirmButton.getPrefHeight());
        confirmButton.setMaxWidth(confirmButton.getPrefWidth());
        confirmButton.setMaxHeight(confirmButton.getPrefHeight());
        confirmButton.setText(null);
        confirmButton.setBackground(null);
        confirmButton.setGraphic(new ImageView(new Image("/GraphicalResources/Miscellaneous/sendIconNotPressed.png", confirmButton.getPrefWidth(), confirmButton.getPrefHeight(), true, false)));

        confirmButton.pressedProperty().addListener((observable, wasPressed, pressed) -> {
            if (pressed) {
                confirmButton.setGraphic(new ImageView(new Image("/GraphicalResources/Miscellaneous/sendIconPressed.png", confirmButton.getPrefWidth(), confirmButton.getPrefHeight(), true, false)));
            } else {
                confirmButton.setGraphic(new ImageView(new Image("/GraphicalResources/Miscellaneous/sendIconNotPressed.png", confirmButton.getPrefWidth(), confirmButton.getPrefHeight(), true, false)));
            }
        });
    }

    public void showMessage(String message){
        if(message.startsWith("Waiting for the others")){
            playerTextField.setVisible(false);
            confirmButton.setVisible(false);
        }
        messageText.setText(message);
    }
    public String getMessage(){
        String message = new String(playerTextField.getText());
        playerTextField.clear();
        return message;
    }

}