package JavaFXpackage;


import Algorithims.Algos;
import Algorithims.*;



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
    private HBox HBOX2;


    @FXML
    private HBox HBOX3;

    @FXML
    private Slider Myslider;


    @FXML
    private Button visualize;


    @FXML
    private ImageView Image1;



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        mychoicebox1.getItems().addAll(algos);
        mychoicebox2.getItems().addAll(algos);
        mychoicebox3.getItems().addAll(algos);
        DataSet data = new DataSet();

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













        mychoicebox1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldVal, String newVal) {
                if (Objects.equals(newVal, "Bubble sort")) {

                    Image bubblecode = new Image(getClass().getResourceAsStream("/Images/Bubble sort algorithim.png"));
                    Image1.setImage(bubblecode);




                     visualize.setOnAction(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent e) {
                            Bubblesort bubble = new Bubblesort();
                            selectionSort selection = new selectionSort();
                            InsertionSort insert = new InsertionSort();



                            // need to make a copy of each list
                            ArrayList<Rectangle> bubbleList1 = new ArrayList<>(data.getArray());
                            ArrayList<Rectangle> insertionlist = new ArrayList<>(data.getArray());
                            ArrayList<Rectangle> selectionList = new ArrayList<>(data.getArray());

                            // Sort the copies
                            bubble.Bubblerect(bubbleList1, HBOX1);
                            insert.Insertionrect(insertionlist, HBOX2);
                            selection.Selectionrect(selectionList, HBOX3);



                        }
                    });






                    // Call the sorting method
                }
            }
        });



    }
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



}
