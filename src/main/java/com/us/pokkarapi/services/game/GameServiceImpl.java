/**
 * 
 */
package com.us.pokkarapi.services.game;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.controllers.game.models.GameModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;
import com.us.pokkarapi.services.game.enums.GameStatus;
import com.us.pokkarapi.services.game.mappers.GameServiceMapper;
import com.us.pokkarapi.services.game.postprocessors.GameServicePostProcessor;
import com.us.pokkarapi.services.game.processors.GameServiceProcessor;
import com.us.pokkarapi.services.game.repositories.GameServiceModelRepository;
import com.us.pokkarapi.services.game.repositories.GameServiceRepository;
import com.us.pokkarapi.services.game.validators.GameServiceValidator;
import com.us.pokkarapi.services.game.verifiers.GameServiceVerifier;

/**
 * @author sajansoosaimicheal
 *
 */

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameServiceRepository gameServiceRepository;
	
	@Autowired
	private GameServiceValidator gameServiceValidator;
	
	@Autowired
	private GameServiceVerifier gameServiceVerifier;
	
	@Autowired
	private GameServiceProcessor gameServiceProcessor;
	
	@Autowired
	private GameServicePostProcessor gameServicePostProcessor;
	
	@Autowired
	private GameServiceMapper gameServiceMapper;
	
	@Autowired
	private GameServiceModelRepository gameServiceModelRepository;
	

	@Override
	public List<GameModel> getGamesByUserId(String userid) throws UsApplicationException {
		
		if(!StringUtils.isNumeric(userid)) {
			throw new UsApplicationException("user id is not in number format","");
		}
		
		var parsedUserId = Long.parseLong(userid);
		List<String> status = new ArrayList<>();
		status.add("DELETED");
		
		return gameServiceModelRepository.findByUseridAndStatusNotInOrderByIdAsc(parsedUserId, status);
	}
	
	@Override
	public List<ErrorMessage> createGame(CreateGameDto createGameDto) {
		
		if(createGameDto != null) {
			var currentDate = new Date();
			createGameDto.setCreatedon(currentDate);
			createGameDto.setModifiedon(currentDate);
			createGameDto.setCreatedby(createGameDto.getUserid().toString());
			createGameDto.setModifiedby(createGameDto.getUserid().toString());
			createGameDto.setStatus(GameStatus.CREATED);
		}
		
		var result = gameServiceValidator.validateCreateGame(createGameDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gameServiceVerifier.verifyCreateGame(createGameDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gameServiceProcessor.processCreateGame(createGameDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gameServicePostProcessor.createGamePostProcessor(createGameDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		return result;	
	}

	@Override
	public List<ErrorMessage> updateGame(UpdateGameDto updateGameDto) {
		if(updateGameDto != null) {
			var currentDate = new Date();
			updateGameDto.setCreatedon(currentDate);
			updateGameDto.setModifiedon(currentDate);
			updateGameDto.setCreatedby(updateGameDto.getUserid().toString());
			updateGameDto.setModifiedby(updateGameDto.getUserid().toString());
		}
		
		var result = gameServiceValidator.validateUpdateGame(updateGameDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gameServiceVerifier.verifyUpdateGame(updateGameDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gameServiceProcessor.processUpdateGame(updateGameDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		gameServicePostProcessor.updateGamePostProcessor(updateGameDto);

		return result;	
	}

	@Override
	public List<ErrorMessage> deleteGame(DeleteGameDto deleteGameDto) {
		if(deleteGameDto != null) {
			var currentDate = new Date();
			deleteGameDto.setModifiedby(deleteGameDto.getRawUserId());
			deleteGameDto.setModifiedon(currentDate);	
			deleteGameDto.setStatus(GameStatus.DELETED);
		}
		
		var result = gameServiceValidator.validateDeleteGame(deleteGameDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gameServiceVerifier.verifyDeleteGame(deleteGameDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gameServiceProcessor.processDeleteGame(deleteGameDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		gameServicePostProcessor.deleteGamePostProcessor(deleteGameDto);
		
		return result;
	}

	@Override
	public List<ErrorMessage> updateGameStatus(UpdateGameStatusDto updateGameStatusDto) {
		
		if(updateGameStatusDto != null) {
			var currentDate = new Date();
			updateGameStatusDto.setCreatedon(currentDate);
			updateGameStatusDto.setModifiedon(currentDate);
			updateGameStatusDto.setCreatedby(updateGameStatusDto.getRawUserId());
			updateGameStatusDto.setModifiedby(updateGameStatusDto.getRawUserId());
		}
		
		var result = gameServiceValidator.validateUpdateGameStatus(updateGameStatusDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gameServiceVerifier.verifyUpdateGameStatus(updateGameStatusDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gameServiceProcessor.processUpdateGameStatus(updateGameStatusDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		gameServicePostProcessor.updateUpdateGameStatusPostProcessor(updateGameStatusDto);
		
		return result;
	}

}

