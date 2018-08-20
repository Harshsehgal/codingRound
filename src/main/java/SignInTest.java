import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

@SuppressWarnings("restriction")
public class SignInTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        setDriverPath();
        
        driver.manage().window().maximize();
        
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
        
        driver.findElement(By.linkText("Your trips")).click();
        Reporter.log("Clicked on 'Your trips' link", true);
        
        driver.findElement(By.id("SignIn")).click();
        Reporter.log("Clicked on 'Sign In' button", true);
        
        driver.switchTo().frame(driver.findElement(By.id("modal_window")));
        Reporter.log("Switched to SignIn modal window", true);
        
        driver.findElement(By.id("signInButton")).click();
        Reporter.log("Clicked on 'Sign in' button from SignIn modal window", true);
        
        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        
        driver.switchTo().defaultContent();
        
        driver.quit();
        Reporter.log("Quit the Chrome browser instance", true);
    }
    
    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
