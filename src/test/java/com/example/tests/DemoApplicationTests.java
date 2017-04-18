package com.example.tests;

import com.example.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoApplication.class)
@AutoConfigureMockMvc(secure=false)
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}