/**
 * 
 */
package com.us.pokkarapi.services.storypoint.verifiers;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.CreateStoryPointDto;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.DeleteStoryPointDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface StoryPointServiceVerifier {

	List<ErrorMessage> verifyCreateStoryPoint(CreateStoryPointDto createStoryPointDto);

	List<ErrorMessage> getStoryPointByPointAndUserId(CreateStoryPointDto createStoryPointDto);

	List<ErrorMessage> verifyDeleteStoryPoint(DeleteStoryPointDto deleteStoryPointDto);

}
