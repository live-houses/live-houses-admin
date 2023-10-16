package livehouses;

import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import livehouses.menu.MenuManager;
// import io.github.cdimascio.dotenv.Dotenv;

public class App extends Application {
    static AppState state = new AppState();
    static MenuManager menuManager = new MenuManager(state);
    public static Scanner scanner = new Scanner(System.in);
    public static String VERSION = "v0.1.0";

    // static final Dotenv dotenv = Dotenv.load();
    // static final String url = dotenv.get("POSTGRESQL_URL") + dotenv.get("POSTGRESQL_DATABASE");
    // static final String user = dotenv.get("POSTBRESQL_USER");
    // static final String password = dotenv.get("POSTGRESQL_PASSWORD");

    // static public Connection connect() {
    //     Connection conn = null;
    //     try {
    //         conn = DriverManager.getConnection(url, user, password);
    //         System.out.println("Connected to the PostgreSQL server successfully.");
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //     }

    //     return conn;
    // }

    @Override
    public void start(Stage stage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        }
        catch(IOException e){
            System.err.println("Error loading login.fxml");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
