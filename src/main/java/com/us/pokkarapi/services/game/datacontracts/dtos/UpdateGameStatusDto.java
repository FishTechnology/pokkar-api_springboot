/**
 * 
 */
package com.us.pokkarapi.services.game.datacontracts.dtos;

import com.us.pokkarapi.services.game.datacontracts.daos.GameDao;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class UpdateGameStatusDto extends GameDto {
	private String rawGameId;
	
	private String rawUserId;
	
	private GameDao existingGame;
}
