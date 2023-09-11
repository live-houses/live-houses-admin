package livehouses;

import livehouses.db.DB;
import livehouses.menu.LoginMenu;
import livehouses.menu.BaseMenu.Menu;
import livehouses.menu.BaseMenu;

public class App {
    public static void main(String[] args) {
        DB.connect();

        System.out.println("\033[H\033[2J");
        BaseMenu.Menu currentState = Menu.LoginAdminMenu;

        while (true) {
            switch (currentState) {
                case LoginAdminMenu:
                    currentState = LoginMenu.run();
                    break;
                default:
                    currentState = LoginMenu.run();
                    break;
            };
        }

        DB.getAllLocals();
    }
}
