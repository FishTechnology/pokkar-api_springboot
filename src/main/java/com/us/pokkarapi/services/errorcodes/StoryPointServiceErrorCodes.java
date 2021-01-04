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
public class StoryPointServiceErrorCodes {

	public String getDuplicateStoryPointErrorCode() {
		return "Pokkar.Api.{0}.{1}.StoryPoint.Point.Duplicated";
	}

}
