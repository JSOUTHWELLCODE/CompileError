package Algorithims;
import JavaFXpackage.DataSet;


import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        DataSet data = new DataSet();


        data.generateData(20);

        data.Printdata();


        //Bubblesort bubble = new Bubblesort();

       // ArrayList<Integer> sorted = bubble.Bubble(data.getData());

       // System.out.println(sorted);


        selectionSort selectionSort = new selectionSort();
        MergeSort mergeSort = new MergeSort();


        ArrayList<Integer> sorted = mergeSort.MergeSort(data.getData());

        System.out.println(sorted);



    }
}