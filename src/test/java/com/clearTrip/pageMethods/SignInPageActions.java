package com.clearTrip.pageMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.clearTrip.getPageObjects.DriverFactory;
import com.clearTrip.getPageObjects.GetPage;

public class SignInPageActions extends GetPage {
	
	static WebDriver driver = null;
	static ChromeOptions options = null;
	static DriverFactory df = null;
	
	static {
		df = new DriverFactory();
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		df.setDriverPath();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public SignInPageActions() {
		super(driver);
	}
	
	public void clickOnYourTrips() {
        elementByLinkText("Your trips").click();
        logMessage("Clicked on 'Your trips' link");
	}
	
	public void navigateToSignInModalWindow() {
		elementById("SignIn").click();
        logMessage("Clicked on 'Sign In' button");
	}
	
	public void clickOnSignInButton( ) {
		switchToFrameById("modal_window");
        logMessage("Switched to SignIn modal window");
        
        elementById("signInButton").click();
        logMessage("Clicked on 'Sign in' button from SignIn modal window");
        
        switchToDefaultFrame();
	}
	
    public void verifyErrorMsgOnSubmissionDetails() {   	
        switchToFrameById("modal_window");
        logMessage("Switched to SignIn modal window");
        
        String errors1 = elementById("errors1").getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        logMessage("[ASSERTION PASSED]: Verified Error message on submission of blank details");
        
        switchToDefaultFrame();
        
        quitBrowser();
    }

}
