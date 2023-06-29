package it.polimi.client;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ClientGUI extends Application{

    FXMLLoader fxmlLoader;
    Parent root;
    Rectangle2D screenDimensions;
    Scene clientScene;
    ClientSceneController clientSceneController;

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("My Shelfie");
        stage.getIcons().add(new Image("/GraphicalResources/Miscellaneous/icon.png"));
        stage.setResizable(false);

        fxmlLoader = new FXMLLoader(getClass().getResource("/ScenesFXMLs/ClientScene.fxml"));
        root = fxmlLoader.load();
        screenDimensions = Screen.getPrimary().getVisualBounds();
        clientScene = new Scene(root, screenDimensions.getWidth()*0.90, screenDimensions.getHeight()*0.90);

        stage.setScene(clientScene);
        clientSceneController = fxmlLoader.getController();
        clientSceneController.startCommunication(getParameters().getRaw().get(0), Integer.parseInt(getParameters().getRaw().get(1)));
        clientSceneController.showScene(clientScene.getWidth(), clientScene.getHeight());
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void main(String[] args) {
        launch(args);
    }
}
