package com.neu.exception;

public class HouseException extends Exception{
	
	public HouseException(String message)
	{
		super("HouseException-"+message);
	}
	
	public HouseException(String message, Throwable cause)
	{
		super("HouseException-"+message,cause);
	}
}
