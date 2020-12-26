/**
 * 
 */
package com.us.pokkarapi.services.userstory.validators;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.errorcodes.UserStoryServiceErrorCodes;
import com.us.pokkarapi.services.game.validators.GameServiceValidator;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;
import com.us.pokkarapi.services.utilities.PokkarServiceUtility;

/**
 * @author sajansoosaimicheal
 *
 */

@Service
public class UserStoryServiceValidatorImpl implements UserStoryServiceValidator {

	@Autowired
	private UserStoryServiceErrorCodes userStoryServiceErrorCodes;
	
	@Autowired
	private GameServiceValidator gameServiceValidator;
	
	@Override
	public List<ErrorMessage> validateCreateUserStory(CreateUserStoryDto createUserStoryDto) {
		var result = this.createUserStoryDtoIsValid(createUserStoryDto);
		if(!result.isEmpty()) {
			return result;
		}
		
        var gameUserIdResult = this.isUserIdValid(createUserStoryDto);
        if(!gameUserIdResult.isEmpty()) {
			result.addAll(gameUserIdResult);
		}
        
        var gameGuestIdResult = this.isNameValid(createUserStoryDto);
        if(!gameGuestIdResult.isEmpty()) {
			result.addAll(gameGuestIdResult);
		}
        
        var gameIdResult = this.isGameIdValid(createUserStoryDto);
        if(!gameIdResult.isEmpty()) {
			result.addAll(gameIdResult);
		}
		
		return result;
	}

	@Override
	public List<ErrorMessage> isGameIdValid(CreateUserStoryDto createUserStoryDto) {
		var errorMessages = this.gameServiceValidator.gameIdIsValid(createUserStoryDto.getRawGameId());
		if(!errorMessages.isEmpty()) {
			return errorMessages;
		}
		
		createUserStoryDto.setGameId(NumberUtils.toLong(createUserStoryDto.getRawGameId()));
		
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> isNameValid(CreateUserStoryDto createUserStoryDto) {
		if(Strings.isNullOrEmpty(createUserStoryDto.getName())) {
			return PokkarServiceUtility.getErrorMessages(userStoryServiceErrorCodes.getUserStoryNameIsEmptyErrorCode(), "create user story request is null");
		}
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> isUserIdValid(CreateUserStoryDto createUserStoryDto) {
		createUserStoryDto.setUserid(NumberUtils.toLong(createUserStoryDto.getRawUserId()));
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> createUserStoryDtoIsValid(CreateUserStoryDto createUserStoryDto) {
		if(createUserStoryDto == null)
		{
			return PokkarServiceUtility.getErrorMessages(userStoryServiceErrorCodes.getCreateUserStoryDtoIsEmptyErrorCode(), "create user story request is null");
		}
		
		return Collections.emptyList();
	}

}
