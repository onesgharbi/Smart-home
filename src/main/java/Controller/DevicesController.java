package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class DevicesController {

    @FXML
    private VBox deviceList; // VBox in FXML to hold the list of devices

    @FXML
    private Label totalDevicesLabel; // Label for Total Devices count
    @FXML
    private Label activeDevicesLabel; // Label for Active Devices count
    @FXML
    private Label offlineDevicesLabel; // Label for Offline Devices count

    @FXML
    private Button addDeviceButton; // Button for adding new devices

    @FXML
    private Button allDevicesButton; // Button for "All Devices" category
    @FXML
    private Button activeDevicesButton; // Button for "Active Devices" category
    @FXML
    private Button offlineDevicesButton; // Button for "Offline Devices" category

    // Example data structure for devices
    private class Device {
        String name;
        String location;
        boolean isOnline;

        public Device(String name, String location, boolean isOnline) {
            this.name = name;
            this.location = location;
            this.isOnline = isOnline;
        }
    }

    // Example list of devices (replace this with real data from a database or API)
    private final Device[] devices = {
            new Device("Smart Light", "Living Room", true),
            new Device("Smart Thermostat", "Bedroom", false),
            new Device("Security Camera", "Garage", true),
            new Device("Smart Plug", "Kitchen", true),
            new Device("Water Sensor", "Basement", false)
    };

    // Initialization method
    @FXML
    public void initialize() {
        updateSummary(); // Update statistics
        populateDeviceList("all"); // Populate all devices initially

        // Attach button handlers
        addDeviceButton.setOnAction(event -> handleAddDevice());
        allDevicesButton.setOnAction(event -> populateDeviceList("all"));
        activeDevicesButton.setOnAction(event -> populateDeviceList("active"));
        offlineDevicesButton.setOnAction(event -> populateDeviceList("offline"));
    }

    // Updates the summary statistics
    private void updateSummary() {
        int totalDevices = devices.length;
        int activeDevices = (int) java.util.Arrays.stream(devices).filter(d -> d.isOnline).count();
        int offlineDevices = totalDevices - activeDevices;

        totalDevicesLabel.setText(String.valueOf(totalDevices));
        activeDevicesLabel.setText(String.valueOf(activeDevices));
        offlineDevicesLabel.setText(String.valueOf(offlineDevices));
    }

    // Populates the device list based on the selected category
    private void populateDeviceList(String category) {
        deviceList.getChildren().clear(); // Clear existing devices

        for (Device device : devices) {
            if (category.equals("all") ||
                    (category.equals("active") && device.isOnline) ||
                    (category.equals("offline") && !device.isOnline)) {

                HBox deviceEntry = createDeviceEntry(device);
                deviceList.getChildren().add(deviceEntry);
            }
        }
    }

    // Creates an HBox representing a single device entry
    private HBox createDeviceEntry(Device device) {
        HBox deviceEntry = new HBox(15);
        deviceEntry.setStyle("-fx-padding: 10px; -fx-border-color: #ddd; -fx-border-radius: 10; -fx-background-radius: 10; -fx-background-color: #f9f9f9;");

        // Device icon
        ImageView icon = new ImageView(new Image(getClass().getResource("/device_icon.png").toString()));
        icon.setFitWidth(50);
        icon.setFitHeight(50);

        // Device info
        VBox deviceInfo = new VBox();
        Label nameLabel = new Label(device.name);
        nameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        Label statusLabel = new Label(device.location + " - " + (device.isOnline ? "Online" : "Offline"));
        statusLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #777;");

        deviceInfo.getChildren().addAll(nameLabel, statusLabel);

        // Details button
        Button detailsButton = new Button("Details");
        detailsButton.setStyle("-fx-background-color: #c8a582; -fx-text-fill: white; -fx-border-radius: 5px;");
        detailsButton.setOnAction(event -> handleDeviceDetails(device));

        deviceEntry.getChildren().addAll(icon, deviceInfo, detailsButton);

        return deviceEntry;
    }

    // Handles the "Add Device" button click
    private void handleAddDevice() {
        System.out.println("Add Device button clicked!");
        // Logic to open a form or modal for adding a new device
    }

    // Handles the "Details" button click for a specific device
    private void handleDeviceDetails(Device device) {
        System.out.println("Details for: " + device.name);
        // Logic to show device details (e.g., in a new window or modal)
    }
}

