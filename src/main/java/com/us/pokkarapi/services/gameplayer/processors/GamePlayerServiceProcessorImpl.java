/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.processors;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.DeleteGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.repositories.GamePlayerServiceRepository;

/**
 * @author sajansoosaimicheal
 *
 */

@Service
public class GamePlayerServiceProcessorImpl implements GamePlayerServiceProcessor {
	
	@Autowired
	private GamePlayerServiceRepository gamePlayerServiceRepository;
	
	@Autowired
	private GamePlayerServiceProcessorMapper gamePlayerServiceProcessorMapper;

	@Override
	public List<ErrorMessage> processCreateGamePlayer(CreateGamePlayerDto createGamePlayerDto) {
		createGamePlayer(createGamePlayerDto);
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> createGamePlayer(CreateGamePlayerDto createGamePlayerDto) {
		var gamePlayerDao = gamePlayerServiceProcessorMapper.mapGamePlayerDao(createGamePlayerDto);
		var result = this.gamePlayerServiceRepository.save(gamePlayerDao);
		createGamePlayerDto.setId(result.getId());
		return Collections.emptyList();		
	}

	@Override
	public List<ErrorMessage> processDeleteGamePlayer(DeleteGamePlayerDto deleteGamePlayerDto) {
		gamePlayerServiceRepository.deleteGamePlayer(
				deleteGamePlayerDto.getId(),
				deleteGamePlayerDto.getIsactive(),
				deleteGamePlayerDto.getGameId(),
				deleteGamePlayerDto.getModifiedby(),
				deleteGamePlayerDto.getModifiedon());
		return Collections.emptyList();
	}

}
