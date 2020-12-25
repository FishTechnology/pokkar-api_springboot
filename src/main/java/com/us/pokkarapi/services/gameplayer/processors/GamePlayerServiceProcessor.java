/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.processors;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.DeleteGamePlayerDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface GamePlayerServiceProcessor {

	List<ErrorMessage> processCreateGamePlayer(CreateGamePlayerDto createGamePlayerDto);

	List<ErrorMessage> createGamePlayer(CreateGamePlayerDto createGamePlayerDto);

	List<ErrorMessage> processDeleteGamePlayer(DeleteGamePlayerDto deleteGamePlayerDto);

}
