package com.us.pokkarapi.services.gameplayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.pokkarapi.controllers.gameplayer.models.GamePlayerModel;
import com.us.pokkarapi.services.gameplayer.repositories.GamePlayerServiceRepository;

@Service
public class GamePlayerServiceImpl implements GamePlayerService {

//	@Autowired
//	private GamePlayerServiceRepository gamePlayerServiceRepository;
	
	public List<GamePlayerModel> getGameplayerByGameId(String gameid){
		
		return null;	
	}
}
