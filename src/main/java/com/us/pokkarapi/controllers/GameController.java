/**
 * 
 */
package com.us.pokkarapi.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;
import com.us.pokkarapi.controllers.game.models.CreateGameRequestModel;
import com.us.pokkarapi.controllers.game.models.CreateGameResponseModel;
import com.us.pokkarapi.controllers.game.models.GameModel;
import com.us.pokkarapi.controllers.game.models.UpdateGameRequestModel;
import com.us.pokkarapi.controllers.game.models.UpdateGameResponseModel;
import com.us.pokkarapi.controllers.game.models.UpdateGameStatusModel;
import com.us.pokkarapi.controllers.mappers.GameControllerMapper;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.game.GameService;


/**
 * @author sajansoosaimicheal
 *
 */

@RestController
@RequestMapping("/api/game")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameControllerMapper gameControllerMapper;
	
	private static final String DELETEGAME_API = "deleteGame";
	
	@GetMapping()
	public List<GameModel> getGamesByUserId(@RequestParam String userid) {
		List<GameModel> gamesModel = null;
		try {
			gamesModel = gameService.getGamesByUserId(userid);
		} catch (UsApplicationException e) {
			
		}	
		
		for (GameModel gameModel : gamesModel) {
			gameModel
				.add(linkTo(methodOn(GameController.class).updateGame(null,gameModel.getId().toString()))
				.withRel("updateGame"));
			
			gameModel
				.add(linkTo(methodOn(GameController.class).deleteGame(userid, gameModel.getId().toString()))
				.withRel(DELETEGAME_API));
			
			gameModel
				.add(linkTo(methodOn(GameController.class).createGame(null))
				.withRel("create"));
		}
		
		return gamesModel;
	}
	
	@PostMapping()
	public ResponseEntity<CreateGameResponseModel> createGame(@RequestBody CreateGameRequestModel createGameRequest) {
		var createGameDto = gameControllerMapper.mapCreateGameDto(createGameRequest);
		var result = gameService.createGame(createGameDto);
		var createGameResponseModel = gameControllerMapper.mapCreateGameResponseModel(result, createGameDto);
		if(createGameResponseModel.getErrorMessages() != null && !createGameResponseModel.getErrorMessages().isEmpty()) {
			var httpStatus = createGameDto.getHttpStatus() != null ? createGameDto.getHttpStatus() : HttpStatus.BAD_REQUEST;
			return new ResponseEntity<>(createGameResponseModel, httpStatus);
		}
		createGameResponseModel
				.add(linkTo(methodOn(GameController.class).updateGame(null,createGameResponseModel.getId().toString()))
				.withRel("updateGame"));
		createGameResponseModel
				.add(linkTo(methodOn(GameController.class).deleteGame(createGameRequest.getUserid().toString(),createGameResponseModel.getId().toString()))
				.withRel("deleteGame"));
		createGameResponseModel
				.add(linkTo(methodOn(GameController.class).getGamesByUserId(createGameRequest.getUserid().toString()))
				.withRel("getGamesByUserId"));
		return new ResponseEntity<>(createGameResponseModel, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<UpdateGameResponseModel> updateGame(@RequestBody UpdateGameRequestModel updateGameRequestModel,@RequestParam String gameId) {
		var updateGameDto = gameControllerMapper.mapUpdateGameDto(updateGameRequestModel, gameId);
		var result = gameService.updateGame(updateGameDto);
		var updateGameResponseModel = gameControllerMapper.mapUpdateGameResponseModel(result, updateGameDto);
		if(updateGameResponseModel.getErrorMessages() != null && !updateGameResponseModel.getErrorMessages().isEmpty()) {
			var httpStatus = updateGameDto.getHttpStatus() != null ? updateGameDto.getHttpStatus() : HttpStatus.BAD_REQUEST;
			return new ResponseEntity<>(updateGameResponseModel, httpStatus);
		}
		
		updateGameResponseModel
			.add(linkTo(methodOn(GameController.class).getGamesByUserId(updateGameRequestModel.getUserid().toString()))
			.withRel("getGamesByUserId"));
		
		updateGameResponseModel
			.add(linkTo(methodOn(GameController.class).deleteGame(updateGameRequestModel.getUserid().toString(), gameId))
			.withRel("deleteGame"));
		
		updateGameResponseModel
			.add(linkTo(methodOn(GameController.class).createGame(null))
			.withRel("createGame"));
		
		return new ResponseEntity<>(updateGameResponseModel, HttpStatus.OK);
	}
	
	@DeleteMapping()
	public ResponseEntity<List<ErrorMessageModel>> deleteGame(@RequestParam String userid,@RequestParam String gameid) {
		var deleteGameDto = gameControllerMapper.mapDeleteGameDto(gameid, userid);
		var result = gameService.deleteGame(deleteGameDto);
		var errorMessageModel = gameControllerMapper.mapErrorMessageModell(result, deleteGameDto);
		if(errorMessageModel != null && !errorMessageModel.isEmpty()) {
			var httpStatus = deleteGameDto.getHttpStatus() != null ? deleteGameDto.getHttpStatus() : HttpStatus.BAD_REQUEST;
			return new ResponseEntity<>(errorMessageModel, httpStatus);
		}
	
		return new ResponseEntity<>(errorMessageModel, HttpStatus.OK);	
	}

	@PutMapping("/{gameid}")
	public ResponseEntity<UpdateGameResponseModel> updateGameStatus(@PathVariable String gameid, @RequestBody UpdateGameStatusModel updateGameStatusModel) {
		var updateGameStatusDto = gameControllerMapper.mapUpdateGameStatusDto(gameid, updateGameStatusModel);
		var result = gameService.updateGameStatus(updateGameStatusDto);
		var updateGameResponseModel = gameControllerMapper.mapUpdateGameStatusResponseModel(result, updateGameStatusDto);
		if(updateGameResponseModel.getErrorMessages() != null && !updateGameResponseModel.getErrorMessages().isEmpty()) {
			var httpStatus = updateGameStatusDto.getHttpStatus() != null ? updateGameStatusDto.getHttpStatus() : HttpStatus.BAD_REQUEST;
			return new ResponseEntity<>(updateGameResponseModel, httpStatus);
		}	
		
		return new ResponseEntity<>(updateGameResponseModel, HttpStatus.OK);
	}
}


