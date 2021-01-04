/**
 * 
 */
package com.us.pokkarapi.services.storypoint.datacontracts.dtos;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class CreateStoryPointDto extends StoryPointDto {
	
	@JMap("userid")
	private String rawUserId;
	
	@JMap("point")
	private String rawPoint;

}
