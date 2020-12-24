/**
 * 
 */
package com.us.pokkarapi.services.game.processors;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;
import com.us.pokkarapi.services.game.datacontracts.daos.GameDao;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;
import com.us.pokkarapi.services.gameidentifier.datacontracts.daos.GameIdentifiersDao;

/**
 * @author sajansoosaimicheal
 *
 */

@Service
public class GameServiceProcessorMapperImpl implements GameServiceProcessorMapper {
	
	JMapper<GameDao, CreateGameDto> gameDaoMapper;
	JMapper<GameDao, UpdateGameDto> updateGameDaoMapper;
	JMapper<GameDao, DeleteGameDto> deleteGameDaoMapper;
	
	public GameServiceProcessorMapperImpl() {
		gameDaoMapper = new JMapper<>(GameDao.class, CreateGameDto.class);
		updateGameDaoMapper = new JMapper<>(GameDao.class, UpdateGameDto.class);
		deleteGameDaoMapper = new JMapper<>(GameDao.class, DeleteGameDto.class);
	}

	@Override
	public GameDao mapGameDao(CreateGameDto createGameDto) {
		var gameDao = gameDaoMapper.getDestination(createGameDto);				
		gameDao.setStatus(createGameDto.getParsedStatus().getValue());
		gameDao.setGameIdentifierId(createGameDto.getGameIdentifierId());
		return gameDao;
	}
	
	@Override
	public GameDao mapUpdateGameDao(UpdateGameDto updateGameDto) {
		var gameDao = updateGameDaoMapper.getDestination(updateGameDto);				
		gameDao.setStatus(updateGameDto.getParsedStatus().getValue());
		return gameDao;
	}

	@Override
	public GameIdentifiersDao mapGameIdentifiersDao(CreateGameDto createGameDto) {
		var gameIdentifiersDao = new GameIdentifiersDao();
		gameIdentifiersDao.setIdentifier(UUID.randomUUID().toString());
		gameIdentifiersDao.setIsactive(true);
		gameIdentifiersDao.setCreatedby(createGameDto.getCreatedby());
		gameIdentifiersDao.setCreatedon(createGameDto.getCreatedon());
		gameIdentifiersDao.setModifiedby(createGameDto.getModifiedby());
		gameIdentifiersDao.setModifiedon(createGameDto.getModifiedon());
		return gameIdentifiersDao;
	}

	@Override
	public GameIdentifiersDao mapGameIdentifiersDao(UpdateGameStatusDto updateGameStatusDto) {
		var gameIdentifiersDao = new GameIdentifiersDao();
		gameIdentifiersDao.setIsactive(false);
		gameIdentifiersDao.setModifiedby(updateGameStatusDto.getModifiedby());
		gameIdentifiersDao.setModifiedon(updateGameStatusDto.getModifiedon());
		return gameIdentifiersDao;
	}

}
