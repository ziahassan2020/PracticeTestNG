package com.sarower.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.generic.code.BaseLogin;
//import AutomationPractice;

public class CrossBrowserTesting {
	
	String BrowserName;
	WebDriver driver;
	
	@Test
	@Parameters("Browser")
	public void setupBrowser(String BrowserName) throws Throwable {
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			System.out.println(BrowserName);
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(BrowserName.equalsIgnoreCase("firefox")) {
			System.out.println(BrowserName);
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		BaseLogin.getLogin(driver);
	}

}
