package com.us.pokkarapi.controllers.mappers;

import java.util.List;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;
import com.us.pokkarapi.controllers.game.models.CreateGameRequestModel;
import com.us.pokkarapi.controllers.game.models.CreateGameResponseModel;
import com.us.pokkarapi.controllers.game.models.GameModel;
import com.us.pokkarapi.controllers.game.models.UpdateGameRequestModel;
import com.us.pokkarapi.controllers.game.models.UpdateGameResponseModel;
import com.us.pokkarapi.controllers.game.models.UpdateGameStatusModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.datacontracts.daos.GameDao;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;

public interface GameControllerMapper {
	
	//List<GameModel> mapGameModel(List<GameDao> gamesDao);

	CreateGameDto mapCreateGameDto(CreateGameRequestModel createGameRequest);

	CreateGameResponseModel mapCreateGameResponseModel(List<ErrorMessage> result, CreateGameDto createGameDto);

	UpdateGameDto mapUpdateGameDto(UpdateGameRequestModel updateGameRequestModel, String gameId);

	UpdateGameResponseModel mapUpdateGameResponseModel(List<ErrorMessage> result, UpdateGameDto updateGameDto);

	DeleteGameDto mapDeleteGameDto(String gameId, String userId);

	List<ErrorMessageModel> mapErrorMessageModell(List<ErrorMessage> result, DeleteGameDto deleteGameDto);

	UpdateGameStatusDto mapUpdateGameStatusDto(String gameid, UpdateGameStatusModel updateGameStatusModel);

	UpdateGameResponseModel mapUpdateGameStatusResponseModel(List<ErrorMessage> result, UpdateGameStatusDto updateGameStatusDto);

}
