package com.example.model;

/**
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Model - Area Class
 */

public class Area {
    //Properties
    private String type;
    private int width;
    private int height;
    private int radius;
    private boolean isWidthHasValue = false;
    private boolean isHeightHasValue = false;
    private boolean isRadiusHasValue = false;

    //Constants
    private static final String INVALID ="Invalid";

    //Getters
    public String getType() { return type; }
    public int getWidth() {return width; }
    public int getHeight() {return height;}
    public int getRadius() {return radius;}

    //Setters
    public void setType(String value){
        type=value;
    }

    public void setWidth(String value){
        try {
            if (value != null) {
                width=Integer.parseInt(value);
                isWidthHasValue=true;
            }
        } catch (Exception e) {
            width=0;
            isWidthHasValue=false;
        }
    }

    public void setHeight(String value){
        try {
            if (value != null) {
                height=Integer.parseInt(value);
                isHeightHasValue=true;
            }
        } catch (Exception e) {
            height=0;
            isHeightHasValue=false;
        }
    }

    public void setRadius(String value){
        try {
            if (value != null) {
                radius=Integer.parseInt(value);
                isRadiusHasValue=true;
            }
        } catch (Exception e) {
            radius=0;
            isRadiusHasValue=false;
        }
    }

    //Method to get area for a rectangle
    private String getAreaRectangle(){
        //variables
        int result=0;
        String txtResult;

        if (isHeightHasValue && isWidthHasValue && !isRadiusHasValue) {
            //Calculate area
            result = width * height;
            txtResult = String.format("Area of a %dx%d %s is %s", width, height, type, result);
        } else {
            txtResult=INVALID;
        }

        //Return text result
        return txtResult;
    }

    //Method to get area for a circle
    private String getAreaCircle(){
        //variables
        double result=0;
        String txtResult;

        if (isRadiusHasValue && !isHeightHasValue && !isWidthHasValue) {
            //Calculate area
            result = MathService.getPIValue() * Math.pow(radius,2);
            txtResult = String.format("Area of a %s with a radius of %d is %.5f", type, radius, result);
        } else {
            txtResult=INVALID;
        }

        //Return text result
        return txtResult;
    }

    //Method to get area
    public String getArea(){
        String txtResult;
        switch (type.toUpperCase()){
            case "RECTANGLE":
                txtResult=getAreaRectangle();
                break;
            case "CIRCLE":
                txtResult=getAreaCircle();
                break;
            default:
                txtResult=INVALID;
        }
        return txtResult;
    }

    //Constructor
    Area(){
        setType(INVALID);
        setWidth(null);
        setHeight(null);
        setRadius(null);
    }

}
