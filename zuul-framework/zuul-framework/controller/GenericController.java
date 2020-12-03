package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import gameEngine.Run;

public class GenericController {
    @FXML
    protected ImageView backgroundImage;

    @FXML
    void darkenText(MouseEvent event) {

        Text text = (Text)event.getTarget();
        text.setStroke(Color.WHITE);
    }

    @FXML
    void highlightText(MouseEvent event) {

        Text text = (Text)event.getTarget();
        text.setStroke(Color.YELLOW);

    }

    @FXML
    void goOutside(MouseEvent event) throws Exception{
        changeScene("outside");
    }

    @FXML
    void changeScene(String room) {
        // application layer
        Run.getRInstance().processCommand("go " + room);

        switch (room) {
            case "home" -> Run.getPrimaryStage().setScene(ResourceController.getHomeScene());
            case "outside" -> Run.getPrimaryStage().setScene(ResourceController.getOutsideScene());
            case "startmenu" -> Run.getPrimaryStage().setScene(ResourceController.getStartmenuScene());
            case "hospital" -> Run.getPrimaryStage().setScene(ResourceController.getHospitalScene());
            case "school" -> Run.getPrimaryStage().setScene(ResourceController.getSchoolScene());
            case "work" -> Run.getPrimaryStage().setScene(ResourceController.getWorkScene());
            case "shop" -> Run.getPrimaryStage().setScene(ResourceController.getShopScene());
        }

        // Reparent inventory to whichever scene is on top
        ((AnchorPane)Run.getPrimaryStage().getScene().getRoot()).getChildren().add(ResourceController.getOverlayScene());
    }
}
