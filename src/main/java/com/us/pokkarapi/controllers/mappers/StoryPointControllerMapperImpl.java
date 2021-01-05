/**
 * 
 */
package com.us.pokkarapi.controllers.mappers;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;
import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;
import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointRequest;
import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointResponse;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.CreateStoryPointDto;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.DeleteStoryPointDto;
import com.us.pokkarapi.services.utilities.PokkarServiceUtility;

/**
 * @author sajansoosaimicheal
 *
 */

@Service
public class StoryPointControllerMapperImpl implements StoryPointControllerMapper {

	JMapper<CreateStoryPointDto, CreateStoryPointRequest> createStoryPointDtoJMapper;
		
	
	public StoryPointControllerMapperImpl() {
		
		createStoryPointDtoJMapper = new JMapper<>(CreateStoryPointDto.class, CreateStoryPointRequest.class);
	}
	
	@Override
	public CreateStoryPointDto mapCreateStoryPointDto(CreateStoryPointRequest createStoryPoint) 
	{
		return createStoryPointDtoJMapper.getDestination(createStoryPoint);
	}

	@Override
	public CreateStoryPointResponse mapCreateStoryPointResponse(
			List<ErrorMessage> result,
			CreateStoryPointDto createStoryPointDto) {
		var createStoryPointResponse = new CreateStoryPointResponse();
		
		if(!result.isEmpty()) 
		{
			createStoryPointResponse.setErrorMessages(PokkarServiceUtility.getErrorMessageModel(result));
			return createStoryPointResponse;
		}
		
		createStoryPointResponse.setId(createStoryPointDto.getId());
		
		return createStoryPointResponse;
	}

	@Override
	public DeleteStoryPointDto mapDeleteStoryPointDto(String storyPointId, String userid) {
		var deleteStoryPointDto = new DeleteStoryPointDto();
		deleteStoryPointDto.setRawStoryPointId(storyPointId);
		deleteStoryPointDto.setRawUserId(storyPointId);
		return deleteStoryPointDto;
	}

	@Override
	public List<ErrorMessageModel> mapErrorMessageModell(List<ErrorMessage> result, DeleteStoryPointDto deleteStoryPointDto) {
		if(!result.isEmpty()) 
		{
			return PokkarServiceUtility.getErrorMessageModel(result);	
		}
		
		return Collections.emptyList();
	}
}