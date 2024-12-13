package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    public void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        String role = validateUser(username, password);

        if ("Homeowner".equals(role)) {
            loadDashboard("/views/homeowner_dashboard.fxml");
        } else if ("Security Guard".equals(role)) {
            loadDashboard("/views/security_guard_dashboard.fxml");
        } else if ("Technician".equals(role)) {
            loadDashboard("/views/technician_dashboard.fxml");
        } else {
            System.out.println("Invalid credentials");
        }
    }

    private String validateUser(String username, String password) {
        if ("homeowner".equals(username) && "password".equals(password)) return "Homeowner";
        if ("guard".equals(username) && "password".equals(password)) return "Security Guard";
        if ("technician".equals(username) && "password".equals(password)) return "Technician";
        return null;
    }

    private void loadDashboard(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
