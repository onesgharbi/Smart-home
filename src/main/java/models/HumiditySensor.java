package models;

public class HumiditySensor extends sensor {
    private int humidity; // Current humidity value in percentage

    public HumiditySensor(String id, String location, int humidity) {
        super(id, location);
        this.humidity = humidity;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        setLastUpdated(java.time.LocalDateTime.now());
    }

    @Override
    public String getData() {
        return "Humidity: " + humidity + "%";
    }

    @Override
    public String toString() {
        return "HumiditySensor{" +
                "id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", humidity=" + humidity +
                ", lastUpdated=" + getLastUpdated() +
                '}';
    }
}

