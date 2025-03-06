package Algorithims;

import java.util.ArrayList;

public class selectionSort implements Algos {


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


}






