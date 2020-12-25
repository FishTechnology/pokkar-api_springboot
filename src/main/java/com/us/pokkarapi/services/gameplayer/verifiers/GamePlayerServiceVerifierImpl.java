/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.verifiers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.enums.GameStatus;
import com.us.pokkarapi.services.game.errorcodes.GameServiceErrorCodes;
import com.us.pokkarapi.services.game.repositories.GameServiceRepository;
import com.us.pokkarapi.services.gameplayer.datacontracts.daos.GamePlayerDao;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.DeleteGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.errorcodes.GamePlayerServiceErrorCodes;
import com.us.pokkarapi.services.gameplayer.repositories.GamePlayerServiceRepository;
import com.us.pokkarapi.services.utilities.PokkarServiceUtility;

/**
 * @author sajansoosaimicheal
 *
 */

@Service
public class GamePlayerServiceVerifierImpl implements GamePlayerServiceVerifier {

	@Autowired
	private GameServiceRepository gameServiceRepository;
	
	@Autowired
	private GamePlayerServiceRepository gamePlayerServiceRepository;
	
	@Autowired
	private GameServiceErrorCodes gameServiceErrorCodes;
	
	@Autowired
	private GamePlayerServiceErrorCodes gamePlayerServiceErrorCodes;
	
	@Override
	public List<ErrorMessage> verifyCreateGamePlayer(CreateGamePlayerDto createGamePlayerDto) {
		var result = isGameIdValid(createGamePlayerDto);
		if(!result.isEmpty()) {
			return result;
		}
		
		result = isUserIdValid(createGamePlayerDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		return isGuestIdValid(createGamePlayerDto);
	}

	@Override
	public List<ErrorMessage> isGuestIdValid(CreateGamePlayerDto createGamePlayerDto) {
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> isUserIdValid(CreateGamePlayerDto createGamePlayerDto) {
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> isGameIdValid(CreateGamePlayerDto createGamePlayerDto) {
		var skippedStatus = Arrays.asList(GameStatus.DELETED, GameStatus.COMPLETED);
		var games = gameServiceRepository.findByIdAndStatusNotIn(createGamePlayerDto.getGameId(), skippedStatus);
		 if(games.isEmpty()) {
			return PokkarServiceUtility.getErrorMessages(gameServiceErrorCodes.getGameIdIsNotFoundErrorCode(), "game id is not found");
		 }	
		
		createGamePlayerDto.setGames(games);
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> verifyDeleteGamePlayer(DeleteGamePlayerDto deleteGamePlayerDto) {
		var result = gameIdIsValid(deleteGamePlayerDto);
		if(!result.isEmpty()) {
			return result;
		}
		
		result = userIdIsValid(deleteGamePlayerDto);
		
		if(!result.isEmpty()) {
			return result;
		}
		
		return gamePlayerIdIsValid(deleteGamePlayerDto);
	}

	@Override
	public List<ErrorMessage> gamePlayerIdIsValid(DeleteGamePlayerDto deleteGamePlayerDto) {
		var gamePlayers = gamePlayerServiceRepository.findByIdAndUseridAndIsactive(deleteGamePlayerDto.getId(),deleteGamePlayerDto.getUserid(), true);
		if(gamePlayers.isEmpty()) {
			return PokkarServiceUtility.getErrorMessages(gamePlayerServiceErrorCodes.getGamePlayerIdIsNotFoundErrorCode(), "game player id is not found");
		}
		deleteGamePlayerDto.setGamePlayers(gamePlayers);
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> userIdIsValid(DeleteGamePlayerDto deleteGamePlayerDto) {
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> gameIdIsValid(DeleteGamePlayerDto deleteGamePlayerDto) {
		var skippedStatus = Arrays.asList(GameStatus.DELETED);
		var games = gameServiceRepository.findByIdAndStatusNotIn(deleteGamePlayerDto.getGameId(), skippedStatus);
		if(games.isEmpty()) {
			return PokkarServiceUtility.getErrorMessages(gamePlayerServiceErrorCodes.getGamePlayerIdIsNotFoundErrorCode(), "game player id is not found");
		}
		deleteGamePlayerDto.setGames(games);
		return Collections.emptyList();
	}

}

