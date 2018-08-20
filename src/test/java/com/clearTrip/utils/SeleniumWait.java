package com.clearTrip.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clearTrip.helperMethods.GetPage;

public class SeleniumWait extends GetPage{
	
	public WebDriverWait wait = new WebDriverWait(driver, 15);
	
	public SeleniumWait(WebDriver driver) {
		super(driver);
	}
	
	public void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	public void waitUntilVisibilityOfElement(WebElement elem) {
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
	
	public void waitUntilElementToBeClickable(WebElement elem) {
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
	
}
