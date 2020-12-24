package com.us.pokkarapi.services.game.validators;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;

public interface GameServiceValidator {

	List<ErrorMessage> validateCreateGame(CreateGameDto createGameDto);
	
	List<ErrorMessage> validateUpdateGameStatus(UpdateGameStatusDto updateGameStatusDto);
	
	List<ErrorMessage> validateUpdateGame(UpdateGameDto updateGameDto);
	
	List<ErrorMessage> validateDeleteGame(DeleteGameDto deleteGameDto);
	
	List<ErrorMessage> createGameIsValid(CreateGameDto createGameDto);
	
	List<ErrorMessage> gameNameIsValid(CreateGameDto createGameDto);
	
	List<ErrorMessage> gameStatusIsValid(CreateGameDto createGameDto);	

	List<ErrorMessage> updateGameIsValid(UpdateGameDto updateGameDto);

	List<ErrorMessage> gameNameIsValid(UpdateGameDto updateGameDto);

	List<ErrorMessage> gameUserIsValid(UpdateGameDto updateGameDto);

	List<ErrorMessage> validateGameName(String name);
	
	List<ErrorMessage> gameUserIsValid(CreateGameDto createGameDto);

	List<ErrorMessage> gameIdIsValid(UpdateGameDto updateGameDto);

	List<ErrorMessage> gameIdIsValid(DeleteGameDto deleteGameDto);

	List<ErrorMessage> gameUserIsValid(DeleteGameDto deleteGameDto);

	List<ErrorMessage> deleteGameIsValid(DeleteGameDto deleteGameDto);

	List<ErrorMessage> gameIdIsValid(String gameId);

	List<ErrorMessage> updateGameStatusDtoIsValid(UpdateGameStatusDto updateGameStatusDto);

	List<ErrorMessage> gameUserIsValid(UpdateGameStatusDto updateGameStatusDto);

	List<ErrorMessage> gameIdIsValid(UpdateGameStatusDto updateGameStatusDto);

	List<ErrorMessage> gameStatusIsValid(UpdateGameStatusDto updateGameStatusDto);

	List<ErrorMessage> gameStatusIsValid(String gameStatus);

}
