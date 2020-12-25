package com.us.pokkarapi.services.gameplayer;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.controllers.gameplayer.models.GamePlayerModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.game.enums.GameStatus;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.DeleteGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.postprocessors.GamePlayerServicePostProcessor;
import com.us.pokkarapi.services.gameplayer.processors.GamePlayerServiceProcessor;
import com.us.pokkarapi.services.gameplayer.repositories.GamePlayerServiceModelRepository;
import com.us.pokkarapi.services.gameplayer.validators.GamePlayerServiceValidator;
import com.us.pokkarapi.services.gameplayer.verifiers.GamePlayerServiceVerifier;

@Service
public class GamePlayerServiceImpl implements GamePlayerService {

	@Autowired
	private GamePlayerServiceModelRepository gamePlayerServiceModelRepository;
	
	@Autowired
	private GamePlayerServiceValidator gamePlayerServiceValidator;
	
	@Autowired
	private GamePlayerServiceVerifier gamePlayerServiceVerifier;
	
	@Autowired
	private GamePlayerServiceProcessor gamePlayerServiceProcessor;
	
	@Autowired
	private GamePlayerServicePostProcessor gamePlayerServicePostProcessor;
	
	
	public List<GamePlayerModel> getGamePlayersByGameId(String gameid) throws UsApplicationException {
		
		if(!StringUtils.isNumeric(gameid)) {
			throw new UsApplicationException("game id is not in number format","");
		}
		
		var parsedGameId = Long.parseLong(gameid);

		
		return gamePlayerServiceModelRepository.findByGameidAndIsactiveOrderByIdAsc(parsedGameId, true);
	}

	@Override
	public List<ErrorMessage> createGamePlayer(CreateGamePlayerDto createGamePlayerDto) {
		if(createGamePlayerDto != null) {
			var currentDate = new Date();
			createGamePlayerDto.setCreatedon(currentDate);
			createGamePlayerDto.setModifiedon(currentDate);
			createGamePlayerDto.setCreatedby(createGamePlayerDto.getRawUserId());
			createGamePlayerDto.setModifiedby(createGamePlayerDto.getRawUserId());
			createGamePlayerDto.setIsactive(true);
		}
		
		var result = gamePlayerServiceValidator.validateCreateGamePlayer(createGamePlayerDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gamePlayerServiceVerifier.verifyCreateGamePlayer(createGamePlayerDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gamePlayerServiceProcessor.processCreateGamePlayer(createGamePlayerDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gamePlayerServicePostProcessor.createGamePlayerPostProcessor(createGamePlayerDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		return result;	
	}

	@Override
	public List<ErrorMessage> deleteGamePlayer(DeleteGamePlayerDto deleteGamePlayerDto) {
		if(deleteGamePlayerDto != null) {
			var currentDate = new Date();
			deleteGamePlayerDto.setModifiedby(deleteGamePlayerDto.getRawUserId());
			deleteGamePlayerDto.setModifiedon(currentDate);	
			deleteGamePlayerDto.setIsactive(false);
		}
		
		var result = gamePlayerServiceValidator.validateDeleteGamePlayer(deleteGamePlayerDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gamePlayerServiceVerifier.verifyDeleteGamePlayer(deleteGamePlayerDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		result = gamePlayerServiceProcessor.processDeleteGamePlayer(deleteGamePlayerDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		gamePlayerServicePostProcessor.deleteGamePlayerPostProcessor(deleteGamePlayerDto);
		
		
		return result;
	}
}
