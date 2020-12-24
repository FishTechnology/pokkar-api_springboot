package com.us.pokkarapi.controllers.game.models;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

@Data
public class CreateGameRequestModel {	
	
	@JMap
	private String name;
	
	@JMap
	private Long userid;

}
