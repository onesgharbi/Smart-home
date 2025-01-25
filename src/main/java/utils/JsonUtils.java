package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtils {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void writeToJsonFile(String filePath, T data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
            Logger.logInfo("Data successfully written to JSON file: " + filePath);
        } catch (IOException e) {
            Logger.logError("Error writing to JSON file: " + e.getMessage());
        }
    }

    // Deserialize a JSON file to an object
    public static <T> T readFromJsonFile(String filePath, Class<T> classType) {
        try (FileReader reader = new FileReader(filePath)) {
            Logger.logInfo("Reading data from JSON file: " + filePath);
            return gson.fromJson(reader, classType);
        } catch (IOException e) {
            Logger.logError("Error reading from JSON file: " + e.getMessage());
            return null;
        }
    }
}

