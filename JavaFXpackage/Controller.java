package JavaFXpackage;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import java.net.URL;
import java.util.ArrayList;
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










    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        mychoicebox1.getItems().addAll(algos);
        mychoicebox2.getItems().addAll(algos);
        mychoicebox3.getItems().addAll(algos);
        DataSet data = new DataSet();

        mychoicebox1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            //looks for a change in the choicebox
            public void changed(ObservableValue<? extends String> observableValue, String oldVal, String newVal) {
                if (newVal != null){






                    //int size = data.getarraySize();

                   //starts at 0 and is incremented to add the other rectangels
                    double xPosition = 0;
                    ArrayList<Integer> array = data.getArray();

                    for(int i = 0; i < data.getarraySize(); i++){



                        // Nneed another for loop to go through the array and make the rectangles biger
                        int sizerect = array.get(i);
                        Rectangle rect = new Rectangle(2.5, sizerect , Color.BLACK);

                        rect.setX(xPosition);
                        rect.setY(0);
                        xPosition += 3;
//                        Rotate rotate = new Rotate();
//                        rotate.setAngle(180);
//                        rect.getTransforms().addAll(rotate);


                        HBOX1.getChildren().add(rect);


                    }
                    // ensures hbox updates
//                    HBOX1.setAlignment(Pos.CENTER);
                    HBOX1.setScaleY(-1);
                    HBOX1.layout();


                }
            }
        });



    }






}
