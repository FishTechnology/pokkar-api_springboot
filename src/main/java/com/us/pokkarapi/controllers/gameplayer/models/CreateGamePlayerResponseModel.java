/**
 * 
 */
package com.us.pokkarapi.controllers.gameplayer.models;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class CreateGamePlayerResponseModel extends RepresentationModel<CreateGamePlayerResponseModel>{

	private List<ErrorMessageModel> errorMessages;
	
	private Long id;
	
}
