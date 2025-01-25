package backend.data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import backend.sensors.Sensor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataLogger {
    private final Gson gson;

    public DataLogger() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Logs a list of sensors to a JSON file
    public void logSensorData(String fileName, List<Sensor> sensors) {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(sensors, writer);
            System.out.println("Data logged successfully to " + fileName);
        } catch (IOException e) {
            System.err.println("Error logging data to file: " + e.getMessage());
        }
    }
}

