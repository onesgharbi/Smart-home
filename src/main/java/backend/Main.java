package backend;
import backend.authentication.AuthenticationService;
import backend.authentication.RegistrationService;
import backend.sensors.SensorManager;
import backend.notifications.AlertManager;
import backend.notifications.NotificationService;
import backend.data.DataLogger;
import backend.data.DataReader;
import backend.data.DataProcessor;
import backend.sensors.Sensor;
import models.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize core services
        AuthenticationService authService = new AuthenticationService();
        RegistrationService regService = new RegistrationService(authService.getUsers());
        SensorManager sensorManager = new SensorManager();
        NotificationService notificationService = new NotificationService();
        AlertManager alertManager = new AlertManager(notificationService);
        DataLogger dataLogger = new DataLogger();
        DataReader dataReader = new DataReader();
        DataProcessor dataProcessor = new DataProcessor();


        // Sample JSON file for sensors
        String sensorFileName = "c:/sensors.json";

        // Load sensor data (if available)
        List<Sensor> sensors = dataReader.readSensorData(sensorFileName);
        if (sensors == null || sensors.isEmpty()) {
            System.out.println(" No sensors loaded. Using default sensors.");
            sensors = sensorManager.getAllSensors(); // Use default sensors if no file is found
        }
        // Interactive Console Menu
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSmart Home Monitoring System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. View Sensors");
            System.out.println("4. Generate Alerts");
            System.out.println("5. View Notifications");
            System.out.println("6. Process Historical Data");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    // Login
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    User user = authService.authenticate(username, password);
                    if (user != null) {
                        System.out.println("Login successful! Welcome, " + user.getUsername());
                        System.out.println("Your role: " + user.getRole());
                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                    }
                }
                case 2 -> {
                    // Register
                    System.out.print("Enter new username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter role (HOMEOWNER, TECHNICIAN, SECURITY_GUARD): ");
                    String role = scanner.nextLine().toUpperCase();

                    boolean registered = regService.registerUser(username, password, role);
                    if (registered) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Registration failed. User may already exist or invalid role provided.");
                    }
                }
                case 3 -> {
                    // View Sensors
                    System.out.println("Available Sensors:");
                    for (Sensor sensor : sensors) {
                        System.out.println(sensor);
                    }
                }
                case 4 -> {
                    // Generate Alerts
                    System.out.println("Generating Alerts...");
                    for (Sensor sensor : sensors) {
                        if (sensor instanceof backend.sensors.TemperatureSensor temperatureSensor) {
                            alertManager.generateTemperatureAlert("HOMEOWNER", temperatureSensor.getTemperature(), 25.0);
                        } else if (sensor instanceof backend.sensors.HumiditySensor humiditySensor) {
                            alertManager.generateHumidityAlert("HOMEOWNER", humiditySensor.getHumidity(), 60);
                        } else if (sensor instanceof backend.sensors.MotionSensor motionSensor) {
                            alertManager.generateMotionAlert("SECURITY_GUARD", motionSensor.isMotionDetected());
                        }
                    }
                    System.out.println("Alerts generated and notifications sent.");
                }
                case 5 -> {
                    // View Notifications
                    System.out.println("Notifications for HOMEOWNER:");
                    System.out.println(notificationService.getNotifications("HOMEOWNER"));
                    System.out.println("Notifications for TECHNICIAN:");
                    System.out.println(notificationService.getNotifications("TECHNICIAN"));
                    System.out.println("Notifications for SECURITY_GUARD:");
                    System.out.println(notificationService.getNotifications("SECURITY_GUARD"));
                }
                case 6 -> {
                    // Process Historical Data
                    double avgTemp = dataProcessor.calculateAverageTemperature(sensors);
                    int maxHumidity = dataProcessor.findMaxHumidity(sensors);
                    System.out.println("Average Temperature: " + avgTemp + "°C");
                    System.out.println("Maximum Humidity: " + maxHumidity + "%");
                }
                case 7 -> {
                    // Exit
                    System.out.println("Exiting the application...");
                    dataLogger.logSensorData(sensorFileName, sensors); // Save sensors to file
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}