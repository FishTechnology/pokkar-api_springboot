package com.us.pokkarapi.services.game.postprocessors;

import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;

@Service
public class GameServicePostProcessorImpl implements GameServicePostProcessor {

	@Override
	public void createGamePostProcessor(CreateGameDto createGameDto) {

	}

	@Override
	public void updateGamePostProcessor(UpdateGameDto updateGameDto) {

	}

	@Override
	public void deleteGamePostProcessor(DeleteGameDto deleteGameDto) {

	}

	@Override
	public void updateUpdateGameStatusPostProcessor(UpdateGameStatusDto updateGameStatusDto) {
		
	}

}
