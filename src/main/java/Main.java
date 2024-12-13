package utils;// Change to your actual package

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SupportDashboard.fxml"));
            AnchorPane root = loader.load();  // Load the FXML layout
            Scene scene = new Scene(root, 980, 700); // Set the scene

            primaryStage.setTitle("Support Dashboard");
            primaryStage.setScene(scene);
            primaryStage.show(); // Show the stage
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
