package models;


import java.time.LocalDateTime;

public class Alert {
    private String title; // Alert title, e.g., "Critical Temperature"
    private String message; // Detailed alert message
    private LocalDateTime timestamp; // When the alert was generated
    private boolean acknowledged; // Whether the alert has been acknowledged

    // Constructor
    public Alert(String title, String message, LocalDateTime timestamp) {
        this.title = title;
        this.message = message;
        this.timestamp = timestamp;
        this.acknowledged = false; // Default: not acknowledged
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isAcknowledged() {
        return acknowledged;
    }

    public void acknowledge() {
        this.acknowledged = true;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", acknowledged=" + acknowledged +
                '}';
    }
}

