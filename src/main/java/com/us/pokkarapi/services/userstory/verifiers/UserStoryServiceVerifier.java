/**
 * 
 */
package com.us.pokkarapi.services.userstory.verifiers;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface UserStoryServiceVerifier {

	List<ErrorMessage> verifyCreateUserStory(CreateUserStoryDto createUserStoryDto);

	List<ErrorMessage> isUserIdvalid(CreateUserStoryDto createUserStoryDto);

	List<ErrorMessage> isGameIdValid(CreateUserStoryDto createUserStoryDto);

}
