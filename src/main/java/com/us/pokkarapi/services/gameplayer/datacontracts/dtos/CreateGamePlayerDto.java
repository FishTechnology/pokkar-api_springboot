/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.datacontracts.dtos;

import java.util.List;
import com.us.pokkarapi.services.game.datacontracts.daos.GameDao;
import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class CreateGamePlayerDto extends GamePlayerDto {

	private String rawUserId;
	
	private String rawGuestId;
	
	private String rawGameId;
	
	private List<GameDao> games;
}
