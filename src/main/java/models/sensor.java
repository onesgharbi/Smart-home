package models;

import java.time.LocalDateTime;

public abstract class sensor {
    private final String id;           // Unique identifier for the sensor
    private final String location;     // Physical or logical location of the sensor
    private LocalDateTime lastUpdated; // Timestamp of the last update

    public sensor(String id, String location) {
        this.id = id;
        this.location = location;
        this.lastUpdated = LocalDateTime.now(); // Default to current time
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    // Abstract method to be implemented by specific sensor types
    public abstract String getData();

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}

