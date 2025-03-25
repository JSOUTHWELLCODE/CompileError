package Algorithims;

import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class InsertionSort implements Algos {
    private double speed = 0.25;

    @Override
    public void SwapValues(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }




    @Override
    public ArrayList<Integer> SelectionSort(ArrayList<Integer> dataset) {
        return null;
    }

    @Override
    public void SwapAnimation(ArrayList<Rectangle> list, int i, int j, HBox HBOX1, Runnable onFinished) {
        Rectangle rectI = list.get(i);
        Rectangle rectJ = list.get(j);

        double rectIStartX = rectI.getX();
        double rectJStartX = rectJ.getX();

        TranslateTransition translateI = new TranslateTransition(Duration.seconds(this.speed), rectI);
        TranslateTransition translateJ = new TranslateTransition(Duration.seconds(this.speed), rectJ);

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


    public ArrayList<Integer> InsertionSort(ArrayList<Integer> dataset) {
        int length = dataset.size();
        for (int i = 1; i < length; i++) {
            int key = dataset.get(i);  // current index of I
            int j = i - 1;

            while (j >= 0 && dataset.get(j) > key) {
                dataset.set(j + 1, dataset.get(j));
                j--;
            }
            dataset.set(j + 1, key);
        }
        return dataset;
    }






    public void Insertionrect(ArrayList<Rectangle> list, HBox HBOX1) {
        long startTime = System.nanoTime();
        InsertionSortStep(list, HBOX1, 1, () -> {
            long endTime = System.nanoTime();
            long executionTime = (endTime - startTime) / 1000000;
            System.out.println("Insertion Sort takes " + executionTime + " ms to execute." + " " + "BIG O = O(n²)");
        });
    }

    private void InsertionSortStep(ArrayList<Rectangle> list, HBox HBOX1, int i, Runnable onFinished) {
        int length = list.size();

        if (i < length) {
            int j = i;
            if (j > 0 && list.get(j).getHeight() < list.get(j - 1).getHeight()) {
                int finalJ = j;
                SwapAnimation(list, j, j - 1, HBOX1, () -> {
                    PauseTransition pause = new PauseTransition(Duration.millis(5));
                    pause.setOnFinished(event -> InsertionSortStep(list, HBOX1, finalJ - 1, onFinished));
                    pause.play();
                });
            } else {
                PauseTransition pause = new PauseTransition(Duration.millis(5));
                pause.setOnFinished(event -> InsertionSortStep(list, HBOX1, i + 1, onFinished));
                pause.play();
            }
        } else {
            if (onFinished != null) {
                onFinished.run();
            }
        }
    }

    public void SetSpeed(double inputspeed ){

        double constant = 0.1;
        this.speed = constant / inputspeed;

    }




}
