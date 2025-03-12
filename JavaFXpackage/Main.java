package JavaFXpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    public Main() {




    }

    public void start(Stage stage) {
        try {
            Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/JavaFXpackage/sample.fxml"));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("/JavaFXpackage/application.css").toExternalForm();
            scene.getStylesheets().add(css);

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
