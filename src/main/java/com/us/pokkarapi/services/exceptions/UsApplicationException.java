package com.us.pokkarapi.services.exceptions;

public class UsApplicationException extends Exception {
	
	private static final long serialVersionUID = 5241492225089085255L;
	private final String errorCode;
	
	public UsApplicationException(String errorMessage,String errorCode) {
		super(errorMessage);
		this.errorCode = errorCode;
	}

	
	public String getErrorCode() {
		return errorCode;
	}
}
