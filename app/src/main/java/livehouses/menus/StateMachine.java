package livehouses.menus;

import livehouses.menu.BaseMenu;
import livehouses.menu.LoginMenu;
import livehouses.menu.BaseMenu.Menu;

public class StateMachine {
    public static void runStates() {
        BaseMenu.Menu currentState = BaseMenu.Menu.LoginAdminMenu;

        while (true) {
            switch (currentState) {
                case LoginAdminMenu:
                    currentState = LoginMenu.run();
                    break;
                case AdminPanelMenu:
                    currentState = Menu.AdminPanelMenu;
                default:
                    return;
            }
        }
    }
}


