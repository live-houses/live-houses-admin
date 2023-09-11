package livehouses.menu;

import livehouses.AppState;

public class MenuManager {
    AppState appState;

    public enum Menu {
        LoginAdminMenu,
        AdminPanelMenu,
        RegisterLocaleMenu,
        EventsManagerMenu
    }

    public MenuManager(AppState appState) {
        this.appState = appState;
    }

    public void start() {
        Menu currentState = Menu.LoginAdminMenu;

        while (true) {
            switch (currentState) {
                case LoginAdminMenu: currentState = LoginMenu.show(appState); break;
                case AdminPanelMenu: currentState = Menu.AdminPanelMenu; break;
                default: return;
            }
        }
    }
}


