package com.example.model;

import org.springframework.util.MultiValueMap;
import java.util.Set;

/**
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Model - MathService Class
 */

 public class MathService {

    // Spring Math: PI with GET
    public String getPI(){
        return "3.141592653589793";
    }

    // Spring Math: Calculate with Querystrings
    public String getCalculate(String operation, int x, int y){
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

    // Spring Math: Sum with Querystrings
    public String getSum(MultiValueMap<String, String> querystring){
        //variables
        int result=0;
        int count=0;
        String txtResult="";

        //Get all map keys
        Set<String> keys = querystring.keySet();

        //Loop for each key to get values array
        for (String key : keys) {
            System.out.println("Key = " + key);
            System.out.println("Values = " + querystring.get(key) + "n");
            //Loop for each value array to sum each value
            for (String n : querystring.get(key)) {
                //Verify is each value is a valid Integer and add each value to the total sum
                try {
                    result += Integer.parseInt(n);
                    if (count != 0) txtResult += " + ";
                    txtResult += n;
                    count += 1;
                } catch (Exception e) {
                    //Nothing - If it is not a valid Integer then ignore it.
                }
            }
        }
        //Format text result
        txtResult = String.format("%s = %d",txtResult,result);

        //Return text result
        return  txtResult;
    }
}
