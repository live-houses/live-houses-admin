package livehouses.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userTextField;

    // setup events
    @FXML
    private void initialize() {
        loginButton.setOnAction(event -> {
            System.out.println("Login button pressed");
            System.out.println("Username: " + userTextField.getText());
            System.out.println("Password: " + passwordField.getText());
        });
    }
}
