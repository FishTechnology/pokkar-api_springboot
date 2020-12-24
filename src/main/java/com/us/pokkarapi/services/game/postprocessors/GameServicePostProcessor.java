package com.us.pokkarapi.services.game.postprocessors;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.game.datacontracts.dtos.CreateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.DeleteGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.UpdateGameStatusDto;

public interface GameServicePostProcessor {

	List<ErrorMessage> createGamePostProcessor(CreateGameDto createGameDto);

	List<ErrorMessage> updateGamePostProcessor(UpdateGameDto updateGameDto);

	List<ErrorMessage> deleteGamePostProcessor(DeleteGameDto deleteGameDto);

	List<ErrorMessage> updateUpdateGameStatusPostProcessor(UpdateGameStatusDto updateGameStatusDto);

}
