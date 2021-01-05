/**
 * 
 */
package com.us.pokkarapi.services.storypoint;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointResponse;
import com.us.pokkarapi.controllers.storypoint.models.StoryPointModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.game.enums.GameStatus;
import com.us.pokkarapi.services.storypoint.datacontracts.daos.StoryPointDao;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.CreateStoryPointDto;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.DeleteStoryPointDto;
import com.us.pokkarapi.services.storypoint.processors.StoryPointServiceProcessor;
import com.us.pokkarapi.services.storypoint.repositories.StoryPointModelRepository;
import com.us.pokkarapi.services.storypoint.repositories.StoryPointRepository;
import com.us.pokkarapi.services.storypoint.verifiers.StoryPointServiceVerifier;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class StoryPointServiceImpl implements StoryPointService {
	@Autowired
	private StoryPointModelRepository storyPointModelRepository;
	
	@Autowired
	private StoryPointServiceVerifier storyPointServiceVerifier;
	
	@Autowired
	private StoryPointServiceProcessor storyPointServiceProcessor;

	@Override
	public List<StoryPointModel> getStoryPointsByUserId(String userid) throws UsApplicationException {
		if(!StringUtils.isNumeric(userid)) {
			throw new UsApplicationException("user id is not in number format","");
		}
		
		var parsedUserId = Long.parseLong(userid);
		return storyPointModelRepository.findByUseridAndIsactive(parsedUserId, true);
	}

	@Override
	public List<ErrorMessage> createStoryPoint(CreateStoryPointDto createStoryPointDto) {

		var currentDate = new Date();
		createStoryPointDto.setCreatedon(currentDate);
		createStoryPointDto.setModifiedon(currentDate);
		createStoryPointDto.setCreatedby(createStoryPointDto.getRawUserId());
		createStoryPointDto.setModifiedby(createStoryPointDto.getRawUserId());
		
		createStoryPointDto.setUserid(NumberUtils.toLong(createStoryPointDto.getRawUserId()));
		createStoryPointDto.setPoint(NumberUtils.toLong(createStoryPointDto.getRawPoint()));
		

		
		var result = storyPointServiceVerifier.verifyCreateStoryPoint(createStoryPointDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = storyPointServiceProcessor.processCreateStoryPoint(createStoryPointDto);
		
		return result;
	}

	@Override
	public List<ErrorMessage> deleteStoryPoint(DeleteStoryPointDto deleteStoryPointDto) {
		
		var currentDate = new Date();
		deleteStoryPointDto.setCreatedon(currentDate);
		deleteStoryPointDto.setModifiedon(currentDate);
		deleteStoryPointDto.setCreatedby(deleteStoryPointDto.getRawUserId());
		deleteStoryPointDto.setModifiedby(deleteStoryPointDto.getRawUserId());
		deleteStoryPointDto.setIsactive(false);
		deleteStoryPointDto.setUserid(NumberUtils.toLong(deleteStoryPointDto.getRawUserId()));
		deleteStoryPointDto.setId(NumberUtils.toLong(deleteStoryPointDto.getRawStoryPointId()));
		
		
		var result = storyPointServiceVerifier.verifyDeleteStoryPoint(deleteStoryPointDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = storyPointServiceProcessor.processDeleteStoryPoint(deleteStoryPointDto);
		
		
		return result;
	}

}
