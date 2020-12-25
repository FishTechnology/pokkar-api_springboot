/**
 * 
 */
package com.us.pokkarapi.controllers.mappers;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;
import com.us.pokkarapi.controllers.game.models.CreateGameResponseModel;
import com.us.pokkarapi.controllers.gameplayer.models.CreateGamePlayerRequestModel;
import com.us.pokkarapi.controllers.gameplayer.models.CreateGamePlayerResponseModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.DeleteGamePlayerDto;
import com.us.pokkarapi.services.utilities.PokkarServiceUtility;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class GamePlayerControllerMapperImpl implements GamePlayerControllerMapper {

	@Override
	public CreateGamePlayerDto mapCreateGamePlayerDto(CreateGamePlayerRequestModel createGamePlayerRequestModel) {
		var createGamePlayerDto = new CreateGamePlayerDto();
		createGamePlayerDto.setRawUserId(createGamePlayerRequestModel.getUserid());
		createGamePlayerDto.setRawGuestId(createGamePlayerRequestModel.getGuestid());
		createGamePlayerDto.setRawGameId(createGamePlayerRequestModel.getGameid());
		return createGamePlayerDto;
	}

	@Override
	public CreateGamePlayerResponseModel mapCreateGamePlayerResponseModel(List<ErrorMessage> result,
			CreateGamePlayerDto createGamePlayerDto) {
		
		var createGamePlayerResponseModel = new CreateGamePlayerResponseModel();
		
		if(!result.isEmpty()) 
		{
			createGamePlayerResponseModel.setErrorMessages(PokkarServiceUtility.getErrorMessageModel(result));
			return createGamePlayerResponseModel;
		}
		
		createGamePlayerResponseModel.setId(createGamePlayerDto.getId());
		
		return createGamePlayerResponseModel;
	}

	@Override
	public DeleteGamePlayerDto mapDeleteGamePlayerDto(String gameid, String playerid, String userid) {
		var deleteGamePlayerDto = new DeleteGamePlayerDto();
		deleteGamePlayerDto.setRawGameId(gameid);
		deleteGamePlayerDto.setRawGamePlayerId(playerid);
		deleteGamePlayerDto.setRawUserId(userid);
		return deleteGamePlayerDto;
	}

	@Override
	public List<ErrorMessageModel> mapErrorMessageModell(List<ErrorMessage> result, DeleteGamePlayerDto deleteGamePlayerDto) {
		if(!result.isEmpty()) 
		{
			return PokkarServiceUtility.getErrorMessageModel(result);	
		}
		
		return Collections.emptyList();
	}

}
