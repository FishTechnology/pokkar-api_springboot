/**
 * 
 */
package com.us.pokkarapi.services.storypoint.processors;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.CreateStoryPointDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface StoryPointServiceProcessor {

	List<ErrorMessage> processCreateStoryPoint(CreateStoryPointDto createStoryPointDto);

	List<ErrorMessage> createStoryPoint(CreateStoryPointDto createStoryPointDto);

}
