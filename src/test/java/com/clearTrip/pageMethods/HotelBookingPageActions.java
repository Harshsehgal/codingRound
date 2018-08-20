package com.clearTrip.pageMethods;

import com.clearTrip.getPageObjects.DriverFactory;
import com.clearTrip.getPageObjects.GetPage;
import com.clearTrip.utils.SeleniumWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPageActions extends GetPage {

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

	public HotelBookingPageActions() {
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
	
	public void shouldBeAbleToSearchForHotels() {
		PageFactory.initElements(driver, this);
				
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
