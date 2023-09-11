package livehouses.menu;

import java.util.List;

import livehouses.pretty.Printer;

public class BaseMenu {
    public enum Menu {
        LoginAdminMenu,
        AdminPanelMenu,
        RegisterLocaleMenu,
        EventsManagerMenu
    }

    public static void drawSelector(List<String> selections) {
        System.out.println("\033[5;3H");
        for (int i = 0; i < selections.size(); i++) {
            Printer.PrintPadding(5);
            System.out.println(i + ". " + selections.get(i));
        }
        System.out.println();
        Printer.PrintPadding(5);
        System.out.print("\033[?25h");
        System.out.print("$  ");
    }
}






