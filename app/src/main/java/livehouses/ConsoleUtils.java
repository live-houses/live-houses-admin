package livehouses;

public class ConsoleUtils {
    static char SEQUENCE_CODE = (char)27;

    public static void clearScreen() {
        System.out.print(SEQUENCE_CODE + "[H" + SEQUENCE_CODE + "[2J");
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
