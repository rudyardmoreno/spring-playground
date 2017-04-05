package com.example.model;

/**
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Model - Calculate Class
 */

public class Calculate {
    //Properties
    private String operation;
    private int x;
    private int y;

    //Getters
    public String getOperation(){
        return operation;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    //Setters
    public void setOperation(String operationValue){
        operation=operationValue;
    }
    public void setX(int xValue){
        x=xValue;
    }
    public void setY(int yValue) {
        y = yValue;
    }

    //Method to get calculation
    public String getCalculate(){
        //variables
        int result=0;
        String txtResult;
        String operationSign="";

        //Calculate and assign operation sign based on operation
        switch (operation) {
            case "add":
                result=x+y;
                operationSign="+";
                break;
            case "subtract":
                result=x-y;
                operationSign="-";
                break;
            case "multiply":
                result=x*y;
                operationSign="*";
                break;
            case "divide":
                if (y!=0) {
                    result=x/y;
                    operationSign="/";
                } else {
                    operationSign="DivByZero";
                }
                break;
            default:
                operationSign="?";
        }

        //Create text result based on operation sign assigned on calculation
        switch (operationSign) {
            case "DivByZero":
                txtResult=String.format("%d / %d = NA (Div by Zero)",x,y);
                break;
            case "?":
                txtResult=String.format("Ivalid operation (%s) for %d and %d",operation,x,y);
                break;
            default:
                txtResult=String.format("%d %s %d = %d",x,operationSign,y,result);
        }

        //Return text result
        return txtResult;
    }

    //Constructor
    Calculate(){
        setOperation("add");
        setX(0);
        setY(0);
    }

}
