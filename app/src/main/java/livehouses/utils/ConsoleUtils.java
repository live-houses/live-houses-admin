package livehouses.utils;

import livehouses.App;
import livehouses.utils.pretty.Printer;

public class ConsoleUtils {
    static char SEQUENCE_CODE = (char)27;

    public static void clearScreen() {
        System.out.print(SEQUENCE_CODE + "[H" + SEQUENCE_CODE + "[2J");
    }

    public static void pressEnterToContinue() {
        Printer.newLine();
        Printer.print(". Presione ENTER para continuar");
        App.scanner.nextLine();
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms, 0);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
