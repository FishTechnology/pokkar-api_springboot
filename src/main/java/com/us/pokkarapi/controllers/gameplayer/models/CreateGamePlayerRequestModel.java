/**
 * 
 */
package com.us.pokkarapi.controllers.gameplayer.models;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class CreateGamePlayerRequestModel {

	@JMap
	private String userid;
	
	@JMap
	private String guestid;
	
	@JMap
	private String gameid;
}
