/**
 * 
 */
package com.us.pokkarapi.controllers.mappers;

import java.util.List;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;
import com.us.pokkarapi.controllers.gameplayer.models.CreateGamePlayerRequestModel;
import com.us.pokkarapi.controllers.gameplayer.models.CreateGamePlayerResponseModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.DeleteGamePlayerDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface GamePlayerControllerMapper {

	CreateGamePlayerDto mapCreateGamePlayerDto(CreateGamePlayerRequestModel createGamePlayerRequestModel);

	CreateGamePlayerResponseModel mapCreateGamePlayerResponseModel(List<ErrorMessage> result, CreateGamePlayerDto createGamePlayerDto);

	DeleteGamePlayerDto mapDeleteGamePlayerDto(String gameid, String playerid, String userid);

	List<ErrorMessageModel> mapErrorMessageModell(List<ErrorMessage> result, DeleteGamePlayerDto deleteGamePlayerDto);

}
