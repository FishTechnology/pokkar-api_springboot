/**
 * 
 */
package com.us.pokkarapi.controllers.mappers;

import java.util.List;

import com.us.pokkarapi.controllers.userstory.models.CreateUserStoryRequestModel;
import com.us.pokkarapi.controllers.userstory.models.CreateUserStoryResponseModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface UserStoryControllerMapper {

	CreateUserStoryDto mapCreateUserStoryDto(String gameid, CreateUserStoryRequestModel createGameRequest);

	CreateUserStoryResponseModel mapCreateUserStoryResponseModel(List<ErrorMessage> result, CreateUserStoryDto createUserStoryDto);

}
