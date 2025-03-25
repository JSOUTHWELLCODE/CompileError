package JavaFXpackage;


import Algorithims.Algos;
import Algorithims.*;


import javafx.animation.PauseTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;


public class Controller implements Initializable {
    private Map<String, String> imageMap;






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


    private String[] algos = {"Bubble Sort" ,"Insertion Sort", "Selection Sort", "Quick Sort", "Merge Sort"};

    @FXML
    private HBox HBOX1;

    @FXML
    private HBox HBOX2;


    @FXML
    private HBox HBOX3;

    @FXML
    private Slider Myslider;

    @FXML
    private Slider speedslider;


    @FXML
    private Button visualize;


    @FXML
    private ImageView Image1;

    @FXML
    private ImageView Image2;

    @FXML
    private ImageView Image3;





    Bubblesort bubble = new Bubblesort();
    selectionSort selection = new selectionSort();
    InsertionSort insert = new InsertionSort();
    QuickSort quicky = new QuickSort();
    MergeSort merge = new MergeSort();
    DataSet data = new DataSet();





    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        mychoicebox1.getItems().addAll(algos);
        mychoicebox2.getItems().addAll(algos);
        mychoicebox3.getItems().addAll(algos);

       // Set initial high value


        fillhboxes(HBOX1,HBOX2,HBOX3, data.getData());

         // change the data when the slider has been changed
        Myslider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
             int datasize = (int) Myslider.getValue();
                data.modifyData(datasize);
                //clear the current retangles
                HBOX1.getChildren().clear();
                HBOX2.getChildren().clear();
                HBOX3.getChildren().clear();

                fillhboxes(HBOX1,HBOX2,HBOX3, data.getData());

            }
        });

        speedslider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                double dataspeed = (double) speedslider.getValue();
                quicky.SetSpeed(dataspeed);
                merge.SetSpeed(dataspeed);
                bubble.SetSpeed(dataspeed);
                insert.SetSpeed(dataspeed);
                bubble.SetSpeed(dataspeed);
                selection.SetSpeed(dataspeed);



            }
        });



        imageMap = new HashMap<String, String>();
        imageMap.put("Bubble Sort", "/Images/Bubble sort algorithim.png");
        imageMap.put("Insertion Sort", "/Images/InsertionSort.png");
        imageMap.put("Selection Sort", "/Images/SelectionSort.png");
        imageMap.put("Quick Sort", "/Images/QuickSort.png");



        // Change listener for the choiboxes adds the image map when the user selects the appropriate choice
        ChangeListener<String> changeListener1 = (observableValue, oldVal, newVal) -> {
            if (newVal != null && imageMap.containsKey(newVal)) {
                Image image = new Image(getClass().getResourceAsStream(imageMap.get(newVal)));
                Image1.setImage(image);
            }
        };



        ChangeListener<String> changeListener2 = (observableValue, oldVal, newVal) -> {
            if (newVal != null && imageMap.containsKey(newVal)) {
                Image image = new Image(getClass().getResourceAsStream(imageMap.get(newVal)));
                Image2.setImage(image);
            }
        };


        ChangeListener<String> changeListener3 = (observableValue, oldVal, newVal) -> {
            if (newVal != null && imageMap.containsKey(newVal)) {
                Image image = new Image(getClass().getResourceAsStream(imageMap.get(newVal)));
                Image3.setImage(image);
            }
        };

        mychoicebox1.getSelectionModel().selectedItemProperty().addListener(changeListener1);
        mychoicebox2.getSelectionModel().selectedItemProperty().addListener(changeListener2);
        mychoicebox3.getSelectionModel().selectedItemProperty().addListener(changeListener3);



        visualize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String algorithm1 = mychoicebox1.getValue();
                String algorithm2 = mychoicebox2.getValue();
                String algorithm3 = mychoicebox3.getValue();

                // Disable UI need to add in a null checker
                visualize.setDisable(true);
                mychoicebox1.setDisable(true);
                mychoicebox2.setDisable(true);
                mychoicebox3.setDisable(true);
                Myslider.setDisable(true);
                speedslider.setDisable(true);
                // Disable sliders and other relevant UI elements

                if (algorithm1 != null) {
                    visualizeAlgorithm(algorithm1, HBOX1);
                }
                if (algorithm2 != null) {
                    visualizeAlgorithm(algorithm2, HBOX2);
                }
                if (algorithm3 != null) {
                    visualizeAlgorithm(algorithm3, HBOX3);
                }

                // Re-enable UI after a fixed delay
                PauseTransition enableUI = new PauseTransition(Duration.seconds(15)); // Adjust delay as needed
                enableUI.setOnFinished(event1 -> {
                    visualize.setDisable(false);
                    mychoicebox1.setDisable(false);
                    mychoicebox2.setDisable(false);
                    mychoicebox3.setDisable(false);
                    Myslider.setDisable(false);
                    speedslider.setDisable(false);
                    // Re-enable sliders and other UI elements
                });
                enableUI.play();
            }
        });

    }

    //fills all three hboxes
    public void fillhboxes(HBox HBOX1, HBox HBOX2, HBox HBOX3, ArrayList<Rectangle> data) {

        double xPosition1 = 0;
        double xPosition2 = 0;
        double xPosition3 = 0;

        int length = data.size();

        for (int i = 0; i < length; i++) {
            Rectangle rect = data.get(i); // Get the original rectangle

            // Create clones of the rectangle
            Rectangle rect1 = new Rectangle(rect.getWidth(), rect.getHeight(), rect.getFill());
            Rectangle rect2 = new Rectangle(rect.getWidth(), rect.getHeight(), rect.getFill());
            Rectangle rect3 = new Rectangle(rect.getWidth(), rect.getHeight(), rect.getFill());

            // Set initial position
            rect1.setX(xPosition1);
            rect1.setY(0);

            rect2.setX(xPosition2);
            rect2.setY(0);

            rect3.setX(xPosition3);
            rect3.setY(0);

            // Update X position
            xPosition1 += rect1.getWidth() * 5;
            xPosition2 += rect2.getWidth() * 5;
            xPosition3 += rect3.getWidth() * 5;


            HBOX1.getChildren().add(rect1);
            HBOX2.getChildren().add(rect2);
            HBOX3.getChildren().add(rect3);
        }

        HBOX1.setScaleY(-1);
        HBOX1.layout();
        HBOX1.setSpacing(4);

        HBOX2.setScaleY(-1);
        HBOX2.layout();
        HBOX2.setSpacing(4);

        HBOX3.setScaleY(-1);
        HBOX3.layout();
        HBOX3.setSpacing(4);
    }



    public void visualizeAlgorithm(String algorithm, HBox hbox) {
        ArrayList<Rectangle> list = new ArrayList<>(data.getArray());

        switch (algorithm) {
            case "Bubble Sort":
                bubble.BubbleRect(list, hbox);
                break;
            case "Insertion Sort":
                insert.Insertionrect(list, hbox);
                break;
            case "Quick Sort":
                quicky.QuickSortRect(list, hbox);
                break;
            case "Merge Sort":
                merge.MergeSortRect(list, hbox);
                break;
            case "Selection Sort":
                selection.Selectionrect(list, hbox);
                break;
            default:
                System.out.println("Unknown algorithm.");
        }
    }







}
