import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;

@SuppressWarnings("restriction")
public class FlightBookingTest {
	
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        setDriverPath();
        
        driver.manage().window().maximize();
        Reporter.log("Maximized Chrome browser instance", true);
        
        driver.get("https://www.cleartrip.com/");
        Reporter.log("Navigated to ClearTrip website", true);
        
        driver.findElement(By.id("OneWay")).click();
        Reporter.log("Clicked on 'One way' radio button", true);

        driver.findElement(By.id("FromTag")).clear();
        Reporter.log("Cleared 'From' input field", true);
        
        driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
        Reporter.log("Entered 'Bangalore' in 'From' input field", true);
        
        // Explicit wait for the auto complete options to appear for the Origin
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ui-id-1"))));
        
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();
        Reporter.log("Selected entered city as Origin", true);

        driver.findElement(By.id("ToTag")).clear();
        Reporter.log("Cleared 'From' input field", true);
        
        driver.findElement(By.id("ToTag")).sendKeys("Delhi");
        Reporter.log("Entered 'Delhi' in 'To' input field", true);

        // Explicit wait for the auto complete options to appear for the Destination
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ui-id-2"))));
        
        // Select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();
        Reporter.log("Selected entered city as Origin", true);
        
        driver.findElement(By.xpath("//a[contains(@class,'ui-state-active')]")).click();
        Reporter.log("Selected date for 'Depart on' field", true);

        // All fields filled in. Now click on search
        driver.findElement(By.id("SearchBtn")).click();
        Reporter.log("Clicked on 'Search flights' button", true);
        
        // Verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));
        Reporter.log("Verified search results are appearing for 'One way' journey", true);
        
        driver.quit();
        Reporter.log("Quit the Chrome browser instance", true);
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
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
