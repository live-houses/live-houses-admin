package livehouses.db;

import java.util.Arrays;
import java.util.List;

import livehouses.SystemUser;

public class DB {
    public static List<User> usersTable;
    public static List<Locale> localesTable;

    public static class User {
        private String email;
        private String fullname;
        private String password;
        private int id;

        // 1 - crear locales
        // 2 - modificar locales
        // 3 - crear gerentes
        // 4 - modificar permisos de gerentes
        // 5 - crear eventos
        // 6 - modificar eventos
        // 7 - acceder a analiticas de todos los locales
        private int permissionsBits = 0b0000000;

        public User(int id,
        String email, String fullname, String password, int permissions) {
            this.id = id;
            this.email = email;
            this.fullname = fullname;
            this.password = password;
            this.permissionsBits = permissions;
        }
    }

    public static class Locale {
        private int managerId;
        private String localName;
        private String direccion;

        public Locale(int managerId,String localName, String direccion) {
            this.managerId = managerId;
            this.localName = localName;
            this.direccion = direccion;
        }
    }

    public static void connect() {
        DB.usersTable = Arrays.asList(
            new User(1, "admin@utec.edu.pe", "Jhon Doe", "hola", 0b0000000),
            new User(2, "manager@mit.edu", "Jhon Doe", "hola", 0b0000000),
            new User(3, "dummy1@example.com", "Jhon Doe", "123", 0b0000000),
            new User(4, "123", "Juan Martinez", "123", 0b0000000),
            new User(3, "123", "Gerente Número 1", "123", 0b0000000),
            new User(4, "123", "Juan Martinez", "123", 0b0000000)
        );

        DB.localesTable = Arrays.asList(
            new Locale(1, "Live-house SiempreViva", "Av SiempreViva 123"),
            new Locale(2, "Live-house Rambla", "La Rambla de Huarochiri"),
            new Locale(3, "Live-house Camote", "Puente Camote"),
            new Locale(4, "Live-house amigos", "Hola amigos")
        );
    }

    // search for a given user in the users table
    public static SystemUser queryUser(String email, String password) throws UserNotFoundException {
        for (User user : DB.usersTable) {
            if (user.email.equals(email) && user.password.equals(password)) {
                return new SystemUser(
                    user.email,
                    user.fullname,
                    user.permissionsBits
                );
            }
        }
        throw new UserNotFoundException();
    }

    // Creates a new user and returns que newly generated id
    public static int insertUser(String email, String fullname, String password, int permissions) {
        int generatedId = DB.usersTable.size() + 1;
        DB.usersTable.add(
            new User(generatedId, email, fullname, password, permissions)
        );
        return generatedId;
    }

    // show all locals
    public static void getAllLocals(){
        for (Locale local : DB.localesTable) {
            System.out.println(local.direccion);
        }
    }

    // TODO: return an id here
    public static void insertLocal(String address, String localName, int managerId) {
        DB.localesTable.add(
            new Locale(managerId, localName, address)
        );
    }
}
