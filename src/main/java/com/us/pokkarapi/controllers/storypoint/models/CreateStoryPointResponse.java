/**
 * 
 */
package com.us.pokkarapi.controllers.storypoint.models;

import java.util.List;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class CreateStoryPointResponse {
	
	private List<ErrorMessageModel> errorMessages;
	
	private Long id;

}
