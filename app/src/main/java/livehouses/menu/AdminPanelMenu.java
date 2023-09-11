package livehouses.menu;

import livehouses.App;
import livehouses.AppState;
import livehouses.Local;
import livehouses.db.DB;
import livehouses.utils.ConsoleUtils;
import livehouses.utils.pretty.Printer;

public class AdminPanelMenu extends BaseMenu{
    public static MenuManager.Menu show(AppState appState){
        drawHeader();
        boolean isAdmin = appState.getLoggedUser().permissionBits == 1;

        if (isAdmin) {
            Printer.print("Menú de administrador\n", 239, 185, 201);
            Printer.newLine();
            Printer.print(" 1 - Registrar nuevo Live-house");
            Printer.newLine();
            Printer.print(" 2 - Manejo de Livehouses");
            Printer.newLine();
            Printer.print(" 3 - Analíticas y estadísticas");
            Printer.newLine();
            Printer.print(" 4 - Log out");
            Printer.newLine();
            Printer.newLine();
        }
        else {
            String localAsignado = "";
            Printer.print("Menú de gerente de Live House\n", 239, 185, 201);
            for (Local local : DB.getAllLocals()) {
                if (local.managerID == appState.getLoggedUser().id) {
                    Printer.print("Local asignado: " + local.localName);
                    localAsignado = local.localName;
                    Printer.newLine();
                }
            }
            Printer.newLine();
            Printer.print(" 1 - (BLOQUEADO) Registrar nuevo Live-house");
            Printer.newLine();
            Printer.print(" 2 - Manejo tu livehouse " + localAsignado);
            Printer.newLine();
            Printer.print(" 3 - Analíticas y estadísticas");
            Printer.newLine();
            Printer.print(" 4 - Log out");
            Printer.newLine();
            Printer.newLine();
        }

        Printer.print(" >> ");
        int option = -1;
        try {
            option = App.scanner.nextInt();
        } catch (Exception e) {
            ConsoleUtils.pressEnterToContinue();
            return MenuManager.Menu.AdminPanelMenu;
        }

        switch (option) {
            case 1: {
                if (isAdmin) {
                    return MenuManager.Menu.RegisterLocaleMenu;
                }
                else {
                    return MenuManager.Menu.AdminPanelMenu;
                }
            }
            case 2: return MenuManager.Menu.LiveHouseManagment;
            case 3: return MenuManager.Menu.Analitics;
            case 4: {
                App.scanner.nextLine();
                return MenuManager.Menu.LoginAdminMenu;
            }
            default: return MenuManager.Menu.AdminPanelMenu;
        }
    }
}
