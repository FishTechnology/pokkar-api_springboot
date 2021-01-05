/**
 * 
 */
package com.us.pokkarapi.services.storypoint.processors;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.storypoint.datacontracts.daos.StoryPointDao;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.CreateStoryPointDto;
import com.us.pokkarapi.services.storypoint.datacontracts.dtos.DeleteStoryPointDto;
import com.us.pokkarapi.services.storypoint.repositories.StoryPointRepository;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class StoryPointServiceProcessorImpl implements StoryPointServiceProcessor {
	
	@Autowired
	private StoryPointRepository storyPointRepository;
	
	JMapper<StoryPointDao, CreateStoryPointDto> createStoryPointDaoJMapper;
	
	public StoryPointServiceProcessorImpl() {
		createStoryPointDaoJMapper = new JMapper<>(StoryPointDao.class, CreateStoryPointDto.class);
	}

	@Override
	public List<ErrorMessage> processCreateStoryPoint(CreateStoryPointDto createStoryPointDto) {
		return createStoryPoint(createStoryPointDto);
	}

	@Override
	public List<ErrorMessage> createStoryPoint(CreateStoryPointDto createStoryPointDto) {
		var storyPoint = createStoryPointDaoJMapper.getDestination(createStoryPointDto);
		storyPoint.setIsactive(true);
		storyPointRepository.save(storyPoint);
		createStoryPointDto.setId(storyPoint.getId());
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> processDeleteStoryPoint(DeleteStoryPointDto deleteStoryPointDto) {
		storyPointRepository.deleteStoryPoint(
				deleteStoryPointDto.getId(),
				deleteStoryPointDto.getIsactive(),
				deleteStoryPointDto.getModifiedby(),
				deleteStoryPointDto.getModifiedon());
		return Collections.emptyList();
	}

}
