package Algorithims;

import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Bubblesort implements Algos {

    public void Bubblerect(ArrayList<Rectangle> list, HBox HBOX1) {
        int n = list.size();
        bubbleSortStep(list, HBOX1, 0, 0);
    }

    private void bubbleSortStep(ArrayList<Rectangle> list, HBox HBOX1, int i, int j) {
        if (i < list.size() - 1) {
            if (j < list.size() - i - 1) {
                //If the hieght of the left rectangle is bigger than the right swap them
                if (list.get(j).getHeight() > list.get(j + 1).getHeight()) {
                    SwapAnimation(list, j, j + 1, HBOX1, () -> {
                        PauseTransition pause = new PauseTransition(Duration.millis(10));
                        pause.setOnFinished(event -> bubbleSortStep(list, HBOX1, i, j + 1));
                        pause.play();
                    });
                } else {
                    PauseTransition pause = new PauseTransition(Duration.millis(25));
                    pause.setOnFinished(event -> bubbleSortStep(list, HBOX1, i, j + 1));
                    pause.play();
                }
            } else {
                bubbleSortStep(list, HBOX1, i + 1, 0);
            }
        }
    }

    public void SwapAnimation(ArrayList<Rectangle> list, int i, int j, HBox HBOX1, Runnable onFinished) {
        Rectangle rectI = list.get(i);
        Rectangle rectJ = list.get(j);

        double rectIStartX = rectI.getX();
        double rectJStartX = rectJ.getX();

        TranslateTransition translateI = new TranslateTransition(Duration.seconds(0.05), rectI);
        TranslateTransition translateJ = new TranslateTransition(Duration.seconds(0.05), rectJ);

        double moveIByX = rectJStartX - rectIStartX;
        double moveJByX = rectIStartX - rectJStartX;

        translateI.setByX(moveIByX);
        translateJ.setByX(moveJByX);

        ParallelTransition parallelTransition = new ParallelTransition(translateI, translateJ);

        parallelTransition.setOnFinished(event -> {
            // Swap in the list
            Rectangle temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);

            // Clear and re-add rectangles
            HBOX1.getChildren().clear();
            for (Rectangle rect : list) {
                Rectangle newRect = new Rectangle(3, rect.getHeight(), Color.BLACK);
                newRect.setX(rect.getX());
                HBOX1.getChildren().add(newRect);
            }

            HBOX1.layout();
            if (onFinished != null) {
                onFinished.run();
            }
        });

        parallelTransition.play();
    }

    @Override
    public void SwapValues(ArrayList<Integer> list, int i, int j) {

    }

    @Override
    public int indexLowest() {
        return 0;
    }

    @Override
    public ArrayList<Integer> SubArrays(ArrayList<Integer> Dataset) {
        return null;
    }

    @Override
    public ArrayList<Integer> SubArrays() {
        return null;
    }

    @Override
    public ArrayList<Integer> Subdeck(ArrayList<Integer> Dataset) {
        return null;
    }

    @Override
    public ArrayList<Integer> SelectionSort(ArrayList<Integer> dataset) {
        return null;
    }
}






