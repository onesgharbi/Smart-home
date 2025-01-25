package backend.data;


import backend.sensors.Sensor;
import backend.sensors.TemperatureSensor;
import backend.sensors.HumiditySensor;

import java.util.List;

public class DataProcessor {

    // Calculate the average temperature from a list of sensors
    public double calculateAverageTemperature(List<Sensor> sensors) {
        double totalTemperature = 0;
        int count = 0;

        for (Sensor sensor : sensors) {
            if (sensor instanceof TemperatureSensor) {
                totalTemperature += ((TemperatureSensor) sensor).getTemperature();
                count++;
            }
        }

        return count == 0 ? 0 : totalTemperature / count;
    }

    // Find the maximum humidity recorded in a list of sensors
    public int findMaxHumidity(List<Sensor> sensors) {
        int maxHumidity = Integer.MIN_VALUE;

        for (Sensor sensor : sensors) {
            if (sensor instanceof HumiditySensor) {
                maxHumidity = Math.max(maxHumidity, ((HumiditySensor) sensor).getHumidity());
            }
        }

        return maxHumidity == Integer.MIN_VALUE ? 0 : maxHumidity;
    }
}

