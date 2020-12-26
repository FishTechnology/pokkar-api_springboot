/**
 * 
 */
package com.us.pokkarapi.services.userstory.postprocessors;

import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface UserStoryServicePostProcessor {

	void createUserStoryPostProcessor(CreateUserStoryDto createUserStoryDto);

}
