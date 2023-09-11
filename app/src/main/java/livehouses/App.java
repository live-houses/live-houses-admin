package livehouses;

import java.util.Scanner;

import livehouses.db.DB;
import livehouses.menu.MenuManager;
import livehouses.utils.ConsoleUtils;

public class App {
    static AppState state = new AppState();
    static MenuManager menuManager = new MenuManager(state);
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DB.connect();
        ConsoleUtils.clearScreen();
        menuManager.start();

        scanner.close();
    }
}
