/**
 * 
 */
package com.us.pokkarapi.services.errorcodes;

import org.springframework.stereotype.Service;

/**
 * @author sajansoosaimicheal
 *
 */

@Service
public class GamePlayerServiceErrorCodes {

	public String getCreateGamePlayerDtoIsEmptyErrorCode() {
		return "Pokkar.Api.{0}.{1}.CreateGamePlayerRequestModel.IsEmpty";
	}

	public String getDeleteGamePlayerDtoIsEmptyErrorCode() {
		return "Pokkar.Api.{0}.{1}.DeleteGamePlayerDto.IsEmpty";
	}

	public String getGamePlayerIdIsEmptyErrorCode() {
		return "Pokkar.Api.{0}.{1}.GamePlayer.Id.IsEmpty";
	}

	public String getGamePlayerIdNotNumberErrorCode() {
		return "Pokkar.Api.{0}.{1}.GamePlayer.Id.NotNumber";
	}

	public String getGamePlayerIdIsNotFoundErrorCode() {
		return "Pokkar.Api.{0}.{1}.GamePlayer.Id.NotFound";
	}

}
