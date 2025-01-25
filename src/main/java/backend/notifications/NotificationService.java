package backend.notifications;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {
    private final Map<String, List<String>> notifications;

    public NotificationService() {
        this.notifications = new HashMap<>();
        notifications.put("HOMEOWNER", new ArrayList<>());
        notifications.put("TECHNICIAN", new ArrayList<>());
        notifications.put("SECURITY_GUARD", new ArrayList<>());
    }

    // Add a notification for a specific role
    public void addNotification(String role, String message) {
        if (notifications.containsKey(role)) {
            notifications.get(role).add(message);
            System.out.println("Notification added for " + role + ": " + message);
        } else {
            System.out.println("Invalid role: " + role);
        }
    }

    // Get notifications for a specific role
    public List<String> getNotifications(String role) {
        return notifications.getOrDefault(role, new ArrayList<>());
    }

    // Clear notifications for a specific role
    public void clearNotifications(String role) {
        if (notifications.containsKey(role)) {
            notifications.get(role).clear();
            System.out.println("Notifications cleared for " + role);
        } else {
            System.out.println("Invalid role: " + role);
        }
    }
}

