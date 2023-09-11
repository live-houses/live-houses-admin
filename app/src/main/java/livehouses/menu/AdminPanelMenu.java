package livehouses.menu;

import livehouses.App;
import livehouses.AppState;
import livehouses.utils.ConsoleUtils;
import livehouses.utils.pretty.Printer;

public class AdminPanelMenu extends BaseMenu{
    public static MenuManager.Menu show(AppState appState){
        drawHeader();

        Printer.print("Menú de administrador\n", 239, 185, 201);
        Printer.newLine();
        Printer.print(" 1 - Registrar nuevo Live-house");
        Printer.newLine();
        Printer.print(" 2 - Manejo de Livehouses");
        Printer.newLine();
        Printer.print(" 3 - Analíticas y estadísticas");
        Printer.newLine();
        Printer.newLine();

        Printer.print(" >> ");
        int option = -1;
        try {
            option = App.scanner.nextInt();
        } catch (Exception e) {
            ConsoleUtils.pressEnterToContinue();
            return MenuManager.Menu.AdminPanelMenu;
        }

        switch (option) {
            case 1: return MenuManager.Menu.RegisterLocaleMenu;
            case 2: return MenuManager.Menu.LiveHouseManagment;
            case 3: return MenuManager.Menu.Analitics;
            default: return MenuManager.Menu.AdminPanelMenu;
        }
    }
}
