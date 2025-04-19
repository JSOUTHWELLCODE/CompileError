package Algorithims;

import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Bubblesort implements Algos {
    private double speed = 0.25;


    public void BubbleRect(ArrayList<Rectangle> list, HBox HBOX1) {
        long startTime = System.nanoTime();
        BubbleSortStep(list, HBOX1, list.size() - 1, 0, () -> {
            long endTime = System.nanoTime();
            long executionTime = (endTime - startTime) / 1000000;
            System.out.println("Bubble Sort takes " + executionTime + " ms to execute." + "BIG O = O(n²)");
        });
    }

    private void BubbleSortStep(ArrayList<Rectangle> list, HBox HBOX1, int n, int i, Runnable onFinished) {
        if (n > 0) {
            if (i < n) {
                if (list.get(i).getHeight() > list.get(i + 1).getHeight()) {
                    SwapAnimation(list, i, i + 1, HBOX1, () -> {
                        PauseTransition pause = new PauseTransition(Duration.millis(5));
                        pause.setOnFinished(event -> BubbleSortStep(list, HBOX1, n, i + 1, onFinished));
                        pause.play();
                    });
                } else {
                    PauseTransition pause = new PauseTransition(Duration.millis(5));
                    pause.setOnFinished(event -> BubbleSortStep(list, HBOX1, n, i + 1, onFinished));
                    pause.play();
                }
            } else {
                PauseTransition pause = new PauseTransition(Duration.millis(10));
                pause.setOnFinished(event -> BubbleSortStep(list, HBOX1, n - 1, 0, onFinished));
                pause.play();
            }
        } else {
            if (onFinished != null) {
                onFinished.run();
            }
        }
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

    @Override
    public void SwapValues(ArrayList<Integer> list, int i, int j) {

    }







    public void SetSpeed(double inputspeed ){

        double constant = 0.1;
        this.speed = constant / inputspeed;

    }



















}






