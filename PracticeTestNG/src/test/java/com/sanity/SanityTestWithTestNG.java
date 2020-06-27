package com.sanity;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.generic.code.BaseLogin;
import com.generic.code.CartFunction;
import com.generic.code.DressSelection;
import com.generic.code.Payment;
import com.report.ExtentTestManager;

public class SanityTestWithTestNG {
	
	WebDriver driver;
	ExtentTest test;
	
	@BeforeTest
	public void setup() throws Throwable {
		
		test = ExtentTestManager.startTest("Regression_tc1"); 
		test.assignCategory("Regression Test");
		test.createNode("setup");
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		driver = new ChromeDriver();

		driver = BaseLogin.getLogin(driver);
		
	}
	
	@Test
	public void getDressMethod() throws Throwable {
		DressSelection.getDress(driver);
	}
	@Test(dependsOnMethods="getDressMethod")
	public void cartMethod() {
		CartFunction.addToCard(driver);
	}
	
	@Test(dependsOnMethods="cartMethod")
	public void getPaymentMethod() throws Throwable {
		Payment.getPayment(driver);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		ExtentTestManager.endTest();
	}
	
	
	

}
