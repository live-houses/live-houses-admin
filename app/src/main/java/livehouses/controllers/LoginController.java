package livehouses.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import livehouses.db.DBConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userTextField;

    @FXML
    private void initialize() {
        loginButton.setOnAction((event) -> {
            if (userTextField.getText().isBlank() && passwordField.getText().isBlank()) {
                System.out.println("No user or password");
            } else {
                if (validateLogin()) {
                    try {
                        ScenesController controller = new ScenesController();
                        controller.switchToScene(event, "/fxml/adPanel.fxml");
                    } catch(Exception e) {
                        System.err.println("Error loading AdminPanel.fxml");
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public boolean validateLogin() {
        DBConection conectionNow = new DBConection();
        Connection connectDB = conectionNow.getConnection();

        String verifyLogin = "SELECT COUNT(1) FROM account WHERE email = ? AND hashed_password = ?";

        try (PreparedStatement statement = connectDB.prepareStatement(verifyLogin)) {
            statement.setString(1, userTextField.getText());
            statement.setString(2, passwordField.getText());

            try (ResultSet queryResult = statement.executeQuery()) {
                if (queryResult.next() && queryResult.getInt(1) == 1) {
                    System.out.println("Login success");
                    return true;
                } else {
                    System.out.println("Invalid login");
                    return false;
                }
            }
        } catch (SQLException e) {
            // Handle the exception
            e.printStackTrace();
        }
        return false;
    }
}
