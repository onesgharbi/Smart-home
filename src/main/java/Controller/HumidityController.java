package Controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class HumidityController {

    @FXML
    private Label averageHumidityLabel; // Label for Average Humidity
    @FXML
    private Label highestHumidityLabel; // Label for Highest Humidity
    @FXML
    private LineChart<String, Number> humidityChart; // LineChart for Humidity Trends
    @FXML
    private ToggleButton livingRoomToggle; // Toggle for Living Room Humidifier
    @FXML
    private ToggleButton bedroomToggle; // Toggle for Bedroom Humidifier
    @FXML
    private Button addDeviceButton; // Button to Add a New Device

    // Sample data for demonstration
    private double averageHumidity = 55.0;
    private double highestHumidity = 70.0;

    @FXML
    public void initialize() {
        // Set initial values for summary labels
        updateSummaryLabels();

        // Populate the humidity trend chart
        populateHumidityChart();

        // Attach actions to toggle buttons
        livingRoomToggle.setOnAction(event -> handleDeviceToggle(livingRoomToggle, "Living Room Humidifier"));
        bedroomToggle.setOnAction(event -> handleDeviceToggle(bedroomToggle, "Bedroom Humidifier"));

        // Attach action to add device button
        addDeviceButton.setOnAction(event -> handleAddDevice());
    }

    // Updates the average and highest humidity labels
    private void updateSummaryLabels() {
        averageHumidityLabel.setText(String.format("%.0f%%", averageHumidity));
        highestHumidityLabel.setText(String.format("%.0f%%", highestHumidity));
    }

    // Populates the LineChart with sample humidity trend data
    private void populateHumidityChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Humidity");

        // Example data points
        series.getData().add(new XYChart.Data<>("Day 1", 50));
        series.getData().add(new XYChart.Data<>("Day 2", 55));
        series.getData().add(new XYChart.Data<>("Day 3", 60));
        series.getData().add(new XYChart.Data<>("Day 4", 70));
        series.getData().add(new XYChart.Data<>("Day 5", 65));

        humidityChart.getData().clear();
        humidityChart.getData().add(series);
    }

    // Handles the toggling of a device
    private void handleDeviceToggle(ToggleButton toggleButton, String deviceName) {
        String status = toggleButton.isSelected() ? "On" : "Off";
        System.out.println(deviceName + " status: " + status);

        // Update UI or backend state as needed
    }

    // Handles the "Add Device" button click
    private void handleAddDevice() {
        System.out.println("Add Device button clicked!");
        // Logic to open a form or modal for adding a new device
    }
}

