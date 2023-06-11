package it.polimi.view;

import it.polimi.view.MainGUI;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ControllerGUI {
    //HBox top right
    @FXML
    private HBox otherPlayersView;
    @FXML
    private ImageView topLeft;
    @FXML
    private ImageView bottomRight;
    //Handle mouse click printing x and y position (test)
    public void handleMouseClick(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        System.out.println("Coordinates: x = " + x + ", y = " + y);
    }

    //Update window dimensions to match screen dimensions
    public void updateDimensions(int screenHeight){
        topLeft.setFitHeight((screenHeight/2)-50);
        topLeft.setFitWidth((screenHeight/2)-50);
        bottomRight.setFitHeight((screenHeight/2)-50);
        bottomRight.setFitWidth((screenHeight/2)-50);
    }

    //Displays 1,2 or 3 bookshelf based on players number
    public void updateOtherPlayersView(int playersNumber, int screenHeight) {
        otherPlayersView.getChildren().clear(); // Remove previous images

        // Add 1 to 3 images to the container
        for (int i = 1; i <= playersNumber; i++) {
            // Load bookshelf image
            Image image = new Image("/boards/bookshelf.png");

            // Create an ImageView to display the bookshelf
            ImageView imageView = new ImageView(image);
            int height = ((screenHeight/2) - (10 * playersNumber)) / playersNumber;   // TODO: Calculate correct image width
            imageView.setFitHeight(height); // Set width of the image
            imageView.setPreserveRatio(true); // Maintain image ratio

            // Add the ImageView to the container
            otherPlayersView.getChildren().add(imageView);
        }
    }


}


