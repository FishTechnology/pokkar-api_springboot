/**
 * 
 */
package com.us.pokkarapi.controllers.mappers;

import java.util.List;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;
import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointRequest;
import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointResponse;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.CreateStoryPointDto;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.DeleteStoryPointDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface StoryPointControllerMapper {

	CreateStoryPointDto mapCreateStoryPointDto(CreateStoryPointRequest createStoryPoint);

	CreateStoryPointResponse mapCreateStoryPointResponse(List<ErrorMessage> response, CreateStoryPointDto createStoryPointDto);

	DeleteStoryPointDto mapDeleteStoryPointDto(String storyPointId, String userid);

	List<ErrorMessageModel> mapErrorMessageModell(List<ErrorMessage> result, DeleteStoryPointDto deleteStoryPointDto);

}
