package com.example;

/**
 * Created by trainer18 on 3/30/17.
 */

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/math")
public class mathController {
    @GetMapping("/pi")
    public String helloWorld() {
        return "3.141592653589793";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "operation", defaultValue = "add") String operation,
                            @RequestParam int x,
                            @RequestParam int y) {
        int result=0;
        String txtResult;
        String operationSign="";
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
        return txtResult;
    }

    @PostMapping("/sum")
    public String sum(@RequestParam MultiValueMap<String, String> querystring) {
        //Get all map keys
        Set<String> keys = querystring.keySet();
        int result=0;
        String txtResult="";
        int count=0;

        for (String key : keys) {
            System.out.println("Key = " + key);
            System.out.println("Values = " + querystring.get(key) + "n");
            for (String n : querystring.get(key)) {
                try {
                    result += Integer.parseInt(n);
                    if (count != 0) txtResult += " + ";
                    txtResult += n;
                    count += 1;
                } catch (Exception e) {
                    //Nothing
                }
            }
        }
        txtResult = String.format("%s = %d",txtResult,result);
        return  txtResult;
    }

}
