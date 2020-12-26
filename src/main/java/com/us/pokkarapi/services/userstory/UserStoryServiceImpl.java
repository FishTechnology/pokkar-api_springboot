/**
 * 
 */
package com.us.pokkarapi.services.userstory;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.controllers.userstory.models.UserStoryModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.game.enums.GameStatus;
import com.us.pokkarapi.services.game.postprocessors.GameServicePostProcessor;
import com.us.pokkarapi.services.game.processors.GameServiceProcessor;
import com.us.pokkarapi.services.game.validators.GameServiceValidator;
import com.us.pokkarapi.services.game.verifiers.GameServiceVerifier;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;
import com.us.pokkarapi.services.userstory.postprocessors.UserStoryServicePostProcessor;
import com.us.pokkarapi.services.userstory.processors.UserStoryServiceProcessor;
import com.us.pokkarapi.services.userstory.repositories.UserStoryServiceModelRepository;
import com.us.pokkarapi.services.userstory.validators.UserStoryServiceValidator;
import com.us.pokkarapi.services.userstory.verifiers.UserStoryServiceVerifier;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class UserStoryServiceImpl implements UserStoryService {

	@Autowired
	private UserStoryServiceModelRepository userStoryServiceModelRepository;
	
	@Autowired
	private UserStoryServiceValidator userStoryServiceValidator;
	
	@Autowired
	private UserStoryServiceVerifier userStoryServiceVerifier;
	
	@Autowired
	private UserStoryServiceProcessor userStoryServiceProcessor;
	
	@Autowired
	private UserStoryServicePostProcessor userStoryServicePostProcessor;
	
	
	@Override
	public List<UserStoryModel> getUserStoriesByGameId(String gameid) throws UsApplicationException {
		if(!StringUtils.isNumeric(gameid)) {
			throw new UsApplicationException("game id is not in number format","");
		}
		
		var parsedGameId = Long.parseLong(gameid);

		return userStoryServiceModelRepository.findByGameidAndIsactiveOrderByIdAsc(parsedGameId,true);
	}

	@Override
	public UserStoryModel getUserStoryById(String gameid, String userstoryid) throws UsApplicationException {
		if(!StringUtils.isNumeric(gameid)) {
			throw new UsApplicationException("game id is not in number format","");
		}
		
		if(!StringUtils.isNumeric(userstoryid)) {
			throw new UsApplicationException("userstoryid  is not in number format","");
		}
		
		var parsedGameId = Long.parseLong(gameid);
		
		var parsedUserStoryId = Long.parseLong(userstoryid);

		return userStoryServiceModelRepository.findByGameidAndIdAndIsactiveOrderByIdAsc(parsedGameId, parsedUserStoryId,true);
	}

	@Override
	public List<ErrorMessage> createUserStory(CreateUserStoryDto createUserStoryDto) {
		if(createUserStoryDto != null) {
			var currentDate = new Date();
			createUserStoryDto.setCreatedon(currentDate);
			createUserStoryDto.setModifiedon(currentDate);
			createUserStoryDto.setCreatedby(createUserStoryDto.getRawUserId());
			createUserStoryDto.setModifiedby(createUserStoryDto.getRawUserId());
			createUserStoryDto.setIsActive(true);
		}
		
		var result = userStoryServiceValidator.validateCreateUserStory(createUserStoryDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = userStoryServiceVerifier.verifyCreateUserStory(createUserStoryDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = userStoryServiceProcessor.processCreateUserStory(createUserStoryDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		userStoryServicePostProcessor.createUserStoryPostProcessor(createUserStoryDto);		
		
		return result;
	}

}
