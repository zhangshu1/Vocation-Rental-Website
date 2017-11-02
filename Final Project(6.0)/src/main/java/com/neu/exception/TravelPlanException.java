package com.neu.exception;

public class TravelPlanException extends Exception {
	
	public TravelPlanException(String message) {
		
		super("TravelPlanException-"+message);
		
	}
	
	public TravelPlanException(String message, Throwable cause) {
		
		super("TravelPlanException-"+message, cause);
		
	}
}
