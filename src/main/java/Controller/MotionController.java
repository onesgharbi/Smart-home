package Controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class MotionController {

    @FXML
    private Label totalSensorsLabel; // Label displaying total sensors
    @FXML
    private Label activeSensorsLabel; // Label displaying active sensors
    @FXML
    private BarChart<String, Number> activityChart; // BarChart for motion activity
    @FXML
    private ToggleButton livingRoomToggle; // Toggle button for the Living Room sensor
    @FXML
    private ToggleButton outdoorToggle; // Toggle button for the Outdoor sensor
    @FXML
    private Button addSensorButton; // Button to add a new sensor

    // Sample data for demonstration
    private int totalSensors = 3;
    private int activeSensors = 2;

    @FXML
    public void initialize() {
        // Initialize summary labels
        updateSummaryLabels();

        // Populate the activity chart with sample data
        populateActivityChart();

        // Attach actions to toggle buttons
        livingRoomToggle.setOnAction(event -> handleSensorToggle(livingRoomToggle, "Living Room Sensor"));
        outdoorToggle.setOnAction(event -> handleSensorToggle(outdoorToggle, "Outdoor Sensor"));

        // Attach action to the "Add Sensor" button
        addSensorButton.setOnAction(event -> handleAddSensor());
    }

    // Updates the labels for total and active sensors
    private void updateSummaryLabels() {
        totalSensorsLabel.setText(String.valueOf(totalSensors));
        activeSensorsLabel.setText(String.valueOf(activeSensors));
    }

    // Populates the BarChart with example motion activity data
    private void populateActivityChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Motion Events");

        // Example data points
        series.getData().add(new XYChart.Data<>("12 AM", 1));
        series.getData().add(new XYChart.Data<>("1 AM", 3));
        series.getData().add(new XYChart.Data<>("2 AM", 2));
        series.getData().add(new XYChart.Data<>("3 AM", 4));
        series.getData().add(new XYChart.Data<>("4 AM", 3));
        series.getData().add(new XYChart.Data<>("5 AM", 2));

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
        // Logic to add a new sensor (e.g., open a dialog or interact with backend)
    }
}
