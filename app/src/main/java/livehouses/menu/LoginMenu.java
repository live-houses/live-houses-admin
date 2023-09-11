package livehouses.menu;

import java.util.Scanner;

import livehouses.db.DB;
import livehouses.db.DB.User;
import livehouses.pretty.Printer;

public class LoginMenu extends BaseMenu {
    public static void draw() {
        System.out.println("\033[1;1H");
        System.out.println("\033[?25l");
        Printer.Print("livehouse", 1, 3);
        System.out.println();
    }

    public static User AdminUserRetrieve() {
        //this is a dummy user that will be used for further authentications
        User returnableUser = new User(null, null, null, 0, 0);
        Scanner blockingScan = new Scanner(System.in);

        System.out.print("\033[?25h");
        System.out.println("\033[5;3H");
        Printer.PrintPadding(5);
        System.out.print(". email> ");

        returnableUser.setEmail(blockingScan.nextLine());

        Printer.PrintPadding(5);
        System.out.print(". contraseña> ");

        returnableUser.setPassword(blockingScan.nextLine());
        return returnableUser;
    }

    public static Menu run() {
        int i = 0;

        while(true) {
            draw();
            User check = AdminUserRetrieve();
            try {
                DB.queryUser(check);
            } catch (Exception e) {
                System.err.println(e);
                return Menu.LoginAdminMenu;
            }

            return Menu.AdminPanelMenu;
        }
    }
}






