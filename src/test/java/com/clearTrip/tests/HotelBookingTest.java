package com.clearTrip.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clearTrip.methods.HotelBookingPageActions;

public class HotelBookingTest {
	
	HotelBookingPageActions hb;
	
	@BeforeTest
	public void setup() {
		hb = new HotelBookingPageActions();
	}
	
	@Test
	public void TestSignInPage() {
		hb.shouldBeAbleToSearchForHotels();
	}
	
}
