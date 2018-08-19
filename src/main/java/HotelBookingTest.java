import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

@SuppressWarnings("restriction")
public class HotelBookingTest {

    WebDriver driver = new ChromeDriver();

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() {
    	PageFactory.initElements(driver, this);
    	
        setDriverPath();
        
        driver.manage().window().maximize();
        
        driver.get("https://www.cleartrip.com/");
        
        hotelLink.click();
        Reporter.log("Clicked on 'Hotels' link", true);
        
        localityTextBox.sendKeys("Indiranagar, Bangalore");
        Reporter.log("Entered 'Indiranagar, Bangalore' in textbox", true);
        
        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        Reporter.log("Selected '1 room, 2 adults' option", true);
        
        searchButton.click();
        Reporter.log("Clicked on 'Search hotels' button", true);

        driver.quit();
        Reporter.log("Quit the browser instance", true);
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
