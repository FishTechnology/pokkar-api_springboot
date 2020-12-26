package com.us.pokkarapi.services.game.postprocessors;

import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;

public interface GameServicePostProcessor {

	void createGamePostProcessor(CreateGameDto createGameDto);

	void updateGamePostProcessor(UpdateGameDto updateGameDto);

	void deleteGamePostProcessor(DeleteGameDto deleteGameDto);

	void updateUpdateGameStatusPostProcessor(UpdateGameStatusDto updateGameStatusDto);

}
