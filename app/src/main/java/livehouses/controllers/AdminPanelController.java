package livehouses.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminPanelController {

    @FXML
    private Button addLocalButton;

    @FXML
    private Button logOutButton;

    @FXML
    private void initialize() {
        addLocalButton.setOnAction((event) -> {
            ScenesController controller = new ScenesController();
            controller.switchToScene(event, "/fxml/addingAdmin.fxml");
        });

        logOutButton.setOnAction((event) -> {
            ScenesController controller = new ScenesController();
            controller.switchToScene(event, "/fxml/login.fxml");
        });
    }

}
