package livehouses.menu;

import java.util.List;

import livehouses.utils.pretty.Printer;

public class BaseMenu {
    static void drawHeader() {
        Printer.newLine();
        Printer.prettyPrint("livehouse", 1, 3);
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
