package JavaFXpackage;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class DataSet {

    private final ArrayList<Rectangle> data = new ArrayList<Rectangle>();


    public DataSet() {
        generateData(30);

    }



    //getters

    public ArrayList<Rectangle> getData(){
        return this.data;

    }


    // setters
    public void generateData(int value) {
        for (int i = 0; i < value; i++) {
            int randomNum = (int) (Math.random() * 50) +1 ;
            Rectangle rect = new Rectangle(3, randomNum *2, Color.BLACK);

            data.add(rect);


        }
    }

    public void Printdata(){
        for(Rectangle iterator : this.data){
            System.out.println(iterator);
        }



    }


    public ArrayList<Rectangle> getArray() {
        return this.data;
    }

    public int getarraySize() {
        return this.data.size();
    }







}




