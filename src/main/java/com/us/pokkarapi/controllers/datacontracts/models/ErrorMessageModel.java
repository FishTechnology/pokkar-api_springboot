/**
 * 
 */
package com.us.pokkarapi.controllers.datacontracts.models;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */

@Data
public class ErrorMessageModel {
	
	public ErrorMessageModel(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	private String errorCode;
	private String message;

}
