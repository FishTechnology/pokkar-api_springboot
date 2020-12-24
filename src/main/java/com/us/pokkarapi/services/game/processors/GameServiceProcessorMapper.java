/**
 * 
 */
package com.us.pokkarapi.services.game.processors;

import com.us.pokkarapi.services.game.datacontracts.daos.GameDao;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;
import com.us.pokkarapi.services.gameidentifier.datacontracts.daos.GameIdentifiersDao;

/**
 * @author sajansoosaimicheal
 *
 */
public interface GameServiceProcessorMapper {

	GameDao mapGameDao(CreateGameDto createGameDto);

	GameDao mapUpdateGameDao(UpdateGameDto updateGameDto);
	
	GameIdentifiersDao mapGameIdentifiersDao(CreateGameDto createGameDto);

	GameIdentifiersDao mapGameIdentifiersDao(UpdateGameStatusDto updateGameStatusDto);
}
