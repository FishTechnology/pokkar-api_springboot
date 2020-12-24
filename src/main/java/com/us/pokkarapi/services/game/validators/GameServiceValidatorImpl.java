package com.us.pokkarapi.services.game.validators;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;
import com.us.pokkarapi.services.game.enums.GameStatus;
import com.us.pokkarapi.services.game.errorcodes.GameServiceErrorCodes;
import com.us.pokkarapi.services.utilities.PokkarServiceUtility;

@Service
public class GameServiceValidatorImpl implements GameServiceValidator {

	@Autowired
	private GameServiceErrorCodes gameServiceErrorCodes;

	
	@Override
	public List<ErrorMessage> validateCreateGame(CreateGameDto createGameDto) {	
		var result = this.createGameIsValid(createGameDto);
		if(!result.isEmpty()) {
			return result;
		}
		var gameNameResult = this.gameNameIsValid(createGameDto);
		if(!gameNameResult.isEmpty()) {
			result.addAll(gameNameResult);
		}
		var gameStatusResult = this.gameStatusIsValid(createGameDto);
		if(!gameStatusResult.isEmpty()) {
			result.addAll(gameStatusResult);
		}
        var gameUserIdResult = this.gameUserIsValid(createGameDto);
        if(!gameUserIdResult.isEmpty()) {
			result.addAll(gameUserIdResult);
		}
		
		return result;
	}
	
	@Override
	public List<ErrorMessage> validateDeleteGame(DeleteGameDto deleteGameDto) {
		var result = this.deleteGameIsValid(deleteGameDto);
		if(!result.isEmpty()) {
			return result;
		}
		var gameUserIdResult = this.gameUserIsValid(deleteGameDto);
		 if(!gameUserIdResult.isEmpty()) {
				result.addAll(gameUserIdResult);
			}
		var gameIdResult = this.gameIdIsValid(deleteGameDto);
		if(!gameIdResult.isEmpty()) {
			result.addAll(gameIdResult);
		}
		return gameIdResult;
	}
	
	@Override
	public List<ErrorMessage> validateUpdateGame(UpdateGameDto updateGameDto) {
		
		var result = this.updateGameIsValid(updateGameDto);
		if(!result.isEmpty()) {
			return result;
		}
		var gameNameResult = this.gameNameIsValid(updateGameDto);
		if(!gameNameResult.isEmpty()) {
			result.addAll(gameNameResult);
		}
		var gameStatusResult = this.gameUserIsValid(updateGameDto);
		if(!gameStatusResult.isEmpty()) {
			result.addAll(gameStatusResult);
		}
		var gameIdResult = this.gameIdIsValid(updateGameDto);
		if(!gameIdResult.isEmpty()) {
			result.addAll(gameIdResult);
		}
		return result;
	}
	
	@Override
	public List<ErrorMessage> gameStatusIsValid(CreateGameDto createGameDto){
		
		if(createGameDto.getStatus().isEmpty()) {
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getGameStatusIsEmptyErrorCode(), "Game staus is empty");
		}		
		
