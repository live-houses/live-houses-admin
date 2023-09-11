package livehouses.menu;

import java.util.Random;

import livehouses.App;
import livehouses.AppState;
import livehouses.db.DB;
import livehouses.menu.MenuManager.Menu;
import livehouses.utils.ConsoleUtils;
import livehouses.utils.pretty.Printer;

public class CreateNewLocalForm extends BaseMenu {

    public static MenuManager.Menu show(AppState appState) {
        drawHeader();
        Printer.print("Creación de nuevo local Live-house\n\n", 239, 185, 201);

        Printer.print("[Información de Local]\n\n");

        App.scanner.nextLine();
        Printer.print(". Nombre del local> ");
        String localName = App.scanner.nextLine();
        Printer.print(". Direccións> ");
        String address = App.scanner.nextLine();

        Printer.newLine();
        Printer.print("[Información del gerente]\n\n");
        Printer.print(". Nombre del gerente> ");
        String managerFullname = App.scanner.nextLine();
        Printer.print(". Email> ");
        String managerEmail = App.scanner.nextLine();

        // autogenerate random 8 charaters password
        int length = 8;
        Random random = new Random();
        String password = random.ints(48, 122)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        Printer.print("Confirma la creación del local? [y/n]");
        Printer.print(">> ");
        String confirm = App.scanner.nextLine();

        if (confirm.equals("y")) {
            int managerId = DB.insertUser(managerEmail, managerFullname, password, length);
            DB.insertLocal(address, localName, managerId);
            Printer.print("Local creado correctamente");
        }
        else {
            Printer.print("Operación cancelada");
        }
        ConsoleUtils.pressEnterToContinue();
        return Menu.AdminPanelMenu;
    }
}
