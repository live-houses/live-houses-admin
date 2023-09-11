package livehouses.menu;

import livehouses.App;
import livehouses.AppState;
import livehouses.Local;
import livehouses.db.DB;
import livehouses.utils.ConsoleUtils;
import livehouses.utils.pretty.Printer;

public class LiveHouseManagment extends BaseMenu{
    public static MenuManager.Menu show(AppState appState) {
        drawHeader();

        Printer.print("Aqui pueden llevar el control de los livehouses.");
        Printer.newLine();
        Printer.newLine();
        App.scanner.nextLine();

        for (Local local : DB.getAllLocals()) {
            local.printInformation();
        }

        ConsoleUtils.pressEnterToContinue();
        return MenuManager.Menu.AdminPanelMenu;
    }
}
