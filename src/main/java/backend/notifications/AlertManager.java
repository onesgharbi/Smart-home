package backend.notifications;

public class AlertManager {
    private final NotificationService notificationService;

    public AlertManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Generate an alert for temperature thresholds
    public void generateTemperatureAlert(String role, double currentTemperature, double threshold) {
        if (currentTemperature > threshold) {
            String alert = "High temperature alert: " + currentTemperature + "°C exceeds threshold of " + threshold + "°C.";
            notificationService.addNotification(role, alert);
        } else if (currentTemperature < threshold) {
            String alert = "Low temperature alert: " + currentTemperature + "°C is below the threshold of " + threshold + "°C.";
            notificationService.addNotification(role, alert);
        }
    }

    // Generate an alert for motion detection
    public void generateMotionAlert(String role, boolean motionDetected) {
        if (motionDetected) {
            String alert = "Motion detected!";
            notificationService.addNotification(role, alert);
        } else {
            String alert = "No motion detected.";
            notificationService.addNotification(role, alert);
        }
    }

    // Generate an alert for humidity thresholds
    public void generateHumidityAlert(String role, int currentHumidity, int threshold) {
        if (currentHumidity > threshold) {
            String alert = "High humidity alert: " + currentHumidity + "% exceeds threshold of " + threshold + "%.";
            notificationService.addNotification(role, alert);
        } else if (currentHumidity < threshold) {
            String alert = "Low humidity alert: " + currentHumidity + "% is below the threshold of " + threshold + "%.";
            notificationService.addNotification(role, alert);
        }
    }
}

