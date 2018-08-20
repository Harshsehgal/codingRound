package com.clearTrip.helperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetPage {
	
	WebDriver driver;
	
	public GetPage (WebDriver driver) {
		this.driver = driver;
	}
	
	protected WebElement elementById(String elem) {
		return driver.findElement(By.id(elem));
	}
	
}
