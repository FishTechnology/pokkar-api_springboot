/**
 * 
 */
package com.us.pokkarapi.services.userstory.datacontracts.dtos;

import java.util.List;

import com.us.pokkarapi.services.game.datacontracts.daos.GameDao;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class CreateUserStoryDto extends UserStoryDto {
	
	private String rawUserId;
	
	private String rawGameId;
	
	private List<GameDao> games;
}
