package Algorithims;


import javafx.animation.PauseTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort implements Algos {
    private double speed = 0.25;




    public void QuickSortRect(ArrayList<Rectangle> list, HBox HBOX1) {
        long startTime = System.nanoTime();
        QuickSortStep(list, HBOX1, 0, list.size() - 1, () -> {
            long endTime = System.nanoTime();
            long executionTime = (endTime - startTime) / 1000000;
            System.out.println("Quick Sort takes " + executionTime + " ms to execute." + " " +"BIG O   best case = O(n log n)  worst case = O(n²)");
        });
    }

    private void QuickSortStep(ArrayList<Rectangle> list, HBox HBOX1, int low, int high, Runnable onFinished) { // Recursive method for QuickSort steps



        if (low < high) { // Checks if the partition needs sorting
            PartitionStep(list, HBOX1, low, high, () -> { // Calls PartitionStep with a Runnable for the next step
                int pivotIndex = Partition(list, low, high, HBOX1, null); // Partitions the list and gets the pivot index
                QuickSortStep(list, HBOX1, low, pivotIndex - 1, () -> { // Recursively sorts the left partition
                    QuickSortStep(list, HBOX1, pivotIndex + 1, high, onFinished); // Recursively sorts the right partition and calls the onFinished Runnable
                });
            });
        } else if (onFinished != null) { // If the partition is sorted, and there's an onFinished Runnable
            onFinished.run(); // Runs the onFinished Runnable
        }



    }

    private void PartitionStep(ArrayList<Rectangle> list, HBox HBOX1, int low, int high, Runnable onFinished) { // Method to call Partition and handle the next step
        Partition(list, low, high, HBOX1, onFinished); //Calls the partition method.
    }

    private int Partition(ArrayList<Rectangle> dataset, int low, int high, HBox HBOX1, Runnable onFinished) { // Method to partition the list
        Rectangle pivot = dataset.get(high); // Sets the last element as the pivot
        int i = low - 1; // Initializes the index for elements smaller than the pivot

        for (int j = low; j < high; j++) { // Iterates through the list
            if (dataset.get(j).getHeight() < pivot.getHeight()) { // Checks if the current element is smaller than the pivot
                i++; // Increments the index for smaller elements
                SwapValues(dataset, i, j, HBOX1, null); // Swaps the elements and calls SwapValues
            }
        }
        SwapValues(dataset, i + 1, high, HBOX1, onFinished); // Swaps the pivot with the element at i + 1

        return i + 1; // Returns the pivot index
    }

    private void SwapValues(ArrayList<Rectangle> dataset, int i, int j, HBox HBOX1, Runnable onFinished) { // Method to swap elements
        Rectangle temp = dataset.get(i); // Stores the element at index i in a temporary variable
        dataset.set(i, dataset.get(j)); // Replaces the element at index i with the element at index j
        dataset.set(j, temp); // Replaces the element at index j with the temporary element

        SwapAnimation(dataset, i, j, HBOX1, onFinished); // Calls SwapAnimation to visually swap the rectangles
    }

    @Override
    public void SwapValues(ArrayList<Integer> list, int i, int j) {

    }







    public void SwapAnimation(ArrayList<Rectangle> list, int i, int j, HBox HBOX1, Runnable onFinished) { // Method to animate the swap
        Rectangle rectI = list.get(i); // Gets the rectangle at index i
        Rectangle rectJ = list.get(j); // Gets the rectangle at index j

        double rectIStartX = rectI.getX(); // Gets the initial X-coordinate of rectangle i
        double rectJStartX = rectJ.getX(); // Gets the initial X-coordinate of rectangle j

        TranslateTransition translateI = new TranslateTransition(Duration.seconds(this.speed), rectI); // Creates a translation animation for rectangle i
        TranslateTransition translateJ = new TranslateTransition(Duration.seconds(this.speed), rectJ); // Creates a translation animation for rectangle j

        double moveIByX = rectJStartX - rectIStartX; // Calculates the distance rectangle i needs to move
        double moveJByX = rectIStartX - rectJStartX; // Calculates the distance rectangle j needs to move

        translateI.setByX(moveIByX); // Sets the X-translation for rectangle i
        translateJ.setByX(moveJByX); // Sets the X-translation for rectangle j

        SequentialTransition sequentialTransition = new SequentialTransition(translateI, translateJ); // Creates a sequential animation

        sequentialTransition.setOnFinished(event -> { // Sets the action to be performed after the animation
            HBOX1.getChildren().clear();              // Clears all rectangles from the HBox
            for (Rectangle rect : list) {             // Iterates through the list of rectangles
                Rectangle newRect = new Rectangle(3, rect.getHeight(), Color.BLACK); // Creates a new rectangle
                newRect.setX(rect.getX()); // Sets the X-coordinate of the new rectangle
                HBOX1.getChildren().add(newRect); // Adds the new rectangle to the HBox
            }
            HBOX1.layout(); // Forces the HBox to update its layout
            if (onFinished != null) { // Checks if there's an onFinished Runnable
                onFinished.run(); // Runs the onFinished Runnable
            }
        });

        sequentialTransition.play(); // Starts the animation
    }


    public void SetSpeed(double inputspeed ){

        double constant = 0.1;
        this.speed = constant / inputspeed;

    }




}