package com.us.pokkarapi.services.gameplayer;

import java.util.List;

import com.us.pokkarapi.controllers.gameplayer.models.GamePlayerModel;
import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.DeleteGamePlayerDto;

public interface GamePlayerService {
	
	List<GamePlayerModel> getGamePlayersByGameId(String gameid) throws UsApplicationException;

	List<ErrorMessage> createGamePlayer(CreateGamePlayerDto createGamePlayerDto);

	List<ErrorMessage> deleteGamePlayer(DeleteGamePlayerDto deleteGamePlayerDto);

}
