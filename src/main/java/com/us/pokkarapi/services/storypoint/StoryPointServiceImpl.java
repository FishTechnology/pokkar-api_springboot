/**
 * 
 */
package com.us.pokkarapi.services.storypoint;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointRequest;
import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointResponse;
import com.us.pokkarapi.controllers.storypoint.models.StoryPointModel;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.storypoint.datacontracts.daos.StoryPointDao;
import com.us.pokkarapi.services.storypoint.repositories.StoryPointModelRepository;
import com.us.pokkarapi.services.storypoint.repositories.StoryPointRepository;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class StoryPointServiceImpl implements StoryPointService {
	@Autowired
	private StoryPointModelRepository storyPointModelRepository;
	
	@Autowired
	private StoryPointRepository storyPointRepository;

	@Override
	public List<StoryPointModel> getStoryPointsByUserId(String userid) throws UsApplicationException {
		if(!StringUtils.isNumeric(userid)) {
			throw new UsApplicationException("user id is not in number format","");
		}
		
		var parsedUserId = Long.parseLong(userid);
		return storyPointModelRepository.findByUseridAndIsactive(parsedUserId, true);
	}

	@Override
	public CreateStoryPointResponse createStoryPoint(CreateStoryPointRequest createStoryPoint) {
		
		StoryPointDao storyPointDao = new StoryPointDao();
		storyPointRepository.save(storyPointDao);
		return null;
	}

}
