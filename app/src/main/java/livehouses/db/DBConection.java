package livehouses.db;

import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;

public class DBConection {
    public Connection databaselink;

    public Connection getConnection(){

        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("POSTGRESQL_URL") + dotenv.get("POSTGRESQL_DATABASE");
        String user = dotenv.get("POSTBRESQL_USER");
        String password = dotenv.get("POSTGRESQL_PASSWORD");

        try{
            // Class.forName("com.postgresql.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaselink;
    }
}
