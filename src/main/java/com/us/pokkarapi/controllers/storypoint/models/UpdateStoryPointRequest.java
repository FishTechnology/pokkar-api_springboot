/**
 * 
 */
package com.us.pokkarapi.controllers.storypoint.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.googlecode.jmapper.annotations.JMap;

/**
 * @author sajansoosaimicheal
 *
 */
public class UpdateStoryPointRequest {

	@JMap
	@NotNull(message = "Pokkar.Api.{0}.{1}.StoryPoint.UserId.IsNull")
	@NotEmpty(message = "Pokkar.Api.{0}.{1}.StoryPoint.UserId.IsEmpty")
	@Pattern(message = "Pokkar.Api.{0}.{1}.StoryPoint.UserId.NotNumber",regexp = "[0-9]")
	private String userid;

	@JMap
	@NotNull(message = "Pokkar.Api.{0}.{1}.StoryPoint.Point.IsNull")
	@NotEmpty(message = "Pokkar.Api.{0}.{1}.StoryPoint.Point.IsEmpty")	
	private String point;
}
