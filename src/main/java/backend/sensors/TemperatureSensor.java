package backend.sensors;

public class TemperatureSensor extends Sensor {
    private double temperature;

    public TemperatureSensor(String id, String location, double temperature) {
        super(id, location);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "TemperatureSensor{" +
                "temperature=" + temperature +
                ", id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}

