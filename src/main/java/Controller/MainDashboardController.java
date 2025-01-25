package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class MainDashboardController {

    @FXML
    private Label timeLabel;

    @FXML
    private Label helloLabel;

    @FXML
    private Button logOutButton;

    @FXML
    private ToggleButton temperatureToggle;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button devicesButton;

    @FXML
    private Button lightsButton;

    @FXML
    private Button motionButton;

    @FXML
    private Button humidityButton;

    @FXML
    private Button temperatureButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button supportButton;

    @FXML
    private Button quickLightsButton;

    @FXML
    private Button quickMotionButton;

    @FXML
    private Button quickHumidityButton;

    @FXML
    private Button quickDoorLockButton;

    @FXML
    private Button watchNowButton;

    @FXML
    private void handleLogOut(ActionEvent event) {
        System.out.println("Log Out button clicked.");
        // Add logic for logging out, like navigating to the login page.
    }

    @FXML
    private void handleTemperatureToggle(ActionEvent event) {
        if (temperatureToggle.isSelected()) {
            temperatureToggle.setText("Turn On");
            System.out.println("Temperature turned off.");
        } else {
            temperatureToggle.setText("Turn Off");
            System.out.println("Temperature turned on.");
        }
    }

    @FXML
    private void handleSidebarButton(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        System.out.println(sourceButton.getText() + " button clicked.");
        // Add logic to navigate or perform specific actions for each sidebar button.
    }

    @FXML
    private void handleQuickPanelButton(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        System.out.println("Quick Panel - " + sourceButton.getText() + " button clicked.");
        // Add logic for quick panel actions.
    }

    @FXML
    private void handleWatchNow(ActionEvent event) {
        System.out.println("Watch Now button clicked.");
        // Add logic to handle the Watch Now button.
    }

    @FXML
    public void initialize() {
        // Initialize the dashboard, e.g., setting default values or updating labels.
        timeLabel.setText("12:19 PM | Monday, 24th of October, 2024");
        helloLabel.setText("Hello, Iman");
        System.out.println("Dashboard initialized.");
    }
}
