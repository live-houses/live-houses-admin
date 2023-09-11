package livehouses.menu;

import livehouses.AppState;
import livehouses.utils.ConsoleUtils;
import livehouses.utils.pretty.Printer;

public class LiveHouseManagment extends BaseMenu{
    public static MenuManager.Menu show(AppState appState) {
        drawHeader();

        Printer.print("Aqui pueden llevar el control de los livehouses.");

        Printer.newLine();
        ConsoleUtils.pressEnterToContinue();
        return MenuManager.Menu.AdminPanelMenu;
    }
}
