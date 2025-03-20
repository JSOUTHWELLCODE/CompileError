package Algorithims;

import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class MergeSort implements Algos {


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

    @Override
    public void SwapAnimation(ArrayList<Rectangle> list, int i, int j, HBox HBOX1, Runnable onFinished) {

    }


    public static void merge(ArrayList<Integer> inputarraylist, ArrayList<Integer> lefthalf, ArrayList<Integer> righthalf) {
        int leftsize = lefthalf.size();
        int rightsize = righthalf.size();

        int i = 0, j = 0, k = 0;

        // Merge the two halves while both have elements
        while (i < leftsize && j < rightsize) {
            if (lefthalf.get(i) <= righthalf.get(j)) {
                inputarraylist.set(k, lefthalf.get(i));
                i++;
            } else {
                inputarraylist.set(k, righthalf.get(j));
                j++;
            }
            k++;
        }

        // Copy any remaining elements from lefthalf (if any)
        while (i < leftsize) {
            inputarraylist.set(k, lefthalf.get(i));
            i++;
            k++;
        }

        // Copy any remaining elements from righthalf (if any)
        while (j < rightsize) {
            inputarraylist.set(k, righthalf.get(j));
            j++;
            k++;
        }
    }
    public ArrayList<Integer> MergeSort(ArrayList<Integer> dataset) {
        int inputLength = dataset.size();
        // If the dataset has 1 or fewer elements, it's already sorted
        if (inputLength < 2) {
            return dataset;
        }

        // Split the dataset into two halves
        int midindex = inputLength / 2;

        //creates two arrays
        ArrayList<Integer> lefthalf = new ArrayList<>(midindex);
        ArrayList<Integer> righthalf = new ArrayList<>(inputLength - midindex);

        // Fill lefthalf
        for (int i = 0; i < midindex; i++) {
            lefthalf.add(dataset.get(i));
        }

        // Fill righthalf
        for (int i = midindex; i < inputLength; i++) {
            righthalf.add(dataset.get(i));
        }

        // Recursively sort both halves
        MergeSort(lefthalf);
        MergeSort(righthalf);

        // Merge the sorted halves back into the dataset
        merge(dataset, lefthalf, righthalf);

        return dataset;
    }


}