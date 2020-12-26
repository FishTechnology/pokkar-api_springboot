/**
 * 
 */
package com.us.pokkarapi.services.userstory;

import java.util.List;

import com.us.pokkarapi.controllers.userstory.models.UserStoryModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface UserStoryService {

	List<UserStoryModel> getUserStoriesByGameId(String gameid) throws UsApplicationException ;

	UserStoryModel getUserStoryById(String gameid, String userstoryid) throws UsApplicationException;

	List<ErrorMessage> createUserStory(CreateUserStoryDto createUserStoryDto);

}
