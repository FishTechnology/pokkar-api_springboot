package com.us.pokkarapi.controllers.userstory.models;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

@Data
public class CreateUserStoryRequestModel {

	@JMap
	private String userid;
	
	@JMap
	private String name;
	
	@JMap
	private String description;
	
	@JMap
	private String acceptanceCriteria;
}
