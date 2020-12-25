/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.validators;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.errorcodes.GameServiceErrorCodes;
import com.us.pokkarapi.services.game.validators.GameServiceValidator;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.DeleteGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.errorcodes.GamePlayerServiceErrorCodes;
import com.us.pokkarapi.services.utilities.PokkarServiceUtility;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class GamePlayerServiceValidatorImpl implements GamePlayerServiceValidator {

	@Autowired
	private GamePlayerServiceErrorCodes gamePlayerServiceErrorCodes;
	
	@Autowired
	private GameServiceValidator gameServiceValidator;
	
	@Override
	public List<ErrorMessage> validateCreateGamePlayer(CreateGamePlayerDto createGamePlayerDto) {
		var result = this.createGamePlayerIsValid(createGamePlayerDto);
		if(!result.isEmpty()) {
			return result;
		}
		
        var gameUserIdResult = this.isUserIdValid(createGamePlayerDto);
        if(!gameUserIdResult.isEmpty()) {
			result.addAll(gameUserIdResult);
		}
        
        var gameGuestIdResult = this.isGuestIdValid(createGamePlayerDto);
        if(!gameGuestIdResult.isEmpty()) {
			result.addAll(gameGuestIdResult);
		}
        
        var gameIdResult = this.isGameIdValid(createGamePlayerDto);
        if(!gameIdResult.isEmpty()) {
			result.addAll(gameIdResult);
		}
		
		return result;
	}

	@Override
	public List<ErrorMessage> isGameIdValid(CreateGamePlayerDto createGamePlayerDto) {
		createGamePlayerDto.setGameId(NumberUtils.toLong(createGamePlayerDto.getRawGameId()));
		return Collections.emptyList();	
	}

	@Override
	public List<ErrorMessage> isGuestIdValid(CreateGamePlayerDto createGamePlayerDto) {
		createGamePlayerDto.setGuestid(NumberUtils.toLong(createGamePlayerDto.getRawGuestId()));
		return Collections.emptyList();	
	}

	@Override
	public List<ErrorMessage> isUserIdValid(CreateGamePlayerDto createGamePlayerDto) {
		createGamePlayerDto.setUserid(NumberUtils.toLong(createGamePlayerDto.getRawUserId()));
		return Collections.emptyList();	
	}

	@Override
	public List<ErrorMessage> createGamePlayerIsValid(CreateGamePlayerDto createGamePlayerDto) {
		if(createGamePlayerDto == null)
		{
			return PokkarServiceUtility.getErrorMessages(gamePlayerServiceErrorCodes.getCreateGamePlayerDtoIsEmptyErrorCode(), "incoming create gameplayer request is null");
		}
		
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> validateDeleteGamePlayer(DeleteGamePlayerDto deleteGamePlayerDto) {
		var result = this.deleteGamePlayerIsValid(deleteGamePlayerDto);
		if(!result.isEmpty()) {
			return result;
		}
		var gameUserIdResult = this.userIdIsValid(deleteGamePlayerDto);
		 if(!gameUserIdResult.isEmpty()) {
				result.addAll(gameUserIdResult);
			}
		var gameIdResult = this.gameIdIsValid(deleteGamePlayerDto);
		if(!gameIdResult.isEmpty()) {
			result.addAll(gameIdResult);
		}
		
		var gamePlayerIdResult = this.gamePlayerIdIsValid(deleteGamePlayerDto);
		if(!gamePlayerIdResult.isEmpty()) {
			result.addAll(gamePlayerIdResult);
		}
		
		return gameIdResult;
	}

	@Override
	public List<ErrorMessage> gamePlayerIdIsValid(DeleteGamePlayerDto deleteGamePlayerDto) {
		var errorMessage = gamePlayerIdIsValid(deleteGamePlayerDto.getRawGamePlayerId());
		if(!errorMessage.isEmpty()) {
			return errorMessage;
		}
		
		deleteGamePlayerDto.setId(NumberUtils.toLong(deleteGamePlayerDto.getRawGamePlayerId()));
		return Collections.emptyList();
	}
	
	@Override
	public List<ErrorMessage> gamePlayerIdIsValid(String gamePlayerId) {
		if(gamePlayerId == null) {
			return PokkarServiceUtility.getErrorMessages(gamePlayerServiceErrorCodes.getGamePlayerIdIsEmptyErrorCode(), "game player id is null");
		}
		
		if(!NumberUtils.isParsable(gamePlayerId)) {
			return PokkarServiceUtility.getErrorMessages(gamePlayerServiceErrorCodes.getGamePlayerIdNotNumberErrorCode(), "game player id is not number");
		}
		
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> gameIdIsValid(DeleteGamePlayerDto deleteGamePlayerDto) {
		var errorMessages = this.gameServiceValidator.gameIdIsValid(deleteGamePlayerDto.getRawGameId());
		if(!errorMessages.isEmpty()) {
			return errorMessages;
		}
		
		deleteGamePlayerDto.setGameId(NumberUtils.toLong(deleteGamePlayerDto.getRawGameId()));
		
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> userIdIsValid(DeleteGamePlayerDto deleteGamePlayerDto) {
		deleteGamePlayerDto.setUserid(NumberUtils.toLong(deleteGamePlayerDto.getRawUserId()));
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> deleteGamePlayerIsValid(DeleteGamePlayerDto deleteGamePlayerDto) {
		if(deleteGamePlayerDto == null)
		{
			return PokkarServiceUtility.getErrorMessages(gamePlayerServiceErrorCodes.getDeleteGamePlayerDtoIsEmptyErrorCode(), "incoming delete gameplayer request is null");
		}
		
		return Collections.emptyList();
	}

}
