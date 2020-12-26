/**
 * 
 */
package com.us.pokkarapi.controllers.userstory.models;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */

@Data
public class CreateUserStoryResponseModel extends RepresentationModel<CreateUserStoryResponseModel>{

	private List<ErrorMessageModel> errorMessages;
	
	private Long id;
}
