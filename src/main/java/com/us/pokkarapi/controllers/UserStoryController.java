/**
 * 
 */
package com.us.pokkarapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.us.pokkarapi.controllers.mappers.UserStoryControllerMapper;
import com.us.pokkarapi.controllers.userstory.models.CreateUserStoryRequestModel;
import com.us.pokkarapi.controllers.userstory.models.CreateUserStoryResponseModel;
import com.us.pokkarapi.controllers.userstory.models.UserStoryModel;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.userstory.UserStoryService;

/**
 * @author sajansoosaimicheal
 *
 */
@RestController
@RequestMapping("/api/games")
public class UserStoryController {
	
	@Autowired
	private UserStoryService userStoryService;
	
	@Autowired
	private UserStoryControllerMapper userStoryControllerMapper;
	
	@GetMapping("/{gameid}/userstories")
	public List<UserStoryModel> getUserStoriesByGameId(@PathVariable String gameid) {
		
		List<UserStoryModel> userStories = null;
		try {
			userStories = userStoryService.getUserStoriesByGameId(gameid);
		} catch (UsApplicationException e) {
			
		}	
		
//		for (UserStoryModel userStoryModel : userStories) {
//			userStoryModel
//				.add(linkTo(methodOn(GameController.class).updateGame(null,gameModel.getId().toString()))
//				.withRel("updateGame"));
//			
//			userStoryModel
//				.add(linkTo(methodOn(GameController.class).deleteGame(userid, gameModel.getId().toString()))
//				.withRel(DELETEGAME_API));
//			
//			userStoryModel
//				.add(linkTo(methodOn(GameController.class).createGame(null))
//				.withRel("create"));
//		}
//		
		return userStories;
		
	}
	
	@GetMapping("/{gameid}/{userstoryid}")
	public UserStoryModel getUserStoryByGameId(@PathVariable String gameid , @PathVariable String userstoryid) {
		
		UserStoryModel userStory = null;
		try {
			userStory = userStoryService.getUserStoryById(gameid, userstoryid);
		} catch (UsApplicationException e) {
			
		}	
		
//		for (UserStoryModel userStoryModel : userStories) {
//			userStoryModel
//				.add(linkTo(methodOn(GameController.class).updateGame(null,gameModel.getId().toString()))
//				.withRel("updateGame"));
//			
//			userStoryModel
//				.add(linkTo(methodOn(GameController.class).deleteGame(userid, gameModel.getId().toString()))
//				.withRel(DELETEGAME_API));
//			
//			userStoryModel
//				.add(linkTo(methodOn(GameController.class).createGame(null))
//				.withRel("create"));
//		}
//		
		return userStory;
		
	}

	@PostMapping("/{gameid}/userstories")
	public ResponseEntity<CreateUserStoryResponseModel> createGame(@PathVariable String gameid, @RequestBody CreateUserStoryRequestModel createUserStoryRequestModel) {
		var createUserStoryDto = userStoryControllerMapper.mapCreateUserStoryDto(gameid, createUserStoryRequestModel);
		var result = userStoryService.createUserStory(createUserStoryDto);
		var createUserStoryResponseModel = userStoryControllerMapper.mapCreateUserStoryResponseModel(result, createUserStoryDto);
		if(createUserStoryResponseModel.getErrorMessages() != null && !createUserStoryResponseModel.getErrorMessages().isEmpty()) {
			var httpStatus = createUserStoryDto.getHttpStatus() != null ? createUserStoryDto.getHttpStatus() : HttpStatus.BAD_REQUEST;
			return new ResponseEntity<>(createUserStoryResponseModel, httpStatus);
		}
//		createUserStoryResponseModel
//				.add(linkTo(methodOn(GameController.class).updateGame(null,createUserStoryResponseModel.getId().toString()))
//				.withRel("updateGame"));
//		createUserStoryResponseModel
//				.add(linkTo(methodOn(GameController.class).deleteGame(createUserStoryRequestModel.getUserid().toString(),createUserStoryResponseModel.getId().toString()))
//				.withRel("deleteGame"));
//		createUserStoryResponseModel
//				.add(linkTo(methodOn(GameController.class).getGamesByUserId(createUserStoryRequestModel.getUserid().toString()))
//				.withRel("getGamesByUserId"));
		return new ResponseEntity<>(createUserStoryResponseModel, HttpStatus.CREATED);
	}
}
