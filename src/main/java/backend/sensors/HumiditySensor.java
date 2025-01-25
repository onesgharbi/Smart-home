package backend.sensors;

public class HumiditySensor extends Sensor {
    private int humidity;

    public HumiditySensor(String id, String location, int humidity) {
        super(id, location);
        this.humidity = humidity;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "HumiditySensor{" +
                "humidity=" + humidity +
                ", id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}
