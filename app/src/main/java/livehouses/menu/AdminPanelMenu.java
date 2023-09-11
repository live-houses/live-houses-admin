package livehouses.menu;

import java.util.List;

import livehouses.App;
import livehouses.AppState;
import livehouses.SystemUser;
import livehouses.db.DB;
import livehouses.db.UserNotFoundException;
import livehouses.menu.MenuManager.Menu;
import livehouses.utils.ConsoleUtils;
import livehouses.utils.pretty.Printer;

public class AdminPanelMenu extends BaseMenu{
    public static MenuManager.Menu show(AppState appState){
        drawHeader();

        Printer.printPadding(5);
        Printer.print("Escoge una opcion:");
        Printer.newLine();
        Printer.print(". 1 - Registrar nuevo Livehouses");
        Printer.newLine();
        Printer.print(". 2 - Manejo de Livehouses");
        Printer.newLine();
        Printer.print(". 3 - Analíticas");
        Printer.newLine();

        int option = App.scanner.nextInt();

        switch (option) { 
            case 1: 
            return MenuManager.Menu.RegisterLocaleMenu; 
            case 2:
            return MenuManager.Menu.LiveHouseManagment; 
            case 3:
            return MenuManager.Menu.Analitics;
            default: return MenuManager.Menu.AdminPanelMenu;
        }
    }
}
