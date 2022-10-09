package com.example.demo;

import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	Business buss;

	@Test
	void contextLoads() {
	}

	@Test
	void testBusiness() {
		Assertions.assertEquals(buss.getLogo(), "ABC");
	}

}
