/**
 * 
 */
package com.us.pokkarapi.services.storypoint;

import java.util.List;

import com.us.pokkarapi.controllers.storypoint.models.StoryPointModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.CreateStoryPointDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface StoryPointService {

	List<StoryPointModel> getStoryPointsByUserId(String userid)  throws UsApplicationException;

	List<ErrorMessage> createStoryPoint(CreateStoryPointDto createStoryPointDto);
}
