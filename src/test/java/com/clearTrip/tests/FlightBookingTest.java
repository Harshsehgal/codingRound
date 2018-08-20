package com.clearTrip.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clearTrip.pageMethods.FlightBookingPageActions;

public class FlightBookingTest {
	
	FlightBookingPageActions fb;
	
	@BeforeTest
	public void setup() {
		fb = new FlightBookingPageActions();
	}
	
	@Test
	public void TestSignInPage() {
		fb.testThatResultsAppearForAOneWayJourney();
	}
	
}
