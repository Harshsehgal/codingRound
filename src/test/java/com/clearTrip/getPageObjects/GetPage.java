package com.clearTrip.getPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class GetPage {
	
	protected WebDriver driver;
	
	public GetPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void windowMaximise() {
		driver.manage().window().maximize();
		logMessage("Maximized Chrome browser instance");
	}
	
	public void launchApplication() {
		windowMaximise();
		driver.get("https://www.cleartrip.com/");
		logMessage("Navigated to ClearTrip website");
	}
	
	public WebElement elementById(String elem) {
		return driver.findElement(By.id(elem));
	}
	
	public WebElement elementByLinkText(String elem) {
		return driver.findElement(By.linkText(elem));
	}
	
	public WebElement elementByXPath(String xpathExp) {
		return driver.findElement(By.xpath(xpathExp));
	}
	
	public void switchToDefaultFrame() {
		driver.switchTo().defaultContent();
		logMessage("Switched back to default frame");
	}
	
	public void switchToFrameById(String elem) {
		driver.switchTo().frame(elem);
	}
	
	public List<WebElement> elementsByXPath(String xpathExp) {
		return driver.findElements(By.xpath(xpathExp));
	}
	
	public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
	public void logMessage (String message) {
		Reporter.log(message, true);
	}
	
	public void quitBrowser() {
		driver.quit();
		logMessage("Quit the Chrome browser instance");
	}
	
}
