package livehouses.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import livehouses.App;
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
                var user = validateLogin();
                if (user != null) {
                    App.user = user;
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

    public class LoggedUser {
        public String roleName;
        public int acccountId;

        LoggedUser(String roleName, int accountId) {
            this.roleName = roleName;
            this.acccountId = accountId;
        }
    }

    public LoggedUser validateLogin() {
        DBConection conectionNow = new DBConection();
        Connection connectDB = conectionNow.getConnection();

        String verifyLogin =
            "SELECT r.role_name, a.id AS account_id " +
            "FROM account a " +
            "JOIN role r ON a.role_id = r.id " +
            "WHERE a.email = ? AND a.hashed_password = ?";

        try (PreparedStatement statement = connectDB.prepareStatement(verifyLogin)) {
            statement.setString(1, userTextField.getText());
            statement.setString(2, passwordField.getText());
            System.out.println("Login...");

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String roleName = resultSet.getString("role_name");
                    int accountId = resultSet.getInt("account_id");

                    return new LoggedUser(roleName, accountId);
                }
                return null;
            }
        } catch (SQLException e) {
            // Handle the exception
            e.printStackTrace();
        }
        return null;
    }
}
