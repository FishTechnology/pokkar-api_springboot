/**
 * 
 */
package com.us.pokkarapi.services.game;

import java.util.List;

import com.us.pokkarapi.controllers.game.models.GameModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface GameService {

	List<GameModel> getGamesByUserId(String userid) throws UsApplicationException;

	List<ErrorMessage> createGame(CreateGameDto createGameDto);

	List<ErrorMessage> updateGame(UpdateGameDto updateGameDto);

	List<ErrorMessage> deleteGame(DeleteGameDto deleteGameDto);

	List<ErrorMessage> updateGameStatus(UpdateGameStatusDto updateGameStatusDto);

}
