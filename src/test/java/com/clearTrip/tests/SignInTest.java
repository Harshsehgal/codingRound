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
	public void TestSignInPage() {
		signIn.clickOnYourTrips();
		signIn.navigateToSignInModalWindow();
		signIn.clickOnSignInButton();
		signIn.verifyErrorMsgOnSubmissionDetails();
	}
	
}
