package livehouses.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import livehouses.App;
import livehouses.db.DBConection;
import livehouses.db.LocalesDAO;
import livehouses.db.models.Locale;
import javafx.scene.input.MouseEvent;

public class AdminPanelController {

    @FXML
    private Button addLocalButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Locale> localeTableView;

    @FXML
    private TableColumn<Locale, Integer> idColumn;

    @FXML
    private TableColumn<Locale, String> nameColumn;

    @FXML
    private TableColumn<Locale, String> addressColumn;

    @FXML
    private TableColumn<Locale, Integer> capacityColumn;


    @FXML
    private TableColumn<Locale, String> openingHourColumn;

    @FXML
    private TableColumn<Locale, String> closingHourColumn;

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Integer>(cellData.getValue().getId()));
        nameColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
        addressColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAddress()));
        capacityColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Integer>(cellData.getValue().getCapacity()));
        openingHourColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getOpeningHour()));
        closingHourColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getClosingTime()));

        var localesDAO = new LocalesDAO();
        var locales = localesDAO.getAllLocales();

        if (App.user.roleName.equals("gerente")) {
            localeTableView.getItems().addAll(
                locales.stream().filter(locale -> locale.getManagerAccountId() == App.user.acccountId).toList()
            );
        }
        else {
            localeTableView.getItems().addAll(locales);
        }

        for (Locale locale : locales) {
            System.out.println("ID: " + locale.getId());
            System.out.println("Manager Account ID: " + locale.getManagerAccountId());
            System.out.println("Name: " + locale.getName());
            System.out.println("Address: " + locale.getAddress());
            System.out.println("Geolocation: " + locale.getGeolocation());
            System.out.println("Capacity: " + locale.getCapacity());
            System.out.println("Opening Hour: " + locale.getOpeningHour());
            System.out.println("Closing Time: " + locale.getClosingTime());
            System.out.println("--------------------");
        }

        addLocalButton.setOnAction((event) -> {
            ScenesController controller = new ScenesController();
            controller.switchToScene(event, "/fxml/addingAdmin.fxml");
        });

        localeTableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {
                // Single-click detected
                Locale selectedData = localeTableView.getSelectionModel().getSelectedItem();
                if (selectedData != null) {
                    // User selected something
                    System.out.println("Selected: " + selectedData.toString());
                }
            } else if (event.getClickCount() == 2) {
                // Double-click detected
                Locale doubleClickedData = localeTableView.getSelectionModel().getSelectedItem();
                if (doubleClickedData != null) {
                    // Extract the value from the selected item for the specific column
                    String columnValue = nameColumn.getCellData(doubleClickedData);

                    // Display or use the column value as needed
                    System.out.println("Double-clicked on value: " + columnValue);

                    // Query to eliminate
                    deleteRowFromDatabase(columnValue);
                }
            }
        });

        logOutButton.setOnAction((event) -> {
            ScenesController controller = new ScenesController();
            controller.switchToScene(event, "/fxml/login.fxml");
        });

        deleteButton.setOnAction((event) -> {
            ScenesController controller = new ScenesController();
            controller.switchToScene(event, "/fxml/adPanel.fxml");
        });
    }

    private void deleteRowFromDatabase(String rowName) {
        DBConection conectionNow = new DBConection();
        String deleteQuery = "DELETE FROM locale WHERE name = ?";
        try (Connection connectDB = conectionNow.getConnection();
            PreparedStatement preparedStatement = connectDB.prepareStatement(deleteQuery);) {
            preparedStatement.setString(1, rowName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
