package helper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLFactory {
    private static final String PROPERTIES_FILE = "application.properties";

    public static Connection createConnection() {
        Properties properties = loadProperties();

        try {
            return DriverManager.getConnection(
                    properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password")
            );
        }
        catch (SQLException ex) {};
        return null;
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream =
             MySQLFactory.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {

            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
