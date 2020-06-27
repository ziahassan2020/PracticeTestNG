package com.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighter {
	
	public void getcolor(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  // Type casting polymorphism change the interface into driver
		js.executeScript("arguments[0].setAttribute('style','background:blue; border:2px solid red;');",element);
		
	}
	
	public void getcolor(WebDriver driver,WebElement element, String color) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  // Type casting polymorphism change the interface into driver
		js.executeScript("arguments[0].setAttribute('style','background:blue; border:4px solid "+color+";');",element);
		
	}

}
