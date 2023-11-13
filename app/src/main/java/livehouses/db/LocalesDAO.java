package livehouses.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import livehouses.db.models.Locale;

public class LocalesDAO {
    public List<Locale> getAllLocales() {
        DBConection connection = new DBConection();

        List<Locale> locales = new ArrayList<>();
        String query = "SELECT * FROM locale";

        try (Connection conn = connection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Locale locale = new Locale();
                locale.setId(resultSet.getInt("id"));
                locale.setManagerAccountId(resultSet.getInt("manager_account_id"));
                locale.setName(resultSet.getString("name"));
                locale.setAddress(resultSet.getString("address"));
                locale.setGeolocation(resultSet.getString("geolocation"));
                locale.setCapacity(resultSet.getShort("capacity"));
                locale.setOpeningHour(resultSet.getString("opening_hour"));
                locale.setClosingTime(resultSet.getString("closing_time"));
                locales.add(locale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locales;
    }
}
