/**
 * 
 */
package com.us.pokkarapi.services.userstory.processors;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface UserStoryServiceProcessor {

	List<ErrorMessage> processCreateUserStory(CreateUserStoryDto createUserStoryDto);

	List<ErrorMessage> createUserStory(CreateUserStoryDto createUserStoryDto);

}
