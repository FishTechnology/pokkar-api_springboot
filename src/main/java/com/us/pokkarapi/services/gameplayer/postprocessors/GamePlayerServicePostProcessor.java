/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.postprocessors;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.DeleteGamePlayerDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface GamePlayerServicePostProcessor {

	List<ErrorMessage> createGamePlayerPostProcessor(CreateGamePlayerDto createGamePlayerDto);

	void deleteGamePlayerPostProcessor(DeleteGamePlayerDto deleteGamePlayerDto);

}
