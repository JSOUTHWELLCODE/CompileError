package JavaFXpackage;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;




public class VisualizationController { // Replace with your actual class name

    private BooleanProperty animationRunning = new SimpleBooleanProperty(false);
    private List<Button> buttonsToDisable;
    private List<Slider> slidersToDisable;
    private List<ChoiceBox<String>> choiceBoxesToDisable;

    public void setUIElementsToToggle(List<Button> buttons, List<Slider> sliders, List<ChoiceBox<String>> choiceBoxes) {
        this.buttonsToDisable = buttons;
        this.slidersToDisable = sliders;
        this.choiceBoxesToDisable = choiceBoxes;
    }

    private void toggleUI(boolean disable) {
        if (buttonsToDisable != null) {
            for (Button button : buttonsToDisable) {
                button.setDisable(disable);
            }
        }
        if (slidersToDisable != null) {
            for (Slider slider : slidersToDisable) {
                slider.setDisable(disable);
            }
        }
        if (choiceBoxesToDisable != null) {
            for (ChoiceBox<String> choiceBox : choiceBoxesToDisable) {
                choiceBox.setDisable(disable);
            }
        }


    }


}