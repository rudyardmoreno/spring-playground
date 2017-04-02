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
    public static double getPIValue(){
        return 3.141592653589793;
    }

    public static String getPI(){
        return String.format("%.15f",getPIValue());
    }

    // Spring Math: Calculate with Querystrings
    public static String getCalculate(Calculate calculate){
        return calculate.getCalculate();
    }

    // Spring Math: Sum with Querystrings
    public static String getSum(MultiValueMap<String, String> querystring){
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

    // Spring Math: Calculate volume
    public static String getVolume(Volume volume){
        return volume.getVolume();
    }

    // Spring Math: Calculate area
    public static String getArea(Area area){
        return area.getArea();
    }
}
