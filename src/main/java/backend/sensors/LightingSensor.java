package backend.sensors;
public class LightingSensor extends Sensor {
    private int brightness; // Brightness level in percentage (0-100)

    public LightingSensor(String id, String location, int brightness) {
        super(id, location);
        this.brightness = brightness;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
        } else {
            throw new IllegalArgumentException("Brightness must be between 0 and 100.");
        }
    }

    @Override
    public String toString() {
        return "LightingSensor{" +
                "brightness=" + brightness +
                ", id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}

