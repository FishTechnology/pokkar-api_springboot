package com.us.pokkarapi.services.game.postprocessors;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;

@Service
public class GameServicePostProcessorImpl implements GameServicePostProcessor {

	@Override
	public List<ErrorMessage> createGamePostProcessor(CreateGameDto createGameDto) {
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> updateGamePostProcessor(UpdateGameDto updateGameDto) {
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> deleteGamePostProcessor(DeleteGameDto deleteGameDto) {
		return Collections.emptyList();
	}

	@Override
	public List<ErrorMessage> updateUpdateGameStatusPostProcessor(UpdateGameStatusDto updateGameStatusDto) {
		return Collections.emptyList();
	}

}
