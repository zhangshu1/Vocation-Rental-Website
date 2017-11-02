package com.neu.exception;

public class HouseHolderException extends Exception{
	
	public HouseHolderException(String message)
	{
		super("HouseHolderException-"+message);
	}
	
	public HouseHolderException(String message, Throwable cause)
	{
		super("HouseHolderException-"+message,cause);
	}
}
