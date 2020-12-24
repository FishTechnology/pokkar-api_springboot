package com.us.pokkarapi.services.game.processors;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;

public interface GameServiceProcessor {

	List<ErrorMessage> processCreateGame(CreateGameDto createGameDto);
	
	List<ErrorMessage> createGame(CreateGameDto createGameDto);

	List<ErrorMessage> processUpdateGame(UpdateGameDto updateGameDto);

	List<ErrorMessage> updateGame(UpdateGameDto updateGameDto);

	List<ErrorMessage> processDeleteGame(DeleteGameDto deleteGameDto);

	List<ErrorMessage> deleteGame(DeleteGameDto deleteGameDto); 	
	
	List<ErrorMessage> createGameIdentifier(CreateGameDto createGameDto);

	List<ErrorMessage> processUpdateGameStatus(UpdateGameStatusDto updateGameStatusDto);

	List<ErrorMessage> updateGameStatus(UpdateGameStatusDto updateGameStatusDto);

	List<ErrorMessage> updateGameIdentifier(UpdateGameStatusDto updateGameStatusDto);
}
