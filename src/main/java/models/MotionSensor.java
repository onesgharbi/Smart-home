package models;


public class MotionSensor extends sensor {
    private boolean motionDetected; // True if motion is detected, false otherwise

    public MotionSensor(String id, String location, boolean motionDetected) {
        super(id, location);
        this.motionDetected = motionDetected;
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public void setMotionDetected(boolean motionDetected) {
        this.motionDetected = motionDetected;
        setLastUpdated(java.time.LocalDateTime.now());
    }

    @Override
    public String getData() {
        return motionDetected ? "Motion Detected" : "No Motion Detected";
    }

    @Override
    public String toString() {
        return "MotionSensor{" +
                "id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", motionDetected=" + motionDetected +
                ", lastUpdated=" + getLastUpdated() +
                '}';
    }
}

