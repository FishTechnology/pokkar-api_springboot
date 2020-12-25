/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.processors;

import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.gameplayer.datacontracts.daos.GamePlayerDao;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class GamePlayerServiceProcessorMapperImpl implements GamePlayerServiceProcessorMapper {

	@Override
	public GamePlayerDao mapGamePlayerDao(CreateGamePlayerDto createGamePlayerDto) {
		GamePlayerDao gamePlayerDao = new GamePlayerDao();
		gamePlayerDao.setGameid(createGamePlayerDto.getGameId());
		gamePlayerDao.setUserid(createGamePlayerDto.getUserid());
		gamePlayerDao.setGuestid(createGamePlayerDto.getGuestid());
		gamePlayerDao.setIsactive(createGamePlayerDto.getIsactive());
		gamePlayerDao.setCreatedby(createGamePlayerDto.getCreatedby());
		gamePlayerDao.setCreatedon(createGamePlayerDto.getCreatedon());
		gamePlayerDao.setModifiedby(createGamePlayerDto.getModifiedby());
		gamePlayerDao.setModifiedon(createGamePlayerDto.getModifiedon());
		
		return gamePlayerDao;
	}

}
