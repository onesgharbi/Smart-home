package utils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logInfo(String message) {
        System.out.println(formatLog("INFO", message));
    }

    public static void logWarning(String message) {
        System.out.println(formatLog("WARNING", message));
    }

    public static void logError(String message) {
        System.err.println(formatLog("ERROR", message));
    }

    private static String formatLog(String level, String message) {
        return String.format("[%s] [%s] %s", LocalDateTime.now().format(formatter), level, message);
    }
}


