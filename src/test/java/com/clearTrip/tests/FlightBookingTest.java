package com.clearTrip.tests;

import com.clearTrip.helperMethods.DriverFactory;
import com.clearTrip.helperMethods.GetPage;
import com.clearTrip.helperMethods.SeleniumWait;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest extends GetPage {
	
	static WebDriver driver = null;
	static SeleniumWait sw = null;
	static DriverFactory df = null;
	
	static {
		driver = new ChromeDriver();
		sw = new SeleniumWait(driver);
		df = new DriverFactory();
	}
	
	public FlightBookingTest() {
		super(driver);
	}

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        df.setDriverPath();
        
        windowMaximise();
        logMessage("Maximized Chrome browser instance");
        
        launchUrl("https://www.cleartrip.com/");
        logMessage("Navigated to ClearTrip website");
        
        elementById("OneWay").click();
        logMessage("Clicked on 'One way' radio button");

        elementById("FromTag").clear();
        logMessage("Cleared 'From' input field");
        
        elementById("FromTag").sendKeys("Bangalore");
        logMessage("Entered 'Bangalore' in 'From' input field");
        
        // Explicit wait for the auto complete options to appear for the Origin
        sw.waitUntilVisibilityOfElement(elementById("ui-id-1"));
        
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();
        logMessage("Selected entered city as Origin");
        
        elementById("ToTag").clear();
        logMessage("Cleared 'From' input field");
        
        elementById("ToTag").sendKeys("Delhi");
        logMessage("Entered 'Delhi' in 'To' input field");

        // Explicit wait for the auto complete options to appear for the Destination
        sw.waitUntilVisibilityOfElement(elementById("ui-id-2"));
        
        // Select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();
        logMessage("Selected entered city as Origin");
        
        elementByxPath("//a[contains(@class,'ui-state-active')]").click();
        logMessage("Selected date for 'Depart on' field");
        
        elementById("SearchBtn").click();
        logMessage("Clicked on 'Search flights' button");
        
        // Verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));
        logMessage("Verified search results are appearing for 'One way' journey");
        
        quitBrowser();
        logMessage("Quit the Chrome browser instance");
    }
    
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
