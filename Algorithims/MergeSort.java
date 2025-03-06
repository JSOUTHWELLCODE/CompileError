package Algorithims;

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


    public ArrayList<Integer> Merge(ArrayList<Integer> dataset) {
        int inputLength = dataset.size();
        if (inputLength < 2) {
            return null;
        }


        int midindex = inputLength / 2;
        ArrayList<Integer> lefthalf = new ArrayList<>(midindex);
        ArrayList<Integer> righthalf = new ArrayList<>(inputLength - midindex);


        for (int i = 0; i < midindex; i++) {
            lefthalf.add(dataset.get(i));

        }
        for (int i = midindex; i < inputLength; i++) {
            righthalf.add(dataset.get(i));


        }
        return null;

    }
}