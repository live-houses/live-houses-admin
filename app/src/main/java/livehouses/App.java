package livehouses;

import livehouses.db.DB;
import livehouses.menus.StateMachine;

public class App {
    public static void main(String[] args) {
        DB.connect();
        System.out.println("\033[H\033[2J");
        StateMachine.runStates();
    }
}
