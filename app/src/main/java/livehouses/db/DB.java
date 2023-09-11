package livehouses.db;

import java.util.Arrays;
import java.util.List;

import livehouses.SystemUser;


public class DB {
    public static List<User> usersTable;

    public static class User {
        private String email;
        private String fullname;
        private String password;
        private int permissionsBits;

        public User(String email, String fullname, String password, int permissions) {
            this.email = email;
            this.fullname = fullname;
            this.password = password;
            this.permissionsBits = permissions;
        }
    }

    public static void connect() {
        DB.usersTable = Arrays.asList(
            new User("admin@utec.edu.pe", "Jhon Doe", "hola", 0b0101010),
            new User("manager@mit.edu", "Jhon Doe", "hola", 0b11000111),
            new User("dummy1@example.com", "Jhon Doe", "123", 0b11000111),
            new User("dummy2@example.com", "Juan Martinez", "123", 0b11000111)
        );
    }

    // search for a given user in the users table
    public static SystemUser queryUser(String email, String password) throws UserNotFoundException {

        for (User user : DB.usersTable) {
            // existe correo
            if (user.email == email && user.password == password) {
                return new SystemUser(user.email, user.fullname, user.permissionsBits);
            }
        }
        throw new UserNotFoundException();
    }
}
