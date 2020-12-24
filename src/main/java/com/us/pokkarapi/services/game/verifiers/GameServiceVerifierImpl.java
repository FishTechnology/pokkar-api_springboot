package com.us.pokkarapi.services.game.verifiers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.datacontracts.daos.GameDao;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;
import com.us.pokkarapi.services.game.enums.GameStatus;
import com.us.pokkarapi.services.game.errorcodes.GameServiceErrorCodes;
import com.us.pokkarapi.services.game.repositories.GameServiceRepository;
import com.us.pokkarapi.services.utilities.PokkarServiceUtility;

@Service
public class GameServiceVerifierImpl implements GameServiceVerifier {
	
	@Autowired
	private GameServiceRepository gameServiceRepository;
	

	@Autowired
	private GameServiceErrorCodes gameServiceErrorCodes;
	

	@Override
	public List<ErrorMessage> verifyCreateGame(CreateGameDto createGameDto) {

		return gameNameIsValid(createGameDto);
	}
	
	@Override
	public List<ErrorMessage> gameNameIsValid(CreateGameDto createGameDto) {
		return isGameNameValid(createGameDto.getName(), createGameDto.getUserid());
	}

	@Override
	public List<ErrorMessage> verifyUpdateGame(UpdateGameDto updateGameDto) {
		var errors = gameIdIsValid(updateGameDto);
		if(errors != null && !errors.isEmpty()) {
			return errors;
		}
		return gameNameIsValid(updateGameDto);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ErrorMessage> gameIdIsValid(UpdateGameDto updateGameDto) {
		var result = gameIdIsValid(updateGameDto.getId(), updateGameDto.getUserid());	
		if(result[0] == Collections.emptyList()) {
			updateGameDto.setParsedStatus(new GameStatus(((GameDao)result[1]).getStatus()));
		}
		
		return (List<ErrorMessage>)result[0];
	}
	
	@Override 
	public Object[] gameIdIsValid(Long gameId, Long userId){
		var skippedStatus = Arrays.asList(GameStatus.DELETED);
		var gamesDetails =	gameServiceRepository.findByUseridAndIdAndStatusNotIn(userId, gameId, skippedStatus);
		 
		 if(!gamesDetails.isEmpty()) {
			return  new Object[] {Collections.emptyList(), gamesDetails.get(0)};
		 }		
		 return new Object[] {PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getGameIdIsNotFoundErrorCode(), "game id is not found")};	
	}

	@Override
	public List<ErrorMessage> gameNameIsValid(UpdateGameDto updateGameDto) {
		
		return isGameNameValid(updateGameDto.getName(), updateGameDto.getUserid());
	}
	
	@Override
	public List<ErrorMessage> isGameNameValid(String name, Long userId){
		 var gamesDetails =	gameServiceRepository.findByUseridAndName(userId, name);
		 
		 if(gamesDetails.isEmpty()) {
			 return Collections.emptyList();
		 }		
		 return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getDuplicateGameNameErrorCode(), "duplicate name found");
	}

	@Override
	public List<ErrorMessage> verifyDeleteGame(DeleteGameDto deleteGameDto) {
		return gameIdIsValid(deleteGameDto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ErrorMessage> gameIdIsValid(DeleteGameDto deleteGameDto) {
		var result = gameIdIsValid(deleteGameDto.getId(), deleteGameDto.getUserid());	
		if(result[0] == Collections.emptyList()) {
			deleteGameDto.setParsedStatus(new GameStatus(deleteGameDto.getStatus()));
		}
		
		return (List<ErrorMessage>)result[0];
	}

	@Override
	public List<ErrorMessage> verifyUpdateGameStatus(UpdateGameStatusDto updateGameStatusDto) {
		var errorMessage = gameIdIsValid(updateGameStatusDto);
		if(!errorMessage.isEmpty()) {
			return errorMessage;
		}
		return gameStatusIsValid(updateGameStatusDto);
	}

	@Override
	public List<ErrorMessage> gameStatusIsValid(UpdateGameStatusDto updateGameStatusDto) {
		if(updateGameStatusDto.getExistingGame().getStatus().equals(GameStatus.COMPLETED)) {
			 return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getGameIsCompletedStatusCannotEditErrorCode(), "game id not found");
		}
		
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> gameIdIsValid(UpdateGameStatusDto updateGameStatusDto) {
		var result = gameIdIsValid(updateGameStatusDto.getId(), updateGameStatusDto.getUserid());	
		if(result[0] != Collections.emptyList()) {
			 return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getGameIdIsNotFoundErrorCode(), "game id not found");
		}
		
		updateGameStatusDto.setExistingGame((GameDao)result[1]);
		return (List<ErrorMessage>)result[0];
	}

}
