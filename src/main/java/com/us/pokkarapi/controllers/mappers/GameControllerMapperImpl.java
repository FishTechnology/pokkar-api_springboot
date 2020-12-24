package com.us.pokkarapi.controllers.mappers;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;
import com.us.pokkarapi.controllers.game.models.CreateGameRequestModel;
import com.us.pokkarapi.controllers.game.models.CreateGameResponseModel;
import com.us.pokkarapi.controllers.game.models.UpdateGameRequestModel;
import com.us.pokkarapi.controllers.game.models.UpdateGameResponseModel;
import com.us.pokkarapi.controllers.game.models.UpdateGameStatusModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;
import com.us.pokkarapi.services.utilities.PokkarServiceUtility;

@Service
public class GameControllerMapperImpl implements GameControllerMapper {

	//JMapper<GameModel, GameDao> mapper;
	//JMapper<CreateGameDto, CreateGameRequestModel> createGameDtoMapper;
	
	
	public GameControllerMapperImpl() {
		//mapper = new JMapper<>(GameModel.class,GameDao.class);
		//createGameDtoMapper = new JMapper<>(CreateGameDto.class, CreateGameRequestModel.class);		
	}
	
//	@Override
//	public List<GameModel> mapGameModel(List<GameDao> gamesDao) {
//		if(gamesDao == null || gamesDao.isEmpty())
//		{
//			return new ArrayList<>();
//		}
//
//		List<GameModel> gamesModel = new ArrayList<>();
//		
//		for (GameDao gameDao : gamesDao) {
//			gamesModel.add(mapper.getDestination(gameDao));
//		}
//		
//		return gamesModel;
//	}

	@Override
	public CreateGameDto mapCreateGameDto(CreateGameRequestModel createGameRequest) {
		if(createGameRequest == null) {
			return null;
		}		
		
		CreateGameDto createGameDto= new CreateGameDto();
		createGameDto.setName(createGameRequest.getName());
		createGameDto.setUserid(createGameRequest.getUserid());
		return 	createGameDto;
	}

	@Override
	public CreateGameResponseModel mapCreateGameResponseModel(List<ErrorMessage> result, CreateGameDto createGameDto) {
		var createGameResponseModel = new CreateGameResponseModel();
		
		if(!result.isEmpty()) 
		{
			createGameResponseModel.setErrorMessages(PokkarServiceUtility.getErrorMessageModel(result));
			return createGameResponseModel;
		}
		
		createGameResponseModel.setId(createGameDto.getId());
		
		return createGameResponseModel;
	}

	@Override
	public UpdateGameDto mapUpdateGameDto(UpdateGameRequestModel updateGameRequestModel, String gameId) {
		if(updateGameRequestModel == null) {
			return null;
		}		
		
		UpdateGameDto updateGameDto= new UpdateGameDto();
		updateGameDto.setName(updateGameRequestModel.getName());
		updateGameDto.setUserid(updateGameRequestModel.getUserid());
		updateGameDto.setRawGameId(gameId);
		return 	updateGameDto;
	}

	@Override
	public UpdateGameResponseModel mapUpdateGameResponseModel(List<ErrorMessage> result, UpdateGameDto updateGameDto) {
		var updateGameResponseModel = new UpdateGameResponseModel();
		
		if(!result.isEmpty()) 
		{
			updateGameResponseModel.setErrorMessages(PokkarServiceUtility.getErrorMessageModel(result));
			return updateGameResponseModel;
		}
		
		return updateGameResponseModel;
	}

	@Override
	public DeleteGameDto mapDeleteGameDto(String gameId, String userId) {
		var deleteGameDto = new DeleteGameDto();
		deleteGameDto.setRawGameId(gameId);
		deleteGameDto.setRawUserId(userId);
		return deleteGameDto;
	}

	@Override
	public List<ErrorMessageModel> mapErrorMessageModell(List<ErrorMessage> result, DeleteGameDto deleteGameDto) {
		if(!result.isEmpty()) 
		{
			return PokkarServiceUtility.getErrorMessageModel(result);	
		}
		
		return Collections.emptyList();
	}

	@Override
	public UpdateGameStatusDto mapUpdateGameStatusDto(String gameid, UpdateGameStatusModel updateGameStatusModel) {
		
		if(updateGameStatusModel == null) {
			return null;
		}		
		
		
		UpdateGameStatusDto updateGameStatusDto= new UpdateGameStatusDto();
		updateGameStatusDto.setRawGameId(gameid);
		updateGameStatusDto.setRawUserId(updateGameStatusModel.getUserid());
		updateGameStatusDto.setStatus(updateGameStatusModel.getStatus());
		return 	updateGameStatusDto;
	}

	@Override
	public UpdateGameResponseModel mapUpdateGameStatusResponseModel(List<ErrorMessage> result,
			UpdateGameStatusDto updateGameStatusDto) {
		var updateGameResponseModel = new UpdateGameResponseModel();
		
		if(!result.isEmpty()) 
		{
			updateGameResponseModel.setErrorMessages(PokkarServiceUtility.getErrorMessageModel(result));
			return updateGameResponseModel;
		}
		
		return updateGameResponseModel;
	}

}
