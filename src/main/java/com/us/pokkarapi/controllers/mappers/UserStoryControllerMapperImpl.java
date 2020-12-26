/**
 * 
 */
package com.us.pokkarapi.controllers.mappers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.us.pokkarapi.controllers.userstory.models.CreateUserStoryRequestModel;
import com.us.pokkarapi.controllers.userstory.models.CreateUserStoryResponseModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;
import com.us.pokkarapi.services.utilities.PokkarServiceUtility;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class UserStoryControllerMapperImpl implements UserStoryControllerMapper {

	@Override
	public CreateUserStoryDto mapCreateUserStoryDto(String gameid, CreateUserStoryRequestModel createUserStoryRequestModel) {
		var createUserStoryDto = new CreateUserStoryDto();
		createUserStoryDto.setRawUserId(createUserStoryRequestModel.getUserid());
		createUserStoryDto.setRawGameId(gameid);		
		createUserStoryDto.setName(createUserStoryRequestModel.getName());
		createUserStoryDto.setDescription(createUserStoryRequestModel.getDescription());		
		createUserStoryDto.setAcceptanceCriteria(createUserStoryRequestModel.getAcceptanceCriteria());
		
		return createUserStoryDto;
	}

	@Override
	public CreateUserStoryResponseModel mapCreateUserStoryResponseModel(List<ErrorMessage> result,
			CreateUserStoryDto createUserStoryDto) {
		var createUserStoryResponseModel = new CreateUserStoryResponseModel();
		
		if(!result.isEmpty()) 
		{
			createUserStoryResponseModel.setErrorMessages(PokkarServiceUtility.getErrorMessageModel(result));
			return createUserStoryResponseModel;
		}
		
		createUserStoryResponseModel.setId(createUserStoryDto.getId());
		
		return createUserStoryResponseModel;
	}

}
