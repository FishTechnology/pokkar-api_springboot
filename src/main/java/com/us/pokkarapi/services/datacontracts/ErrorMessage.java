package com.us.pokkarapi.services.datacontracts;

import lombok.Data;

@Data
public class ErrorMessage {
	
	public ErrorMessage(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	
	private String errorCode;
	private String message;

}
