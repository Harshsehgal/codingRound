package com.clearTrip.pageMethods;

import com.clearTrip.getPageObjects.DriverFactory;
import com.clearTrip.getPageObjects.GetPage;
import com.clearTrip.utils.SeleniumWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightBookingPageActions extends GetPage {
	
	static WebDriver driver = null;
	static ChromeOptions options = null;
	static SeleniumWait sw = null;
	static DriverFactory df = null;
	
	static {
		df = new DriverFactory();
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		df.setDriverPath();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sw = new SeleniumWait(driver);
	}
	
	public FlightBookingPageActions() {
		super(driver);
	}
	
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
        
		List<WebElement> originOptions = elementsByXPath("//ul[@id='ui-id-1']//li");
        originOptions.get(0).click();
        logMessage("Selected entered city as Origin");
        
        elementById("ToTag").clear();
        logMessage("Cleared 'From' input field");
        
        elementById("ToTag").sendKeys("New Delhi");
        logMessage("Entered 'New Delhi' in 'To' input field");

        // Explicit wait for the auto complete options to appear for the Destination
        sw.waitUntilVisibilityOfElement(elementById("ui-id-2"));
        
        // Select the first item from the destination auto complete list
        List<WebElement> destinationOptions = elementsByXPath("//ul[@id='ui-id-2']//li");
        destinationOptions.get(0).click();
        logMessage("Selected entered city as Origin");
        
        elementByXPath("//a[contains(@class,'ui-state-active')]").click();
        logMessage("Selected date for 'Depart on' field");
        
        elementById("SearchBtn").click();
        logMessage("Clicked on 'Search flights' button");
        
        // Verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));
        logMessage("Verified search results are appearing for 'One way' journey");
        
        quitBrowser();
        logMessage("Quit the Chrome browser instance");
    }

}
