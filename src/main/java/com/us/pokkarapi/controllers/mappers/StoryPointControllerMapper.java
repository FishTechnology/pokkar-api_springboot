/**
 * 
 */
package com.us.pokkarapi.controllers.mappers;

import java.util.List;

import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointRequest;
import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointResponse;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.CreateStoryPointDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface StoryPointControllerMapper {

	CreateStoryPointDto mapCreateStoryPointDto(CreateStoryPointRequest createStoryPoint);

	CreateStoryPointResponse mapCreateStoryPointResponse(List<ErrorMessage> response, CreateStoryPointDto createStoryPointDto);

}
