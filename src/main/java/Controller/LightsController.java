package Controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class LightsController {

    @FXML
    private Label totalSensorsLabel; // Label to display total sensors
    @FXML
    private Label activeSensorsLabel; // Label to display active sensors
    @FXML
    private BarChart<String, Number> activityChart; // BarChart for lighting activity
    @FXML
    private ToggleButton livingRoomToggle; // Toggle button for Living Room sensor
    @FXML
    private ToggleButton bedroomToggle; // Toggle button for Bedroom sensor
    @FXML
    private Button addSensorButton; // Button to add a new sensor

    // Sample data
    private int totalSensors = 3;
    private int activeSensors = 2;

    @FXML
    public void initialize() {
        // Initialize summary labels
        updateSummaryLabels();

        // Populate the activity chart with sample data
        populateActivityChart();

        // Attach actions to toggle buttons
        livingRoomToggle.setOnAction(event -> handleSensorToggle(livingRoomToggle, "Living Room Light"));
        bedroomToggle.setOnAction(event -> handleSensorToggle(bedroomToggle, "Bedroom Light"));

        // Attach action to the "Add Sensor" button
        addSensorButton.setOnAction(event -> handleAddSensor());
    }

    // Updates the labels for total and active sensors
    private void updateSummaryLabels() {
        totalSensorsLabel.setText(String.valueOf(totalSensors));
        activeSensorsLabel.setText(String.valueOf(activeSensors));
    }

    // Populates the BarChart with example lighting activity data
    private void populateActivityChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Lighting Events");

        // Example data points
        series.getData().add(new XYChart.Data<>("12 AM", 2));
        series.getData().add(new XYChart.Data<>("1 AM", 1));
        series.getData().add(new XYChart.Data<>("2 AM", 3));
        series.getData().add(new XYChart.Data<>("3 AM", 4));
        series.getData().add(new XYChart.Data<>("4 AM", 2));
        series.getData().add(new XYChart.Data<>("5 AM", 5));

        activityChart.getData().clear();
        activityChart.getData().add(series);
    }

    // Handles the toggling of a sensor
    private void handleSensorToggle(ToggleButton toggleButton, String sensorName) {
        String status = toggleButton.isSelected() ? "Active" : "Inactive";
        System.out.println(sensorName + " status: " + status);

        // Update active sensor count
        if (toggleButton.isSelected()) {
            activeSensors++;
        } else {
            activeSensors--;
        }
        updateSummaryLabels();
    }

    // Handles the "Add Sensor" button click
    private void handleAddSensor() {
        System.out.println("Add Sensor button clicked!");
        // Logic to add a new sensor (e.g., open a dialog or update backend)
    }
}
