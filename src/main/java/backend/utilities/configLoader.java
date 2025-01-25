package backend.utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configLoader {
    private final Properties properties;

    public configLoader(String filePath) {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
            System.out.println("Configuration loaded successfully from " + filePath);
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
        }
    }

    // Retrieve a configuration value by key
    public String getConfig(String key) {
        return properties.getProperty(key);
    }

    // Retrieve a configuration value by key with a default value
    public String getConfig(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}

