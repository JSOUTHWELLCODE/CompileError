package Algorithims;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class MergeSort implements Algos {
    private double speed = 0.25;



    @Override
    public void SwapValues(ArrayList<Integer> list, int i, int j) {

    }


    public void MergeSortRect(ArrayList<Rectangle> list, HBox HBOX1) {
        long startTime = System.nanoTime();
        mergeSortStep(list, HBOX1, 0, list.size() - 1, () -> {
            long endTime = System.nanoTime();
            long executionTime = (endTime - startTime) / 1000000;
            System.out.println("Merge Sort takes " + executionTime + " ms to execute." + " " + "Best Case: O(n log n)" + " Worst Case: O(n log n))" );
        });
    }

    private void mergeSortStep(ArrayList<Rectangle> list, HBox HBOX1, int low, int high, Runnable onFinished) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortStep(list, HBOX1, low, mid, () -> {
                mergeSortStep(list, HBOX1, mid + 1, high, () -> {
                    Merge(list, HBOX1, low, mid, high, onFinished);
                });
            });
        } else {
            if (onFinished != null) {
                onFinished.run();
            }
        }
    }

    private void Merge(ArrayList<Rectangle> list, HBox HBOX1, int low, int mid, int high, Runnable onFinished) {
        ArrayList<Rectangle> temp = new ArrayList<>();
        int i = low;
        int j = mid + 1;

        while (i <= mid && j <= high) {
            if (list.get(i).getHeight() <= list.get(j).getHeight()) {
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(list.get(i));
            i++;
        }

        while (j <= high) {
            temp.add(list.get(j));
            j++;
        }

        SequentialTransition mergeAnimation = new SequentialTransition();

        for (int k = 0; k < temp.size(); k++) {
            final int index = k;
            PauseTransition pause = new PauseTransition(Duration.millis(20));

            pause.setOnFinished(event -> {
                list.set(low + index, temp.get(index));
                SwapAnimation(list, low + index, low + index, HBOX1, null);
            });

            mergeAnimation.getChildren().add(pause);
        }
        mergeAnimation.setOnFinished(event -> {
            if (onFinished != null) {
                onFinished.run();
            }
        });
        mergeAnimation.play();
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

        SequentialTransition sequentialTransition = new SequentialTransition(translateI, translateJ);

        sequentialTransition.setOnFinished(event -> {
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
        if (i == j){
            translateI.setByX(0);
            translateJ.setByX(0);
            sequentialTransition.play();
        } else {
            sequentialTransition.play();
        }
    }

    public void SetSpeed(double inputspeed ){

        double constant = 0.1;
        this.speed = constant / inputspeed;

    }

}
























