/**
 * 
 */
package com.us.pokkarapi.services.storypoint.verifiers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.errorcodes.StoryPointServiceErrorCodes;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.CreateStoryPointDto;
import com.us.pokkarapi.services.storypoint.repositories.StoryPointRepository;
import com.us.pokkarapi.services.utilities.PokkarServiceUtility;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class StoryPointServiceVerifierImpl implements StoryPointServiceVerifier {

	@Autowired
	private StoryPointRepository storyPointRepository;
	
	@Autowired
	private StoryPointServiceErrorCodes storyPointServiceErrorCodes;
	
	@Override
	public List<ErrorMessage> verifyCreateStoryPoint(CreateStoryPointDto createStoryPointDto) {
		return getStoryPointByPointAndUserId(createStoryPointDto);
	}

	@Override
	public List<ErrorMessage> getStoryPointByPointAndUserId(CreateStoryPointDto createStoryPointDto) {
		var storyPointDao = storyPointRepository.findByPointAndUseridAndIsactive(createStoryPointDto.getPoint(),createStoryPointDto.getUserid(), true);
		if(storyPointDao == null || storyPointDao.isEmpty()) {
			return Collections.emptyList();		
		}
		
		return PokkarServiceUtility.getErrorMessages(storyPointServiceErrorCodes.getDuplicateStoryPointErrorCode(), "story point is duplicated found");	
	}

}
