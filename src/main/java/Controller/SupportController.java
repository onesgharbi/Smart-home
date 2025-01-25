package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SupportController {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private VBox sidebar;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button devicesButton;

    @FXML
    private Button lightsButton;

    @FXML
    private Button motionButton;

    @FXML
    private Button supportButton;

    @FXML
    private Button faqButton;

    @FXML
    private Button supportArticlesButton;

    @FXML
    private Button liveChatButton;

    @FXML
    private HBox emailBox;

    @FXML
    private HBox phoneBox;

    // Initialize the controller
    @FXML
    public void initialize() {
        // You can add initial logic here if needed, for example, setting default states or loading data
        System.out.println("Support Dashboard Initialized");
    }

    // Action when "Dashboard" button is clicked
    @FXML
    private void onDashboardClicked() {
        System.out.println("Dashboard button clicked.");
        // Add your navigation or functionality logic here
    }

    // Action when "Devices" button is clicked
    @FXML
    private void onDevicesClicked() {
        System.out.println("Devices button clicked.");
        // Add your navigation or functionality logic here
    }

    // Action when "Lights" button is clicked
    @FXML
    private void onLightsClicked() {
        System.out.println("Lights button clicked.");
        // Add your navigation or functionality logic here
    }

    // Action when "Motion" button is clicked
    @FXML
    private void onMotionClicked() {
        System.out.println("Motion button clicked.");
        // Add your navigation or functionality logic here
    }

    // Action when "Support" button is clicked (already highlighted in the sidebar)
    @FXML
    private void onSupportClicked() {
        System.out.println("Support button clicked.");
        // Add your support-specific logic here
    }

    // Action when "FAQ" button is clicked
    @FXML
    private void onFaqClicked() {
        System.out.println("FAQ button clicked.");
        // Add your FAQ functionality or navigation logic here
    }

    // Action when "Support Articles" button is clicked
    @FXML
    private void onSupportArticlesClicked() {
        System.out.println("Support Articles button clicked.");
        // Add your support articles logic here
    }

    // Action when "Live Chat" button is clicked
    @FXML
    private void onLiveChatClicked() {
        System.out.println("Live Chat button clicked.");
        // Add your live chat logic here
    }
}

