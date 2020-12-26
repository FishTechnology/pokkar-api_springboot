/**
 * 
 */
package com.us.pokkarapi.services.userstory.validators;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface UserStoryServiceValidator {

	List<ErrorMessage> validateCreateUserStory(CreateUserStoryDto createUserStoryDto);

	List<ErrorMessage> isGameIdValid(CreateUserStoryDto createUserStoryDto);

	List<ErrorMessage> isNameValid(CreateUserStoryDto createUserStoryDto);

	List<ErrorMessage> isUserIdValid(CreateUserStoryDto createUserStoryDto);

	List<ErrorMessage> createUserStoryDtoIsValid(CreateUserStoryDto createUserStoryDto);

}
