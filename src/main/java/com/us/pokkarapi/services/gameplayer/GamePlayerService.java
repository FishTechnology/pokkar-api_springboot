package com.us.pokkarapi.services.gameplayer;

import java.util.List;

import com.us.pokkarapi.controllers.gameplayer.models.GamePlayerModel;

public interface GamePlayerService {
	
	List<GamePlayerModel> getGameplayerByGameId(String gameid);

}
