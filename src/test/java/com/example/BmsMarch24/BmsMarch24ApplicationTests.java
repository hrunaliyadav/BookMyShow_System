package com.example.BmsMarch24;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BmsMarch24ApplicationTests {

	@Test
	void testAdd_OnePlusOne() {
		//A -> Arrange
		int a = 1;
		int b = 1;
		//A -> Act
		int ans = a+b;
		//A -> Assert
		//assert ans == 2;
		assertEquals(2,ans);
	}

}
