/**
 * 
 */
package com.us.pokkarapi.services.userstory.processors;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;
import com.us.pokkarapi.services.userstory.repositories.UserStoryServiceRepository;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class UserStoryServiceProcessorImpl implements UserStoryServiceProcessor {

	@Autowired
	private UserStoryServiceRepository userStoryServiceRepository;
	
	@Autowired
	private UserStoryServiceProcessorMapper userStoryServiceProcessorMapper;
	
	@Override
	public List<ErrorMessage> processCreateUserStory(CreateUserStoryDto createUserStoryDto) {
		return createUserStory(createUserStoryDto);
	}

	@Override
	public List<ErrorMessage> createUserStory(CreateUserStoryDto createUserStoryDto) {
		var userStoryDao = userStoryServiceProcessorMapper.mapUserStoryDao(createUserStoryDto);
		var result = userStoryServiceRepository.save(userStoryDao);
		createUserStoryDto.setId(result.getId());
		
		return Collections.emptyList();
	}

}
