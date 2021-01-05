/**
 * 
 */
package com.us.pokkarapi.controllers;

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
import com.us.pokkarapi.controllers.mappers.StoryPointControllerMapper;
import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointRequest;
import com.us.pokkarapi.controllers.storypoint.models.CreateStoryPointResponse;
import com.us.pokkarapi.controllers.storypoint.models.StoryPointModel;
import com.us.pokkarapi.controllers.storypoint.models.UpdateStoryPointRequest;
import com.us.pokkarapi.services.exceptions.UsApplicationException;
import com.us.pokkarapi.services.storypoint.StoryPointService;

/**
 * @author sajansoosaimicheal
 *
 */
@RestController
@RequestMapping("/api/storypoints")
public class StoryPointController {
	
	@Autowired
	private StoryPointService storyPointService;
	
	@Autowired
	private StoryPointControllerMapper storyPointControllerMapper;
	
	@GetMapping()
	public List<StoryPointModel> getStoryPointsByUserId(@RequestParam String userid) 
	{
		try {
			return storyPointService.getStoryPointsByUserId(userid);
		} catch (UsApplicationException e) {
			
		}
		return null;
	}
	
	@PostMapping()
	public ResponseEntity<CreateStoryPointResponse> createStoryPoint(@RequestBody CreateStoryPointRequest createStoryPoint) 
	{	
		var createStoryPointDto = storyPointControllerMapper.mapCreateStoryPointDto(createStoryPoint);
		
		var response =  storyPointService.createStoryPoint(createStoryPointDto);
		
		var createStoryPointResponse = storyPointControllerMapper.mapCreateStoryPointResponse(response,createStoryPointDto);
		
		if(createStoryPointResponse.getErrorMessages() != null && !createStoryPointResponse.getErrorMessages().isEmpty()) {
			var httpStatus = createStoryPointDto.getHttpStatus() != null ? createStoryPointDto.getHttpStatus() : HttpStatus.BAD_REQUEST;
			return new ResponseEntity<>(createStoryPointResponse, httpStatus);
		}
		
		return new ResponseEntity<>(createStoryPointResponse, HttpStatus.CREATED);
	}
	@PutMapping("/{storypointid}")
	public ResponseEntity<List<ErrorMessageModel>> updateStoryPoint(@PathVariable String storyPointId, @RequestBody UpdateStoryPointRequest updateStoryPointRequest) 
	{
		return null;
		
	}
	
	@DeleteMapping("/{storypointid}")
	public ResponseEntity<List<ErrorMessageModel>> deleteStoryPoint(@PathVariable String storypointid, @RequestParam String userid) 
	{
		var deleteStoryPointDto = storyPointControllerMapper.mapDeleteStoryPointDto(storypointid, userid);
		var result = storyPointService.deleteStoryPoint(deleteStoryPointDto);
		var errorMessageModel = storyPointControllerMapper.mapErrorMessageModell(result, deleteStoryPointDto);
		if(errorMessageModel != null && !errorMessageModel.isEmpty()) {
			var httpStatus = deleteStoryPointDto.getHttpStatus() != null ? deleteStoryPointDto.getHttpStatus() : HttpStatus.BAD_REQUEST;
			return new ResponseEntity<>(errorMessageModel, httpStatus);
		}
	
		return new ResponseEntity<>(errorMessageModel, HttpStatus.OK);	
	}
}
