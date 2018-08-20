package com.clearTrip.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clearTrip.pageMethods.HotelBookingPageActions;

public class HotelBookingTest {
	
	HotelBookingPageActions hotelBooking;
	
	@BeforeTest
	public void setup() {
		hotelBooking = new HotelBookingPageActions();
	}
	
	@Test
	public void Test_Hotel_Booking_Page() {
		hotelBooking.launchApplication();
		hotelBooking.clickOnHotelsLink();
		hotelBooking.enterLocalityDetails();
		hotelBooking.selectLocalityFromAutoComplete();
		hotelBooking.selectCheckInDate();
		hotelBooking.selectCheckOutDate();
		hotelBooking.selectNoOfTravellers();
		hotelBooking.clickOnSearchHotelsButton();
	}
	
}
