package com.us.pokkarapi.services.game.processors;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;
import com.us.pokkarapi.services.game.enums.GameStatus;
import com.us.pokkarapi.services.game.repositories.GameServiceRepository;
import com.us.pokkarapi.services.gameidentifier.repositories.GameIdentifierRepository;

@Service
public class GameServiceProcessorImpl implements GameServiceProcessor {
	
	@Autowired
	private GameServiceRepository gameServiceRepository;
	
	@Autowired
	private GameIdentifierRepository gameIdentifierRepository;
	
	@Autowired
	private GameServiceProcessorMapperImpl gameServiceProcessorMapper;

	@Override
	public List<ErrorMessage> processCreateGame(CreateGameDto createGameDto) {
		this.createGameIdentifier(createGameDto);
		this.createGame(createGameDto);		
		return Collections.emptyList();
	}
	
	public  List<ErrorMessage> createGameIdentifier(CreateGameDto createGameDto) {
		var gameIdentifiersDao = gameServiceProcessorMapper.mapGameIdentifiersDao(createGameDto);
		var result = this.gameIdentifierRepository.save(gameIdentifiersDao);
		createGameDto.setGameIdentifierId(result.getId());
		return Collections.emptyList();		
	}

	public List<ErrorMessage> createGame(CreateGameDto createGameDto) {
		var gameDto = gameServiceProcessorMapper.mapGameDao(createGameDto);
		var result = gameServiceRepository.save(gameDto);
		createGameDto.setId(result.getId());
		return Collections.emptyList();		
	}

	@Override
	public List<ErrorMessage> processUpdateGame(UpdateGameDto updateGameDto) {
		this.updateGame(updateGameDto);
		return Collections.emptyList();
	}
	
	@Override
	public List<ErrorMessage> updateGame(UpdateGameDto updateGameDto) {
		var gameDto = gameServiceProcessorMapper.mapUpdateGameDao(updateGameDto);
		gameServiceRepository.save(gameDto);
		return Collections.emptyList();	
	}

	@Override
	public List<ErrorMessage> processDeleteGame(DeleteGameDto deleteGameDto) {
		this.deleteGame(deleteGameDto);
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> deleteGame(DeleteGameDto deleteGameDto) {
		this.gameServiceRepository.deleteGameById(
				deleteGameDto.getId(),
				deleteGameDto.getUserid(), 
				deleteGameDto.getStatus(), 
				deleteGameDto.getModifiedby(), 
				deleteGameDto.getModifiedon());
		return Collections.emptyList();	
	}

	@Override
	public List<ErrorMessage> processUpdateGameStatus(UpdateGameStatusDto updateGameStatusDto) {
		this.updateGameStatus(updateGameStatusDto);
		if(updateGameStatusDto.getParsedStatus().getValue() == GameStatus.COMPLETED) {
			this.updateGameIdentifier(updateGameStatusDto);
		}
		
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> updateGameIdentifier(UpdateGameStatusDto updateGameStatusDto) {
		this.gameIdentifierRepository.updateGameIdentifier(
				updateGameStatusDto.getId(), 
				false, 
				updateGameStatusDto.getModifiedby(), 
				updateGameStatusDto.getModifiedon());
		return Collections.emptyList();		
	}

	@Override
	public List<ErrorMessage> updateGameStatus(UpdateGameStatusDto updateGameStatusDto) {
		this.gameServiceRepository.updateGameSetStatusForId(				
				updateGameStatusDto.getId(),
				updateGameStatusDto.getUserid(), 
				updateGameStatusDto.getParsedStatus().getValue(), 
				updateGameStatusDto.getModifiedby(), 
				updateGameStatusDto.getModifiedon()
				);
		return Collections.emptyList();	
	}
}
