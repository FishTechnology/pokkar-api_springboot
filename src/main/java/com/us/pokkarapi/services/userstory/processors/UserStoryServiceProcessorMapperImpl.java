/**
 * 
 */
package com.us.pokkarapi.services.userstory.processors;

import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.userstory.datacontracts.daos.UserStoryDao;
import com.us.pokkarapi.services.userstory.datacontracts.dtos.CreateUserStoryDto;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class UserStoryServiceProcessorMapperImpl implements UserStoryServiceProcessorMapper {

	@Override
	public UserStoryDao mapUserStoryDao(CreateUserStoryDto createUserStoryDto) {
		var userStoryDao = new UserStoryDao();
		userStoryDao.setGameid(createUserStoryDto.getGameId());
		userStoryDao.setUserid(createUserStoryDto.getUserid());
		userStoryDao.setName(createUserStoryDto.getName());
		userStoryDao.setDescription(createUserStoryDto.getDescription());
		userStoryDao.setAcceptanceCriteria(createUserStoryDto.getAcceptanceCriteria());
		userStoryDao.setIsactive(createUserStoryDto.getIsActive());
		userStoryDao.setCreatedby(createUserStoryDto.getCreatedby());
		userStoryDao.setCreatedon(createUserStoryDto.getCreatedon());
		userStoryDao.setModifiedby(createUserStoryDto.getModifiedby());
		userStoryDao.setModifiedon(createUserStoryDto.getModifiedon());
		return userStoryDao;
	}

}
