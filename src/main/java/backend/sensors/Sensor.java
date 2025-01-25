package backend.sensors;

public abstract class Sensor {
    private final String id;
    private final String location;

    public Sensor(String id, String location) {
        this.id = id;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}


