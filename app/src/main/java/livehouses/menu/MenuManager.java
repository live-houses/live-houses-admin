package livehouses.menu;

import livehouses.AppState;

public class MenuManager {
    AppState appState;

    public enum Menu {
        LoginAdminMenu,
        AdminPanelMenu,
        RegisterLocaleMenu,
        EventsManagerMenu,
        LiveHouseManagment,
        Analitics
    }

    public MenuManager(AppState appState) {
        this.appState = appState;
    }

    public void start() {
        Menu currentState = Menu.LoginAdminMenu;

        while (true) {
            switch (currentState) {
                case LoginAdminMenu: currentState = LoginMenu.show(appState); break;
                case AdminPanelMenu: currentState = AdminPanelMenu.show(appState); break;
                case LiveHouseManagment: currentState = LiveHouseManagment.show(appState); break;
                case Analitics: currentState = Analitics.show(appState); break;
                // TODO: Handle the events manager case
                // case EventsManagerMenu: currentState = EventsManagerMenu.show(appState); break;
                case RegisterLocaleMenu: currentState = CreateNewLocalForm.show(appState); break;
                // There is no default case, all menus should be handled
            }
        }
    }
}


