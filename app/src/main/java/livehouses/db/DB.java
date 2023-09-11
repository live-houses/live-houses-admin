package livehouses.db;

import java.util.Arrays;
import java.util.List;

import livehouses.LocalManager;
import livehouses.SystemUser;
import livehouses.Local;


public class DB {
    public static List<User> usersTable;
    public static List<Locale> localesTable;

    public static class User {
        private String email;
        private String fullname;
        private String password;
        private int id;

        // 0000000
        // |||||||
        // 1234567
        // 1 - crear locales
        // 2 - modificar locales
        // 3 - crear gerentes
        // 4 - modificar permisos de gerentes
        // 5 - crear eventos
        // 6 - modificar eventos
        // 7 - acceder a analiticas de todos los locales
        private int permissionsBits = 0b0000000;

        public User(String email, String fullname, String password, int id, int permissions) {
            this.email = email;
            this.fullname = fullname;
            this.password = password;
            this.id = id;
            this.permissionsBits = permissions;
        }
    }

    public static class Locale {
        private int managerId;
        private String direccion;

        public Locale(int managerId, String direccion) {
            this.direccion = direccion;
            this.managerId = managerId;
        }
    }

    public static void connect() {
        DB.usersTable = Arrays.asList(
            new User("admin@utec.edu.pe", "Jhon Doe", "hola", 1, 0b0000000),
            new User("manager@mit.edu", "Jhon Doe", "hola", 2, 0b0000000),
            new User("dummy1@example.com", "Jhon Doe", "123", 3, 0b0000000),
            new User("dummy2@example.com", "Juan Martinez", "123", 4, 0b0000000)
        );
        DB.localesTable = Arrays.asList(
            new Locale(1, "Av SiempreViva 123"),
            new Locale(2, "La Rambla de Huarochiri"),
            new Locale(3, "Puente Camote"),
            new Locale(4, "Hola amigos")
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

    // show all locals
    public static void getAllLocals(){
        for (Locale local : DB.localesTable) {
            System.out.println(local.direccion);
        }
    }
}
