package com.us.pokkarapi.controllers.game.models;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;

import lombok.Data;

@Data
public class CreateGameResponseModel extends RepresentationModel<CreateGameResponseModel> {

	private List<ErrorMessageModel> errorMessages;
	
	private Long id;
}
