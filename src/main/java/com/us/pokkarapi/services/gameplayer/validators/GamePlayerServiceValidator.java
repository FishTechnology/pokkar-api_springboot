/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.validators;

import java.util.List;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.DeleteGamePlayerDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface GamePlayerServiceValidator {

	List<ErrorMessage> validateCreateGamePlayer(CreateGamePlayerDto createGamePlayerDto);

	List<ErrorMessage> createGamePlayerIsValid(CreateGamePlayerDto createGamePlayerDto);

	List<ErrorMessage> isUserIdValid(CreateGamePlayerDto createGamePlayerDto);

	List<ErrorMessage> isGuestIdValid(CreateGamePlayerDto createGamePlayerDto);

	List<ErrorMessage> isGameIdValid(CreateGamePlayerDto createGamePlayerDto);

	List<ErrorMessage> validateDeleteGamePlayer(DeleteGamePlayerDto deleteGamePlayerDto);

	List<ErrorMessage> deleteGamePlayerIsValid(DeleteGamePlayerDto deleteGamePlayerDto);

	List<ErrorMessage> gamePlayerIdIsValid(DeleteGamePlayerDto deleteGamePlayerDto);

	List<ErrorMessage> gameIdIsValid(DeleteGamePlayerDto deleteGamePlayerDto);

	List<ErrorMessage> userIdIsValid(DeleteGamePlayerDto deleteGamePlayerDto);

	List<ErrorMessage> gamePlayerIdIsValid(String gamePlayerId);
}
