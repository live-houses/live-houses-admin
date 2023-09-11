package livehouses.menu;

import livehouses.pretty.Printer;

public class LoginMenu extends BaseMenu {
    public static void draw() {
        System.out.println("\033[1;1H");
        System.out.println("\033[?25l");
        Printer.Print("livehouse", 1);
    }

    public static Menu run() {
        int i = 0;
        while(true) {
            draw();
            i++;
            if (i == 1000) {
                return Menu.LoginAdminMenu;
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}






