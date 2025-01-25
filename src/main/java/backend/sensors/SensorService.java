package backend.sensors;

import backend.sensors.Sensor;

import java.util.List;

public interface SensorService {
    List<Sensor> getAllSensors();                // Get all sensors
    Sensor getSensorById(String id);             // Get a sensor by ID
    void updateSensor(String id, Object value);  // Update a specific sensor
}
