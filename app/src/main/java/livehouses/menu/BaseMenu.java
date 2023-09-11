package livehouses.menu;

import java.util.List;

import livehouses.App;
import livehouses.utils.ConsoleUtils;
import livehouses.utils.pretty.Printer;

public class BaseMenu {
    static void drawHeader() {
        ConsoleUtils.clearScreen();
        Printer.newLine();
        Printer.newLine();
        Printer.prettyPrint("livehouse", 1, 5);
        Printer.newLine();
        Printer.newLine();
        Printer.print("Gestión de Live houses " + App.VERSION);
        Printer.newLine();
        Printer.newLine();
    }

    public static void drawSelector(List<String> selections) {
        System.out.println("\033[5;3H");
        for (int i = 0; i < selections.size(); i++) {
            Printer.print(i + ". " + selections.get(i));
        }
        Printer.newLine();
        Printer.print("\033[?25h" + "$");
    }
}
