package it.polimi.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class MainGUI extends Application {
    private Scene scene;
    private Stage stage;
    public int screenHeight;
    @Override
    public void start(Stage stage) throws Exception {
        //Load .fxml file and build the scene
        FXMLLoader root = new FXMLLoader(MainGUI.class.getResource("/GUI.fxml"));
        scene = new Scene(root.load());
        ControllerGUI controller = root.getController();
        //Get dimensions of user's screen (height)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenHeight = (int) screenSize.getHeight();
        //TODO: Ridimensionare correttamente in base a dimensioni finestra
        int playersNumber = 2; // TODO: Temporary variable to test GUI
        //Call controller's methods
        controller.updateOtherPlayersView(playersNumber,screenHeight);
        controller.updateDimensions(screenHeight);
        //Set stage parameters
        this.stage = stage;
        this.stage.setTitle("MyShelfie - GUI");
        this.stage.setScene(scene);
        this.stage.show();
        this.stage.centerOnScreen();
        this.stage.setWidth(screenHeight);  // Set window width
        this.stage.setHeight(screenHeight); // Set window height
        //Set windows not to be resizable
        this.stage.setResizable(false); // TODO: Set window to be resizable
    }

}
