package models;


public class TemperatureSensor extends sensor {
    private double temperature; // Current temperature value in Celsius

    public TemperatureSensor(String id, String location, double temperature) {
        super(id, location);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        setLastUpdated(java.time.LocalDateTime.now());
    }

    @Override
    public String getData() {
        return "Temperature: " + temperature + "°C";
    }

    @Override
    public String toString() {
        return "TemperatureSensor{" +
                "id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", temperature=" + temperature +
                ", lastUpdated=" + getLastUpdated() +
                '}';
    }
}