		if(!GameStatus.isValid(createGameDto.getStatus())) {
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getGameStatusIsInValidErrorCode(), "Game staus is invalid");
		}
		
		createGameDto.setParsedStatus(new GameStatus(createGameDto.getStatus()));
		
		return Collections.emptyList();
	}
	
	@Override
	public List<ErrorMessage> gameUserIsValid(CreateGameDto createGameDto) {
		return Collections.emptyList();		
	}

	@Override
	public List<ErrorMessage> createGameIsValid(CreateGameDto createGameDto){
		
		if(createGameDto == null)
		{
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getCreateGameDtoIsEmptyErrorCode(), "incoming request is null");
		}
		
		return Collections.emptyList();
	}
	
	@Override
	public List<ErrorMessage> gameNameIsValid(CreateGameDto createGameDto){
		return validateGameName(createGameDto.getName());
	}
	
	@Override
	public List<ErrorMessage> gameIdIsValid(UpdateGameDto updateGameDto) {
		
		if(updateGameDto.getRawGameId() == null) {
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getUpdateGameIdIsEmptyErrorCode(), "game id is null");
		}
		
		if(!NumberUtils.isParsable(updateGameDto.getRawGameId())) {
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getUpdateGameIdNotNumberErrorCode(), "game id is not number");
		}
		
		updateGameDto.setId(NumberUtils.toLong(updateGameDto.getRawGameId()));
		
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> updateGameIsValid(UpdateGameDto updateGameDto) {
		if(updateGameDto == null)
		{
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getUpdateGameDtoIsEmptyErrorCode(), "update game request is null");
		}
		
		return Collections.emptyList();
		
	}
	
	@Override
	public List<ErrorMessage> gameNameIsValid(UpdateGameDto updateGameDto) {
		return validateGameName(updateGameDto.getName());
	}

	@Override
	public List<ErrorMessage> gameUserIsValid(UpdateGameDto updateGameDto) {
		return Collections.emptyList();		
	}
	
	@Override
	public List<ErrorMessage> validateGameName(String name){
		if(!name.isEmpty()) {
			return Collections.emptyList();
		}
		
		return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getGameNameIsEmptyErrorCode(), "Game name is empty");
	}

	@Override
	public List<ErrorMessage> gameIdIsValid(DeleteGameDto deleteGameDto) {
		var errorMessage = gameIdIsValid(deleteGameDto.getRawGameId());
		if(!errorMessage.isEmpty()) {
			return errorMessage;
		}
		
		deleteGameDto.setId(NumberUtils.toLong(deleteGameDto.getRawGameId()));
		return Collections.emptyList();
	}
	
	@Override
	public List<ErrorMessage> gameIdIsValid(String gameId) {
		if(gameId == null) {
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getUpdateGameIdIsEmptyErrorCode(), "game id is null");
		}
		
		if(!NumberUtils.isParsable(gameId)) {
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getUpdateGameIdNotNumberErrorCode(), "game id is not number");
		}
		
		return Collections.emptyList();
	}
	
	@Override
	public List<ErrorMessage> gameUserIsValid(DeleteGameDto deleteGameDto) {
		deleteGameDto.setUserid(NumberUtils.toLong(deleteGameDto.getRawUserId()));
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> deleteGameIsValid(DeleteGameDto deleteGameDto) {
		if(deleteGameDto == null)
		{
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getDeleteGameDtoIsEmptyErrorCode(), "delete game request is null");
		}
		
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> validateUpdateGameStatus(UpdateGameStatusDto updateGameStatusDto) {
		var result = this.updateGameStatusDtoIsValid(updateGameStatusDto);
		if(!result.isEmpty()) {
			return result;
		}
		var gameUserIdResult = this.gameUserIsValid(updateGameStatusDto);
		if(!gameUserIdResult.isEmpty()) {
			result.addAll(gameUserIdResult);
		}
		var gameIdResult = this.gameIdIsValid(updateGameStatusDto);
		if(!gameIdResult.isEmpty()) {
			result.addAll(gameIdResult);
		}
		var gameStatusResult = this.gameStatusIsValid(updateGameStatusDto);
		if(!gameStatusResult.isEmpty()) {
			result.addAll(gameStatusResult);
		}
		return result;
	}

	@Override
	public List<ErrorMessage> gameStatusIsValid(UpdateGameStatusDto updateGameStatusDto) {
		var errorMessage = gameStatusIsValid(updateGameStatusDto.getStatus());
		if(!errorMessage.isEmpty()) {
			return errorMessage;
		}
		
		updateGameStatusDto.setParsedStatus(new GameStatus(updateGameStatusDto.getStatus()));
		return Collections.emptyList();
	}
	
	@Override
	public List<ErrorMessage> gameStatusIsValid(String gameStatus) {
		if(gameStatus == null) {
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getUpdateGameStatusIsEmptyErrorCode(), "game status is null");
		}
		
		if(!GameStatus.isValid(gameStatus)) {
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getUpdateGameStatusIsNotValidErrorCode(), "game status is not number");
		}
		
		return Collections.emptyList();
	}
	

	@Override
	public List<ErrorMessage> gameIdIsValid(UpdateGameStatusDto updateGameStatusDto) {
		var errorMessage = gameIdIsValid(updateGameStatusDto.getRawGameId());
		if(!errorMessage.isEmpty()) {
			return errorMessage;
		}
		
		updateGameStatusDto.setId(NumberUtils.toLong(updateGameStatusDto.getRawGameId()));
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> gameUserIsValid(UpdateGameStatusDto updateGameStatusDto) {
		updateGameStatusDto.setUserid(NumberUtils.toLong(updateGameStatusDto.getRawUserId()));
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> updateGameStatusDtoIsValid(UpdateGameStatusDto updateGameStatusDto) {
		if(updateGameStatusDto == null)
		{
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getUpdateGameStatusDtoIsEmptyErrorCode(), "update game status request is null");
		}
		
		return Collections.emptyList();
	}

}
