package Algorithims;

import java.util.ArrayList;

public class InsertionSort implements Algos {

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
        return dataset;
    }

    public ArrayList<Integer> InsertionSort(ArrayList<Integer> dataset) {
        int length = dataset.size();
        for (int i = 1; i < length; i++) {
            int key = dataset.get(i);
            int j = i - 1;

            while (j >= 0 && dataset.get(j) > key) {
                dataset.set(j + 1, dataset.get(j));
                j--;
            }
            dataset.set(j + 1, key);
        }
        return dataset;
    }
}
