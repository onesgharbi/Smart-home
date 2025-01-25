package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox termsCheckBox;

    @FXML
    private Button signUpButton;

    @FXML
    private Button googleSignUpButton;

    @FXML
    private Button appleSignUpButton;

    @FXML
    private Hyperlink signInLink;

    @FXML
    private void handleSignUpAction() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        boolean termsAgreed = termsCheckBox.isSelected();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.println("Please fill in all fields.");
        } else if (!termsAgreed) {
            System.out.println("You must agree to the terms policy.");
        } else if (isValidEmail(email)) {
            System.out.println("Sign-Up successful! Welcome, " + name + "!");
        } else {
            System.out.println("Invalid email address.");
        }
    }

    @FXML
    private void handleGoogleSignUpAction() {
        System.out.println("Google Sign-Up clicked.");
    }

    @FXML
    private void handleAppleSignUpAction() {
        System.out.println("Apple Sign-Up clicked.");
    }

    @FXML
    private void handleSignInLinkAction() {
        System.out.println("Redirecting to Sign-In page...");
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".") && email.length() > 5;
    }
}
