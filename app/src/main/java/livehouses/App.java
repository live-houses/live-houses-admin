package livehouses;

import livehouses.db.DB;

public class App {
    public static void main(String[] args) {
        DB.connect();

        String email = "admin@utec.edu.pe";
        String password = "hola1asdjkfahjsdfjkajklsdfjkasjkdfñjk";

        try {
            SystemUser user = DB.queryUser(email, password);
            user.printInformation();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        DB.getAllLocals();
    }
}
