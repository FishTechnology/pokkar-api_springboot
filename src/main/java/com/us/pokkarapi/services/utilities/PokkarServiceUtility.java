/**
 * 
 */
package com.us.pokkarapi.services.utilities;

import java.util.ArrayList;
import java.util.List;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;

/**
 * @author sajansoosaimicheal
 *
 */
public class PokkarServiceUtility {
	
	private PokkarServiceUtility() {
	    throw new IllegalStateException("PokkarServiceUtility class");
	  }
	
	public static List<ErrorMessage> getErrorMessages(String errorCode, String message) {
		
		return getListOfErrorMessage(errorCode, message);	
	}
	
	public static List<ErrorMessage> getErrorMessages(String errorCode) {		
			
		return getListOfErrorMessage(errorCode, null);		
	}
	
	private static List<ErrorMessage> getListOfErrorMessage(String errorCode, String message) {
		
		List<ErrorMessage> errorMessages = new ArrayList<>();
		errorMessages.add(getErrorMessage(errorCode, message));
		return errorMessages;	
	}
	
	private static ErrorMessage getErrorMessage(String errorCode, String message) {
		
		return new ErrorMessage(errorCode, message);
	}

	public static String getHttpVerbs() {
		
		return null;		
	}
	
	public static List<ErrorMessageModel> getErrorMessageModel(List<ErrorMessage>  errorMessages){
		var errorMessageModels = new ArrayList<ErrorMessageModel>();
		for (ErrorMessage errorMessage : errorMessages) {
			
			errorMessageModels.add(new ErrorMessageModel(errorMessage.getErrorCode(), errorMessage.getMessage()));
		}
		return errorMessageModels;
	}
}
