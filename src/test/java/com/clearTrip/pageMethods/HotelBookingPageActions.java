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
	static SeleniumWait seleniumWait = null;
	static DriverFactory driverFactory = null;
	
	static {
		driverFactory = new DriverFactory();
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driverFactory.setDriverPath();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		seleniumWait = new SeleniumWait(driver);
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
	private WebElement uiDatePicker;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;
	
	public void launchApplication() {
		PageFactory.initElements(driver, this);
		
		windowMaximise();
		launchUrl("https://www.cleartrip.com/");
        logMessage("Navigated to ClearTrip website");
	}
	
	public void clickOnHotelsLink() {
		hotelLink.click();
		logMessage("Clicked on 'Hotels' link");
	}
	
	public void enterLocalityDetails() {
		localityTextBox.sendKeys("Indiranagar, Bangalore");
		logMessage("Entered 'Indiranagar, Bangalore' in textbox");
	}
	
	public void selectLocalityFromAutoComplete() {
		seleniumWait.waitUntilVisibilityOfElement(uiSelectedLocality);
		uiSelectedLocality.click();
		logMessage("Selected 'Indiranagar, Bangalore' from autoComplete list");
	}
	
	public void selectCheckInDate() {
		uiSelectedDatePicker.click();
		logMessage("Selected date for 'Check-in' field");
	}
	
	public void selectCheckOutDate() {
		seleniumWait.waitUntilVisibilityOfElement(uiDatePicker);
		uiSelectedDatePicker.click();
		logMessage("Selected date for 'Check-out' field");
	}
	
	public void selectNoOfTravellers() {
		new Select(travellerSelection).selectByVisibleText("1 room, 1 adult");
		logMessage("Selected '1 room, 1 adult' option");
	}
	
	public void clickOnSearchHotelsButton() {
		seleniumWait.waitUntilElementToBeClickable(searchButton);
		searchButton.click();
		logMessage("Clicked on 'Search hotels' button");

		quitBrowser();
	}

}
