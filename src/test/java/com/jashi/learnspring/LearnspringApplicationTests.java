package com.jashi.learnspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class LearnspringApplicationTests {

	@Autowired
	private MathsResource mathsResource;


	@Test
	void contextLoads() {
	}

	@Test
	void getTokenTest() {

		ResponseEntity response = mathsResource.getToken("vikaskumarsahu");
		Assertions.assertEquals("dWhhc3JhbXVrc2FraXYxNA==", response.getBody());
	}
}
