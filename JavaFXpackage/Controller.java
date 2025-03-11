package JavaFXpackage;


import Algorithims.Algos;
import Algorithims.Bubblesort;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


public class Controller implements Initializable {



    @FXML
    private Label Algorithimlabel1;


    @FXML
    private ChoiceBox<String> mychoicebox1;


    @FXML
    private Label Algorithimlabel2;


    @FXML
    private ChoiceBox<String> mychoicebox2;


    @FXML
    private Label Algorithimlabel3;


    @FXML
    private ChoiceBox<String> mychoicebox3;


    private String[] algos = {"Merge Sort", "Insertion Sort",  "Bubble sort"};

    @FXML
    private HBox HBOX1;

    @FXML
    private Button visualize;









    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        mychoicebox1.getItems().addAll(algos);
        mychoicebox2.getItems().addAll(algos);
        mychoicebox3.getItems().addAll(algos);
        DataSet data = new DataSet();

        double xPosition = 0;
        // ArrayList<Rectangle> Dataset = data.getArray();

        // Creates a new ArrayList of rectangles
       // ArrayList<Rectangle> RectArray = new ArrayList<Rectangle>();

        // Add rectangles to the list

// Genrates the rectangles




                int length = data.getData().size();

                for (int i = 0; i < length; i++) {
                    //  int sizerect = array.get(i);
                    // Rectangle rect = new Rectangle(3, sizerect *2, Color.BLACK);

                    Rectangle rect =  data.getArray().get(i);
                    // Set initial position
                    rect.setX(xPosition);
                    rect.setY(0);

                    // Add to the rectangle array
                    //  RectArray.add(data.getArray().get(i));




                    // Update X position
                    xPosition += rect.getWidth() * 5;

                    // Add rectangle to HBox
                    HBOX1.getChildren().add(rect);
                }










        // Set alignment and spacing in the HBox
        HBOX1.setScaleY(-1); // This flips the HBox vertically
        HBOX1.layout();
        HBOX1.setSpacing(4);// Ensure the layout is updated





        mychoicebox1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldVal, String newVal) {
                if (Objects.equals(newVal, "Bubble sort")) {

                     visualize.setOnAction(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent e) {
                            Bubblesort bubble = new Bubblesort();
                            bubble.Bubblerect(data.getArray(), HBOX1);
                        }
                    });






                    // Call the sorting method
                }
            }
        });



    }






}
