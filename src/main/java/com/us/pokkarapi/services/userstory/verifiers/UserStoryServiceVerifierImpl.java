/**
 * 
 */
package com.us.pokkarapi.services.userstory.verifiers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.errorcodes.GameServiceErrorCodes;
import com.us.pokkarapi.services.game.enums.GameStatus;
import com.us.pokkarapi.services.game.repositories.GameServiceRepository;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;
import com.us.pokkarapi.services.utilities.PokkarServiceUtility;

/**
 * @author sajansoosaimicheal
 *
 */

@Service
public class UserStoryServiceVerifierImpl implements UserStoryServiceVerifier {
	
	@Autowired
	private GameServiceRepository gameServiceRepository;
	
	@Autowired
	private GameServiceErrorCodes gameServiceErrorCodes;
	
	@Override
	public List<ErrorMessage> verifyCreateUserStory(CreateUserStoryDto createUserStoryDto) {
		var result = isGameIdValid(createUserStoryDto);
		if(!result.isEmpty()) {
			return result;
		}
		result= isUserIdvalid(createUserStoryDto);
		
		return result;
	}
	
	@Override
	public List<ErrorMessage> isUserIdvalid(CreateUserStoryDto createUserStoryDto) {
		return Collections.emptyList();
	}
	
	@Override
	public List<ErrorMessage> isGameIdValid(CreateUserStoryDto createUserStoryDto) {
		var skippedStatus = Arrays.asList(GameStatus.DELETED, GameStatus.COMPLETED);
		var games = gameServiceRepository.findByUseridAndIdAndStatusNotIn(createUserStoryDto.getUserid(), createUserStoryDto.getGameId(), skippedStatus);
		if(games.isEmpty()) {
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getGameIdIsNotFoundErrorCode(), "game id is not found");
		}
		return Collections.emptyList();
	}

}
