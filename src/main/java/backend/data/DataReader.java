package backend.data;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import backend.sensors.Sensor;
import backend.sensors.TemperatureSensor;
import backend.sensors.HumiditySensor;
import backend.sensors.MotionSensor;
import backend.sensors.LightingSensor;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private final Gson gson;

    public DataReader() {
        gson = new Gson();
    }

    // Reads sensor data from a JSON file
    public List<Sensor> readSensorData(String fileName) {
        List<Sensor> sensors = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName)) {
            Type listType = new TypeToken<List<Sensor>>() {}.getType();
            List<Sensor> rawData = gson.fromJson(reader, listType);

            // Convert raw data into proper sensor instances
            for (Sensor sensor : rawData) {
                switch (sensor.getClass().getSimpleName()) {
                    case "TemperatureSensor":
                        sensors.add(new TemperatureSensor(sensor.getId(), sensor.getLocation(), ((TemperatureSensor) sensor).getTemperature()));
                        break;
                    case "HumiditySensor":
                        sensors.add(new HumiditySensor(sensor.getId(), sensor.getLocation(), ((HumiditySensor) sensor).getHumidity()));
                        break;
                    case "MotionSensor":
                        sensors.add(new MotionSensor(sensor.getId(), sensor.getLocation(), ((MotionSensor) sensor).isMotionDetected()));
                        break;
                    case "LightingSensor":
                        sensors.add(new LightingSensor(sensor.getId(), sensor.getLocation(), ((LightingSensor) sensor).getBrightness()));
                        break;
                }
            }
            System.out.println("Data read successfully from " + fileName);
        } catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
        }

        return sensors;
    }
}