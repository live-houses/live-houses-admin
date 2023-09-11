package livehouses.menu;

import livehouses.App;
import livehouses.AppState;
import livehouses.SystemUser;
import livehouses.db.DB;
import livehouses.db.UserNotFoundException;
import livehouses.utils.ConsoleUtils;
import livehouses.utils.pretty.Printer;

public class LoginMenu extends BaseMenu {

    public static MenuManager.Menu show(AppState appState) {
        drawHeader();
        Printer.print(". email> ");
        String email = App.scanner.nextLine();
        Printer.print(". contraseña> ");
        String password = App.scanner.nextLine();

        try {
            SystemUser loggedUser = DB.queryUser(email, password);
            appState.setLoggedUser(loggedUser);
            Printer.newLine();
            Printer.print("Logged successfully", 151, 247, 115);
            ConsoleUtils.pressEnterToContinue();
        } catch (UserNotFoundException e) {
            Printer.newLine();
            Printer.print("No se ha encontrado el usuario.");
            ConsoleUtils.pressEnterToContinue();
            return MenuManager.Menu.LoginAdminMenu;
        }
        return MenuManager.Menu.AdminPanelMenu;
    }
}
