package JavaFXpackage;

import java.util.ArrayList;

public class DataSet {

    private ArrayList<Integer> data = new ArrayList<Integer>();


    public DataSet() {
        this.data = new ArrayList<Integer>();

    }



    //getters

    public ArrayList<Integer> getData(){
        return this.data;

    }


    // setters
    public void generateData(int value) {
        for (int i = 0; i < value; i++) {
            int randomNum = (int) (Math.random() * 10);
            data.add(randomNum);

        }
    }

    public void Printdata(){
        for(int iterator : this.data){
            System.out.println(iterator);
        }



    }


    public ArrayList<Integer> getArray() {
        return this.data;
    }

    public int getarraySize() {
        return this.data.size();
    }
}




