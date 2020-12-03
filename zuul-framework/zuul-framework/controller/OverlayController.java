package controller;

import gameEngine.Run;
import item.Item;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import player.Country;

public class OverlayController {
    @FXML
    private HBox inventory;

    @FXML
    private AnchorPane anchorPane;

    public void updateInventory() {
        inventory.getChildren().clear();

        for (Item item : Run.getRInstance().getPlayer().getInventory()) {
            Text text = new Text(item.getName());
            text.setOnMouseClicked(event -> {
                String itemName = ((Text)event.getSource()).getText();
                Run.getRInstance().processCommand("use " + itemName);
            });
            inventory.getChildren().add(text);
        }
    }
}
