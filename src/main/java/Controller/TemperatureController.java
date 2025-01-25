package Controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class TemperatureController {

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private ToggleButton thermostatToggle;

    @FXML
    private ToggleButton heaterToggle;

    @FXML
    private ToggleButton coolerToggle;

    @FXML
    private Button addDeviceButton;

    @FXML
    private AnchorPane mainPane;

    // Initialize the controller
    @FXML
    public void initialize() {
        // Setup the initial data for the temperature history
        XYChart.Series<String, Number> temperatureHistory = new XYChart.Series<>();
        temperatureHistory.setName("Room Temperature");

        temperatureHistory.getData().add(new XYChart.Data<>("Day 1", 20));
        temperatureHistory.getData().add(new XYChart.Data<>("Day 2", 22));
        temperatureHistory.getData().add(new XYChart.Data<>("Day 3", 21));
        temperatureHistory.getData().add(new XYChart.Data<>("Day 4", 23));
        temperatureHistory.getData().add(new XYChart.Data<>("Day 5", 24));
        temperatureHistory.getData().add(new XYChart.Data<>("Day 6", 22));
        temperatureHistory.getData().add(new XYChart.Data<>("Day 7", 23));

        lineChart.getData().add(temperatureHistory);

        // Initialize the state of toggles (could be loaded from some settings)
        thermostatToggle.setSelected(true);  // Assuming thermostat is on
        heaterToggle.setSelected(false);     // Heater is off
        coolerToggle.setSelected(false);     // Cooler is off
    }

    // Action when "Add Device" button is clicked
    @FXML
    private void onAddDeviceClicked() {
        // Handle adding a new device (e.g., open a dialog or go to a new screen)
        System.out.println("Add Device button clicked.");
    }

    // Action when thermostat toggle button is clicked
    @FXML
    private void onThermostatToggle() {
        if (thermostatToggle.isSelected()) {
            System.out.println("Thermostat ON");
            // Additional logic to handle thermostat activation
        } else {
            System.out.println("Thermostat OFF");
            // Additional logic to handle thermostat deactivation
        }
    }

    // Action when heater toggle button is clicked
    @FXML
    private void onHeaterToggle() {
        if (heaterToggle.isSelected()) {
            System.out.println("Heater ON");
            // Additional logic to handle heater activation
        } else {
            System.out.println("Heater OFF");
            // Additional logic to handle heater deactivation
        }
    }

    // Action when cooler toggle button is clicked
    @FXML
    private void onCoolerToggle() {
        if (coolerToggle.isSelected()) {
            System.out.println("Cooler ON");
            // Additional logic to handle cooler activation
        } else {
            System.out.println("Cooler OFF");
            // Additional logic to handle cooler deactivation
        }
    }
}
