package Algorithims;

import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public interface Algos {


    void SwapValues(ArrayList<Integer> list, int i, int j);



    ArrayList<Integer> SelectionSort(ArrayList<Integer> dataset);

    void SwapAnimation(ArrayList<Rectangle> list, int i, int j, HBox HBOX1, Runnable onFinished);

}
