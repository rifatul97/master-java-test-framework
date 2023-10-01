package helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ApplicationProperties {

    private static final String PROPERTIES_FILE = "application.properties";

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = MySQLFactory.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getValue(String key) {
        return loadProperties().getProperty(key);
    }
}
