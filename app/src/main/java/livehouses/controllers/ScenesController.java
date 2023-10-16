package livehouses.controllers;

import java.io.IOException;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScenesController {
    
    public Stage stage;
    public Scene scene;
    public Parent root;

    public void switchToScene(ActionEvent event, String pathToFxml){
        try{
            root = FXMLLoader.load(getClass().getResource(pathToFxml));
            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        }catch (IOException E){
            System.err.println("Error loading " + pathToFxml);
            E.printStackTrace();
        }
    }
}
