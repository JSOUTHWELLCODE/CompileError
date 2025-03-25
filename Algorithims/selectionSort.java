package Algorithims;

import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class selectionSort implements Algos {
    private double speed = 0.25;


    @Override

    public void SwapValues(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }



    public ArrayList<Integer> SelectionSort(ArrayList<Integer> dataset) {
        int length = dataset.size();

        for (int i = 0; i < length; i++) {
            int min = dataset.get(i);
            int indexOfmin = i;
            for (int j = i + 1; j < length; j++) {
                if (dataset.get(j) < min) {
                    min = dataset.get(j);
                    indexOfmin = j;
                }
            }
            SwapValues(dataset, i, indexOfmin);
        }
        return dataset;

    }


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



    private void SelectionSortStep(ArrayList<Rectangle> list, HBox HBOX1, int i, int j, int minIndex, Runnable onFinished) {
        int length = list.size();

        if (i < length - 1) {
            if (j < length) {
                if (list.get(j).getHeight() < list.get(minIndex).getHeight()) {
                    minIndex = j;
                }
                PauseTransition pause = new PauseTransition(Duration.millis(5));
                int finalMinIndex = minIndex;
                pause.setOnFinished(event -> SelectionSortStep(list, HBOX1, i, j + 1, finalMinIndex, onFinished)); // Pass onFinished
                pause.play();
            } else {
                if (minIndex != i) {
                    SwapAnimation(list, i, minIndex, HBOX1, () -> {
                        PauseTransition pause = new PauseTransition(Duration.millis(5));
                        pause.setOnFinished(event -> SelectionSortStep(list, HBOX1, i + 1, i + 2, i + 1, onFinished)); // Pass onFinished
                        pause.play();
                    });
                } else {
                    PauseTransition pause = new PauseTransition(Duration.millis(10));
                    pause.setOnFinished(event -> SelectionSortStep(list, HBOX1, i + 1, i + 2, i + 1, onFinished)); // Pass onFinished
                    pause.play();
                }
            }
        } else {
            if (onFinished != null) {
                onFinished.run(); // Call onFinished when sorting is complete
            }
        }
    }


    public void Selectionrect(ArrayList<Rectangle> list, HBox HBOX1) {
        long startTime = System.nanoTime();
        SelectionSortStep(list, HBOX1, 0, 1, 0, () -> { // Pass Runnable
            long endTime = System.nanoTime();
            long executionTime = (endTime - startTime) / 1000000;
            System.out.println("Selection Sort takes " + executionTime + " ms to execute." + " " + "Big O =  O(n²)");
        });
    }

    public void SetSpeed(double inputspeed ){

        double constant = 0.1;
        this.speed = constant / inputspeed;

    }






}






