/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.datacontracts.dtos;

import java.util.List;

import com.us.pokkarapi.services.game.datacontracts.daos.GameDao;
import com.us.pokkarapi.services.gameplayer.datacontracts.daos.GamePlayerDao;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */

@Data
public class DeleteGamePlayerDto extends GamePlayerDto {

	private String rawGameId;
	private String rawGamePlayerId;
	private String rawUserId;
	private List<GamePlayerDao> gamePlayers;
	private List<GameDao> games;
}
