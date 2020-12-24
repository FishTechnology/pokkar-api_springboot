/**
 * 
 */
package com.us.pokkarapi.services.game.errorcodes;

import org.springframework.stereotype.Service;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class GameServiceErrorCodes {
	
	private String createGameDtoIsEmpty = "Pokkar.Api.{0}.{1}.CreateGameRequestModel.IsEmpty";
	
	public String getCreateGameDtoIsEmptyErrorCode() {
		
		return  createGameDtoIsEmpty;
	}

	public String getGameNameIsEmptyErrorCode() {
		
		return "Pokkar.Api.{0}.{1}.Game.Name.IsEmpty";
	}

	public String getGameStatusIsEmptyErrorCode() {		
		
		return "Pokkar.Api.{0}.{1}.Game.Name.IsEmpty";
	}

	public String getGameStatusIsInValidErrorCode() {
		return "Pokkar.Api.{0}.{1}.Game.Status.InValid";
	}

	public String getDuplicateGameNameErrorCode() {
		return "Pokkar.Api.{0}.{1}.Game.Name.Duplicated";
	}

	public String getUpdateGameDtoIsEmptyErrorCode() {
		return "Pokkar.Api.{0}.{1}.UpdateGameRequestModel.IsEmpty";
	}

	public String getUpdateGameIdIsEmptyErrorCode() {
		return "Pokkar.Api.{0}.{1}.Game.Id.IsEmpty";
	}

	public String getUpdateGameIdNotNumberErrorCode() {
		return "Pokkar.Api.{0}.{1}.Game.Id.NotNumber";
	}

	public String getGameIdIsNotFoundErrorCode() {
		return "Pokkar.Api.{0}.{1}.Game.Id.Not.Found";
	}

	public String getDeleteGameDtoIsEmptyErrorCode() {
		return "Pokkar.Api.{0}.{1}.DeleteGameRequestModel.IsEmpty";
	}

	public String getUpdateGameStatusDtoIsEmptyErrorCode() {
		return "Pokkar.Api.{0}.{1}.UpdateGameStatusModel.IsEmpty";
	}

	public String getUpdateGameStatusIsEmptyErrorCode() {
		return "Pokkar.Api.{0}.{1}.Game.Status.IsEmpty";
	}

	public String getUpdateGameStatusIsNotValidErrorCode() {
		return "Pokkar.Api.{0}.{1}.Game.Status.NotValid";
	}

	public String getGameIsCompletedStatusCannotEditErrorCode() {
		return "Pokkar.Api.{0}.{1}.Game.Status.IsCompleted.Not.Editable";
	}
}
