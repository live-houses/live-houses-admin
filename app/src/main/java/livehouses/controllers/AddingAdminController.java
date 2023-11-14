package livehouses.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import livehouses.db.DBConection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddingAdminController {

    @FXML
    private Button aceptButton;

    @FXML
    private Button cancelButton1;

    @FXML
    private TextField aforo;

    @FXML
    private TextField apertura;

    @FXML
    private TextField cierre;

    @FXML
    private TextField contraseña;

    @FXML
    private TextField direccion;

    @FXML
    private TextField email;

    @FXML
    private Label errorMessage;

    @FXML
    private TextField livehouseName;

    @FXML
    private TextField usuario;

    @FXML
    private void initialize() {
        aceptButton.setOnAction((event) -> {
            if (livehouseName.getText().isBlank() || direccion.getText().isBlank() || aforo.getText().isBlank() || apertura.getText().isBlank() || cierre.getText().isBlank() || usuario.getText().isBlank() || contraseña.getText().isBlank() || email.getText().isBlank()) {
                errorMessage.setText("Un campo está vacío");
            } else {
                String name = livehouseName.getText();
                String address = direccion.getText();
                int capacity = Integer.parseInt(aforo.getText());
                String openingTime = apertura.getText();
                String closingTime = cierre.getText();
                String username = usuario.getText();
                String password = contraseña.getText();
                String email = this.email.getText();

                String insertAccountQuery = "INSERT INTO account (role_id, username, email, hashed_password, salt) VALUES (?, ?, ?, ?, ?) RETURNING id";
                String insertLocalQuery = "INSERT INTO locale (manager_account_id, name, address, geolocation, capacity, opening_hour, closing_time) VALUES (?, ?, ?, ?, ?, ?, ?)";

                DBConection conectionNow = new DBConection();
                try (Connection connectDB = conectionNow.getConnection();
                    PreparedStatement insertAccountStatement = connectDB.prepareStatement(insertAccountQuery);
                    PreparedStatement insertLocalStatement = connectDB.prepareStatement(insertLocalQuery)) {

                    // Set parameters for the first insert (account table)
                    insertAccountStatement.setInt(1, 2);  // role_id
                    insertAccountStatement.setString(2, username);
                    insertAccountStatement.setString(3, email);
                    insertAccountStatement.setString(4, password);
                    insertAccountStatement.setInt(5, 42);  // salt

                    // Execute the first insert and retrieve the generated ID
                    int temporal;
                    try (var resultSet = insertAccountStatement.executeQuery()) {
                        resultSet.next();
                        temporal = resultSet.getInt(1);
                    }

                    // Set parameters for the second insert (local table)
                    insertLocalStatement.setInt(1, temporal);  // id_account_manager
                    insertLocalStatement.setString(2, name);
                    insertLocalStatement.setString(3, address);
                    insertLocalStatement.setString(4, address);
                    insertLocalStatement.setInt(5, capacity);
                    insertLocalStatement.setString(6, openingTime);
                    insertLocalStatement.setString(7, closingTime);

                    // Execute the second insert
                    insertLocalStatement.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    ScenesController controller = new ScenesController();
                    controller.switchToScene(event, "/fxml/adPanel.fxml");
                }
            }
        });
    }

    @FXML
    void goBack(ActionEvent event) {
        ScenesController controller = new ScenesController();
        controller.switchToScene(event, "/fxml/adPanel.fxml");
    }
}
