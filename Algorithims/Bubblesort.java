package Algorithims;



import java.util.ArrayList;

public class Bubblesort implements Algos {


    @Override
    public void SwapValues(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }


    public ArrayList<Integer> Bubble(ArrayList<Integer> Unsorted){
        for(int i = 1; i < Unsorted.size(); i++ ){
            for(int j= 0; j < Unsorted.size() -1; j++){
                if(Unsorted.get(j) > Unsorted.get(j+1)){
                    SwapValues(Unsorted,j,j+1);


                }


            }

        }
        return Unsorted;
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
}
