package com.example.tests;

import com.example.service.ZenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@WebMvcTest(ZenService.class)
public class ZenServiceTests {

	@Test
	public void getRequestWorks() {
		ZenService service = new ZenService();

		// #1 - mock the correct instance
		MockRestServiceServer mockServer = MockRestServiceServer.createServer(service.getRestTemplate());

		mockServer
				.expect(requestTo("https://api.github.com/zen"))                // <-- #2
				.andExpect(method(HttpMethod.GET))                              // <-- #3
				.andRespond(withSuccess("FooBar", MediaType.APPLICATION_JSON)); // <-- #4

		assertThat(service.getMessage(), equalTo("FooBar"));                    // <-- #5
		mockServer.verify();                                                    // <-- #6
	}

}