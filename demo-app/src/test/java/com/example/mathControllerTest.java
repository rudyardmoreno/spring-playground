package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Test Math Controller
 */

@RunWith(SpringRunner.class)
@WebMvcTest(mathController.class)

public class mathControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    //Test for Math Controller to get PI value
    public void testMathPI() throws Exception{
        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    //Test for Math Controller to calculate with default operation
    public void testCalculateNoOperation() throws Exception{
        this.mvc.perform(get("/math/calculate?x=30&y=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("30 + 5 = 35"));
    }

    @Test
    //Test for Math Controller to calculate with Add operation
    public void testCalculateAddOperation() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    //Test for Math Controller to calculate with Multiply operation
    public void testCalculateMultiplyOperation() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 6 = 24"));
    }

    @Test
    //Test for Math Controller to calculate with Subtract operation
    public void testCalculateSubtractOperation() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));
    }

    @Test
    //Test for Math Controller to calculate with Divide operation
    public void testCalculateDivideOperation() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=divide&x=30&y=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("30 / 5 = 6"));
    }

    @Test
    //Test for Math Controller to calculate with Divide operation when it is divided by zero value
    public void testCalculateDivideByZeroOperation() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=divide&x=30&y=0").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("30 / 0 = NA (Div by Zero)"));
    }

    @Test
    //Test for Math Controller to sum multiple values
    public void testSum() throws Exception{
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }
}
