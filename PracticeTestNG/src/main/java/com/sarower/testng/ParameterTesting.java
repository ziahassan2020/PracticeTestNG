package com.sarower.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTesting {
	
	String BrowserValue;
	
	@Test
	@Parameters("BrowserName")
	public void parameterTest(String BrowserValue) {
		System.out.println("value of BrowserName= "+BrowserValue);
	}

}
