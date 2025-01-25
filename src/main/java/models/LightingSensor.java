package models;


public class LightingSensor extends sensor {
    private int brightness; // Current brightness level (e.g., 0 to 100%)

    public LightingSensor(String id, String location, int brightness) {
        super(id, location);
        this.brightness = brightness;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Brightness must be between 0 and 100.");
        }
        this.brightness = brightness;
        setLastUpdated(java.time.LocalDateTime.now());
    }

    @Override
    public String getData() {
        return "Brightness: " + brightness + "%";
    }

    @Override
    public String toString() {
        return "LightingSensor{" +
                "id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", brightness=" + brightness +
                ", lastUpdated=" + getLastUpdated() +
                '}';
    }
}

