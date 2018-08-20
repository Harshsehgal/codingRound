import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Reporter;
import org.testng.annotations.Test;

@SuppressWarnings("restriction")
public class HotelBookingTest {

    WebDriver driver = new ChromeDriver();
    
    // Explicit wait i.e., waiting for condition to occur
    WebDriverWait wait = new WebDriverWait(driver, 15);

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
    	
        setDriverPath();
        
        driver.manage().window().maximize();
        Reporter.log("Maximized Chrome browser instance", true);
        
        driver.get("https://www.cleartrip.com/");
        Reporter.log("Navigated to ClearTrip website", true);
        
        hotelLink.click();
        Reporter.log("Clicked on 'Hotels' link", true);
        
        localityTextBox.sendKeys("Indiranagar, Bangalore");
        Reporter.log("Entered 'Indiranagar, Bangalore' in textbox", true);
        
        wait.until(ExpectedConditions.visibilityOf(uiSelectedLocality));
        uiSelectedLocality.click();
        Reporter.log("Selected 'Indiranagar, Bangalore' from autoComplete list", true);
        
        uiSelectedDatePicker.click();
        Reporter.log("Selected date for 'Check-in' field", true);
        
		wait.until(ExpectedConditions.visibilityOf(uiDatePicket));
        uiSelectedDatePicker.click();
        Reporter.log("Selected date for 'Check-out' field", true);
        
        new Select(travellerSelection).selectByVisibleText("1 room, 1 adult");
        Reporter.log("Selected '1 room, 1 adult' option", true);
        
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        Reporter.log("Clicked on 'Search hotels' button", true);
        
        driver.quit();
        Reporter.log("Quit the Chrome browser instance", true);
    }
    
    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
