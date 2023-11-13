package livehouses.controllers;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import livehouses.db.LocalesDAO;
import livehouses.db.models.Locale;

public class AdminPanelController {

    @FXML
    private Button addLocalButton;

    @FXML
    private Button logOutButton;

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
        localeTableView.getItems().addAll(locales);

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

        logOutButton.setOnAction((event) -> {
            ScenesController controller = new ScenesController();
            controller.switchToScene(event, "/fxml/login.fxml");
        });
    }

}
