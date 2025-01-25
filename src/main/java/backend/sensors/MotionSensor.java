package backend.sensors;
public class MotionSensor extends Sensor {
    private boolean motionDetected;

    public MotionSensor(String id, String location, boolean motionDetected) {
        super(id, location);
        this.motionDetected = motionDetected;
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public void setMotionDetected(boolean motionDetected) {
        this.motionDetected = motionDetected;
    }

    @Override
    public String toString() {
        return "MotionSensor{" +
                "motionDetected=" + motionDetected +
                ", id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}
