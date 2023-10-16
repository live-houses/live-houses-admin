package livehouses.controllers;

import org.checkerframework.checker.units.qual.s;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import livehouses.controllers.ScenesController;

public class AdminPanelController {

    @FXML
    private Button addLocalButton;

    @FXML
    private Button logOutButton;

    @FXML
    private void initialize() {
        addLocalButton.setOnAction(event -> {
            ScenesController controller = new ScenesController();
            controller.switchToScene(event, "/fxml/addingAdmin.fxml");
        });

        logOutButton.setOnAction(event -> {
            ScenesController controller = new ScenesController();
            controller.switchToScene(event, "/fxml/login.fxml");
        });
    }

}
