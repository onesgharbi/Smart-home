package backend.sensors;

import backend.sensors.Sensor;
import backend.sensors.TemperatureSensor;
import backend.sensors.HumiditySensor;
import backend.sensors.MotionSensor;
import backend.sensors.LightingSensor;

import java.util.ArrayList;
import java.util.List;

public class SensorManager implements SensorService {
    private final List<Sensor> sensors;

    public SensorManager() {
        this.sensors = new ArrayList<>();
        // Add example sensors
        sensors.add(new TemperatureSensor("T1", "Living Room", 22.5));
        sensors.add(new HumiditySensor("H1", "Bedroom", 55));
        sensors.add(new MotionSensor("M1", "Entrance", false));
        sensors.add(new LightingSensor("L1", "Kitchen", 75));
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensors;
    }

    @Override
    public Sensor getSensorById(String id) {
        return sensors.stream()
                .filter(sensor -> sensor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateSensor(String id, Object value) {
        Sensor sensor = getSensorById(id);
        if (sensor instanceof TemperatureSensor && value instanceof Double) {
            ((TemperatureSensor) sensor).setTemperature((Double) value);
        } else if (sensor instanceof HumiditySensor && value instanceof Integer) {
            ((HumiditySensor) sensor).setHumidity((Integer) value);
        } else if (sensor instanceof MotionSensor && value instanceof Boolean) {
            ((MotionSensor) sensor).setMotionDetected((Boolean) value);
        } else if (sensor instanceof LightingSensor && value instanceof Integer) {
            ((LightingSensor) sensor).setBrightness((Integer) value);
        }
    }
}
