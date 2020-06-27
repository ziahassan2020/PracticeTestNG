package com.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1 {
	
	@BeforeTest
	public void setup() {
		System.out.println("This is a Setup method");
	}
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	@Test(enabled=false)
	public void test2() {
		System.out.println("Test 1");
	}
	
	@AfterTest
	public void testClose() {
		System.out.println("Test Close");
	}

}
