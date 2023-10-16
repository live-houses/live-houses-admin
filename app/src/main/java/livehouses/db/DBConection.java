package livehouses.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConection {
    public Connection databaselink;

    public Connection getConnection(){
        String databasename = "Livehouse";
        String username = "postgres";
        String password = "123";
        String URL = "jdbc:postgresql://localhost:5432/" + databasename;

        try{
            // Class.forName("com.postgresql.jdbc.Driver");
            databaselink = DriverManager.getConnection(URL, username, password);
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaselink;
    }
}
