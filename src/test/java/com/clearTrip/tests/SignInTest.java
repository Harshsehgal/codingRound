package com.clearTrip.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clearTrip.pageMethods.SignInPageActions;

public class SignInTest {
	
	SignInPageActions si;
	
	@BeforeTest
	public void setup() {
		si = new SignInPageActions();
	}
	
	@Test
	public void TestSignInPage() {
		si.shouldThrowAnErrorIfSignInDetailsAreMissing();
	}
	
}
