package com.clearTrip.tests;

import com.clearTrip.helperMethods.DriverFactory;
import com.clearTrip.helperMethods.GetPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends GetPage {
	
	static WebDriver driver = null;
	static DriverFactory df = null;
	
	static {
		driver = new ChromeDriver();
		df = new DriverFactory();
	}

	public SignInTest() {
		super(driver);
	}
    
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	df.setDriverPath();
    	
    	windowMaximise();
        logMessage("Maximized Chrome browser instance");
        
        launchUrl("https://www.cleartrip.com/");
        logMessage("Navigated to ClearTrip website");
        
        elementByLinkText("Your trips").click();
        logMessage("Clicked on 'Your trips' link");
        
        elementById("SignIn").click();
        logMessage("Clicked on 'Sign In' button");
        
        switchToFrameById("modal_window");
        logMessage("Switched to SignIn modal window");
        
        elementById("signInButton").click();
        logMessage("Clicked on 'Sign in' button from SignIn modal window");
        
        String errors1 = elementById("errors1").getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        
        switchToDefaultFrame();
        logMessage("Switched back to default frame");
        
        quitBrowser();
        logMessage("Quit the Chrome browser instance");
    }

}
