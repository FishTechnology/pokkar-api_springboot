/**
 * 
 */
package com.us.pokkarapi.services.errorcodes;

import org.springframework.stereotype.Service;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class UserStoryServiceErrorCodes {

	public String getCreateUserStoryDtoIsEmptyErrorCode() {
		return "Pokkar.Api.{0}.{1}.CreateUserStoryDto.IsEmpty";
	}

	public String getUserStoryNameIsEmptyErrorCode() {
		return "Pokkar.Api.{0}.{1}.UserStory.Name.IsEmpty";
	}

}
