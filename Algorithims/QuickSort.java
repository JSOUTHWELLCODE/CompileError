package Algorithims;

import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class QuickSort implements Algos {

    @Override
    public void SwapValues(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
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

    @Override
    public void SwapAnimation(ArrayList<Rectangle> list, int i, int j, HBox HBOX1, Runnable onFinished) {

    }

    public ArrayList<Integer> QuickSort(ArrayList<Integer> dataset, int low, int high) {
        if (low < high) {
            int pivotIndex = Partition(dataset, low, high);
            QuickSort(dataset, low, pivotIndex - 1);
            QuickSort(dataset, pivotIndex + 1, high);
        }
        return dataset;
    }

    private int Partition(ArrayList<Integer> dataset, int low, int high) {
        int pivot = dataset.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (dataset.get(j) < pivot) {
                i++;
                SwapValues(dataset, i, j);
            }
        }
        SwapValues(dataset, i + 1, high);
        return i + 1;
    }
}
