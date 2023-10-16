package livehouses.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import livehouses.db.DBConection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

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


        aceptButton.setOnAction(event -> {
            if (livehouseName.getText().isBlank() || direccion.getText().isBlank() || aforo.getText().isBlank() || apertura.getText().isBlank() || cierre.getText().isBlank() || usuario.getText().isBlank() || contraseña.getText().isBlank() || email.getText().isBlank()) {
                errorMessage.setText("There is a blank field");
            } else {
                String name = livehouseName.getText();
                String address = direccion.getText();
                int capacity = Integer.parseInt(aforo.getText());
                String openingTime = apertura.getText();
                String closingTime = cierre.getText();
                String username = usuario.getText();
                String password = contraseña.getText();
                String email = this.email.getText();

                String data = "INSERT INTO local (name, direccion, aforo, apertura, cierre) VALUES ('" + name + "', '" + address + "', " + capacity + ", '" + openingTime + "', '" + closingTime + "');\n" +
                        "INSERT INTO account (username, hashed_password, email, role_id) VALUES ('" + username + "', '" + password + "', '" + email + "', '" + 2 +"');";
        
                DBConection conectionNow = new DBConection();
                Connection connectDB = conectionNow.getConnection();

                try{
                Statement statement = connectDB.createStatement();
                statement.executeQuery(data);

                }catch(Exception e){
                    e.printStackTrace();
                    e.getCause();
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
