package com.clearTrip.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clearTrip.pageMethods.FlightBookingPageActions;

public class FlightBookingTest {
	
	FlightBookingPageActions flightBooking;
	
	@BeforeTest
	public void setup() {
		flightBooking = new FlightBookingPageActions();
	}
	
	@Test
	public void Test_Flight_Booking_Page() {
		flightBooking.launchApplication();
		flightBooking.clickOnOneWayRadioButton();
		flightBooking.enterCityForFlightOrigin();
		flightBooking.selectCityForFlightOrigin();
		flightBooking.enterCityForFlightDestination();
		flightBooking.selectCityForFlightDestination();
		flightBooking.selectDepartureDate();
		flightBooking.clickOnSearchFlightsButton();
		flightBooking.verifyResultAppearForProvidedJourneySearch();
	}
	
}
