package com.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DemoApplicationTests {

	private Calculator c =new Calculator();

	@Test
	@Disabled//it disabled the test case
	void contextLoads() {
	}

	@Test
	void testSum(){

		int expectedResult = 7;

		int actualResult = c.doSum(1,2,4);

		assertThat(actualResult).isEqualTo(expectedResult);

	}

	@Test
	void testProduct(){
		int expectedResult = 6;

		int actualResult = c.doProduct(2,3);

		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void testcompareTwoNumbers(){
		Boolean actualResult=c.compareTwoNums(3,3);
		assertThat(actualResult).isTrue();
	}

}
