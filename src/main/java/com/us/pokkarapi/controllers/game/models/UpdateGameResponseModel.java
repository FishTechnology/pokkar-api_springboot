/**
 * 
 */
package com.us.pokkarapi.controllers.game.models;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */

@Data
public class UpdateGameResponseModel extends RepresentationModel<UpdateGameResponseModel> {
	
	private List<ErrorMessageModel> errorMessages;
	
}
