/**
 * 
 */
package com.us.pokkarapi.services.userstory.processors;

import com.us.pokkarapi.services.userstory.datacontracts.daos.UserStoryDao;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface UserStoryServiceProcessorMapper {

	UserStoryDao mapUserStoryDao(CreateUserStoryDto createUserStoryDto);

}
