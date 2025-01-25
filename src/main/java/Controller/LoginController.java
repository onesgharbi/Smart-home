package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox rememberCheckBox;

    @FXML
    private Button loginButton;

    @FXML
    private Button googleSignInButton;

    @FXML
    private Button appleSignInButton;

    @FXML
    private Hyperlink signUpLink;

    @FXML
    private Label feedbackLabel; // Optional: Add a label for displaying feedback to the user

    // Method called when the login button is clicked
    @FXML
    private void handleLoginAction() {
        String email = emailField.getText();
        String password = passwordField.getText();
        boolean remember = rememberCheckBox.isSelected();

        if (email.isEmpty() || password.isEmpty()) {
            showFeedback("Please fill in all fields.");
            return;
        }

        if (validateCredentials(email, password)) {
            showFeedback("Login successful!");
            // Redirect to another page or dashboard
        } else {
            showFeedback("Invalid email or password.");
        }
    }

    // Method called when the Google Sign-In button is clicked
    @FXML
    private void handleGoogleSignInAction() {
        // Implement Google Sign-In logic here
        showFeedback("Google Sign-In clicked.");
    }

    // Method called when the Apple Sign-In button is clicked
    @FXML
    private void handleAppleSignInAction() {
        // Implement Apple Sign-In logic here
        showFeedback("Apple Sign-In clicked.");
    }

    // Method called when the Sign-Up link is clicked
    @FXML
    private void handleSignUpLinkAction() {
        // Redirect to the Sign-Up page
        showFeedback("Redirecting to Sign-Up page...");
    }

    // Optional: Utility method to validate email and password
    private boolean validateCredentials(String email, String password) {
        // Add your email and password validation logic here
        // This is just a placeholder; replace with actual validation logic
        return email.equals("user@example.com") && password.equals("password123");
    }

    // Optional: Display feedback to the user
    private void showFeedback(String message) {
        if (feedbackLabel != null) {
            feedbackLabel.setText(message);
        }
    }
}
