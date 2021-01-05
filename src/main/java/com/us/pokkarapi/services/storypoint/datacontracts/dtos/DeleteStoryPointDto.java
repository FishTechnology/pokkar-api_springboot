/**
 * 
 */
package com.us.pokkarapi.services.storypoint.datacontracts.dtos;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class DeleteStoryPointDto extends StoryPointDto {

	private String rawUserId;

	private String rawStoryPointId;
}
