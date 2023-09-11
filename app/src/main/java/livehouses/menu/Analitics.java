package livehouses.menu;

import livehouses.AppState;
import livehouses.utils.ConsoleUtils;
import livehouses.utils.pretty.Printer;

public class Analitics extends BaseMenu{
    public static MenuManager.Menu show(AppState appState) {
        drawHeader();

        Printer.print("Aqui irian analiticas");

        ConsoleUtils.pressEnterToContinue();
        return MenuManager.Menu.AdminPanelMenu;
    }

}
