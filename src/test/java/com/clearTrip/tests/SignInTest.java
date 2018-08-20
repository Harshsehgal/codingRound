package com.clearTrip.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clearTrip.pageMethods.SignInPageActions;

public class SignInTest {
	
	SignInPageActions signIn;
	
	@BeforeTest
	public void setup() {
		signIn = new SignInPageActions();
	}
	
	@Test
	public void Test_Sign_In_Page() {
		signIn.launchApplication();
		signIn.clickOnYourTrips();
		signIn.navigateToSignInModalWindow();
		signIn.clickOnSignInButton();
		signIn.verifyErrorMsgOnSubmissionDetails();
	}
	
}
