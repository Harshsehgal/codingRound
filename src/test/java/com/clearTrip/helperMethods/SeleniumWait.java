package com.clearTrip.helperMethods;

public class SeleniumWait {

	protected void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
}
