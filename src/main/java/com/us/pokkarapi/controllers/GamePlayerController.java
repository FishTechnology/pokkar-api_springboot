package com.us.pokkarapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.us.pokkarapi.controllers.datacontracts.models.ErrorMessageModel;
import com.us.pokkarapi.controllers.gameplayer.models.CreateGamePlayerRequestModel;
import com.us.pokkarapi.controllers.gameplayer.models.CreateGamePlayerResponseModel;
import com.us.pokkarapi.controllers.gameplayer.models.GamePlayerModel;
import com.us.pokkarapi.controllers.mappers.GamePlayerControllerMapper;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.gameplayer.GamePlayerService;


@RestController
@RequestMapping("/api/gameplayer")
public class GamePlayerController {
	
	@Autowired
	private GamePlayerService gamePlayerService;
	
	@Autowired
	private GamePlayerControllerMapper gamePlayerControllerMapper;
	
	@GetMapping("/{gameId}")
	public List<GamePlayerModel> getGamePayersByGameId(@PathVariable String gameId) {
		List<GamePlayerModel> gamePlayersModel = null;
		try {
			gamePlayersModel = gamePlayerService.getGamePlayersByGameId(gameId);
		} catch (UsApplicationException e) {
			
		}	
		
		for (GamePlayerModel gamePlayerModel : gamePlayersModel) {
//			gamePlayerModel
//				.add(linkTo(methodOn(GameController.class).updateGame(null,gamePlayerModel.getId().toString()))
//				.withRel("updateGame"));
//			
//			gamePlayerModel
//				.add(linkTo(methodOn(GameController.class).createGame(null))
//				.withRel("create"));
		}
		
		return gamePlayersModel;		
	}
	
	@PostMapping()
	public ResponseEntity<CreateGamePlayerResponseModel> createGamePlayer(@RequestBody CreateGamePlayerRequestModel createGamePlayerRequestModel) {
		var createGamePlayerDto = gamePlayerControllerMapper.mapCreateGamePlayerDto(createGamePlayerRequestModel);
		var result = gamePlayerService.createGamePlayer(createGamePlayerDto);
		var createGamePlayerResponseModel = gamePlayerControllerMapper.mapCreateGamePlayerResponseModel(result, createGamePlayerDto);
		if(createGamePlayerResponseModel.getErrorMessages() != null && !createGamePlayerResponseModel.getErrorMessages().isEmpty()) {
			var httpStatus = createGamePlayerDto.getHttpStatus() != null ? createGamePlayerDto.getHttpStatus() : HttpStatus.BAD_REQUEST;
			return new ResponseEntity<>(createGamePlayerResponseModel, httpStatus);
		}
//		createGamePlayerResponseModel
//				.add(linkTo(methodOn(GamePlayerController.class).updateGame(null,createGamePlayerResponseModel.getId().toString()))
//				.withRel("updateGame"));
//		createGamePlayerResponseModel
//				.add(linkTo(methodOn(GamePlayerController.class).deleteGame(createGamePlayerRequestModel.getUserid(),createGamePlayerResponseModel.getId().toString()))
//				.withRel("deleteGame"));
//		createGamePlayerResponseModel
//				.add(linkTo(methodOn(GamePlayerController.class).getGamesByUserId(createGamePlayerRequestModel.getUserid()))
//				.withRel("getGamesByUserId"));
		return new ResponseEntity<>(createGamePlayerResponseModel, HttpStatus.CREATED);
	}

	@DeleteMapping("/{gameid}/{playerid}")
	public ResponseEntity<List<ErrorMessageModel>> deleteGamePlayer(
			@PathVariable String playerid, 
			@PathVariable String gameid,
			@RequestParam String userid) {
		var deleteGamePlayerDto = gamePlayerControllerMapper.mapDeleteGamePlayerDto(gameid, playerid, userid);
		var result = gamePlayerService.deleteGamePlayer(deleteGamePlayerDto);
		var errorMessageModel = gamePlayerControllerMapper.mapErrorMessageModell(result, deleteGamePlayerDto);
		if(errorMessageModel != null && !errorMessageModel.isEmpty()) {
			var httpStatus = deleteGamePlayerDto.getHttpStatus() != null ? deleteGamePlayerDto.getHttpStatus() : HttpStatus.BAD_REQUEST;
			return new ResponseEntity<>(errorMessageModel, httpStatus);
		}
	
		return new ResponseEntity<>(errorMessageModel, HttpStatus.OK);	
	} 

}
