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
public class UpdateGameStatusModel {

	@JMap
	private String status;
	
	@JMap
	private String userid;
}
