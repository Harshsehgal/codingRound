package com.clearTrip.tests;

import com.clearTrip.helperMethods.DriverFactory;
import com.clearTrip.helperMethods.GetPage;
import com.clearTrip.helperMethods.SeleniumWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

public class HotelBookingTest extends GetPage {

	static WebDriver driver = null;
	static SeleniumWait sw = null;
	static DriverFactory df = null;
	
	static {
		driver = new ChromeDriver();
		sw = new SeleniumWait(driver);
		df = new DriverFactory();
	}

	public HotelBookingTest() {
		super(driver);
	}

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(className = "uiSelected")
	private WebElement uiSelectedLocality;

	@FindBy(xpath = "//a[contains(@class,'ui-state-active')]")
	private WebElement uiSelectedDatePicker;

	@FindBy(id = "ui-datepicker-div")
	private WebElement uiDatePicket;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@Test
	public void shouldBeAbleToSearchForHotels() {
		PageFactory.initElements(driver, this);
		
		df.setDriverPath();
		
		windowMaximise();
		logMessage("Maximized Chrome browser instance");

		driver.get("https://www.cleartrip.com/");
		logMessage("Navigated to ClearTrip website");

		hotelLink.click();
		logMessage("Clicked on 'Hotels' link");

		localityTextBox.sendKeys("Indiranagar, Bangalore");
		logMessage("Entered 'Indiranagar, Bangalore' in textbox");

		sw.waitUntilVisibilityOfElement(uiSelectedLocality);
		uiSelectedLocality.click();
		logMessage("Selected 'Indiranagar, Bangalore' from autoComplete list");

		uiSelectedDatePicker.click();
		logMessage("Selected date for 'Check-in' field");

		sw.waitUntilVisibilityOfElement(uiDatePicket);
		uiSelectedDatePicker.click();
		logMessage("Selected date for 'Check-out' field");

		new Select(travellerSelection).selectByVisibleText("1 room, 1 adult");
		logMessage("Selected '1 room, 1 adult' option");

		sw.waitUntilElementToBeClickable(searchButton);
		searchButton.click();
		logMessage("Clicked on 'Search hotels' button");

		driver.quit();
		logMessage("Quit the Chrome browser instance");
	}

}
