/**
 * 
 */
package com.us.pokkarapi.controllers.game.models;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class UpdateGameRequestModel {
	
	@JMap
	private String name;
	
	@JMap
	private Long userid;
}
