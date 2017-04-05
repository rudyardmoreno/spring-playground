package com.example.model;

/**
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Model - Volume Class
 */

public class Volume {
    //Properties
    private int length;
    private int width;
    private int height;

    //Getters
    public int getLength() { return length; }
    public int getWidth() {return width; }
    public int getHeight() {return height;}

    //Setters
    public void setLength(int value){
        length=value;
    }
    public void setWidth(int value){
        width=value;
    }
    public void setHeight(int value){
        height=value;
    }

    //Method to get volume
    public String getVolume(){
        //variables
        int result=0;
        String txtResult;

        //Calculate volume
        result=length*width*height;
        txtResult=String.format("The volume of a %dx%dx%d rectangle is %d",length,width,height,result);

        //Return text result
        return txtResult;
    }

    //Constructor
    Volume(){
        setLength(0);
        setWidth(0);
        setHeight(0);
    }

}
