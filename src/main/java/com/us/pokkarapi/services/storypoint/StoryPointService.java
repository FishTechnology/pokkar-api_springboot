/**
 * 
 */
package com.us.pokkarapi.services.storypoint;

import java.util.List;

import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointRequest;
import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointResponse;
import com.us.pokkarapi.controllers.storypoint.models.StoryPointModel;
import com.us.pokkarapi.services.exceptions.UsApplicationException;

/**
 * @author sajansoosaimicheal
 *
 */
public interface StoryPointService {

	List<StoryPointModel> getStoryPointsByUserId(String userid)  throws UsApplicationException;

	CreateStoryPointResponse createStoryPoint(CreateStoryPointRequest createStoryPoint);

}
