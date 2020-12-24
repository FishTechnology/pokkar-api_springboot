package com.us.pokkarapi.services.game.verifiers;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;

public interface GameServiceVerifier {

	List<ErrorMessage> verifyCreateGame(CreateGameDto createGameDto);
	
	List<ErrorMessage> gameNameIsValid(CreateGameDto createGameDto);

	List<ErrorMessage> verifyUpdateGame(UpdateGameDto updateGameDto);

	List<ErrorMessage> isGameNameValid(String name, Long userId);

	Object[] gameIdIsValid(Long gameId, Long userId);

	List<ErrorMessage> gameIdIsValid(UpdateGameDto updateGameDto);

	List<ErrorMessage> gameNameIsValid(UpdateGameDto updateGameDto);

	List<ErrorMessage> verifyDeleteGame(DeleteGameDto deleteGameDto);

	List<ErrorMessage> gameIdIsValid(DeleteGameDto deleteGameDto);

	List<ErrorMessage> verifyUpdateGameStatus(UpdateGameStatusDto updateGameStatusDto);

	List<ErrorMessage> gameIdIsValid(UpdateGameStatusDto updateGameStatusDto);

	List<ErrorMessage> gameStatusIsValid(UpdateGameStatusDto updateGameStatusDto);
}
