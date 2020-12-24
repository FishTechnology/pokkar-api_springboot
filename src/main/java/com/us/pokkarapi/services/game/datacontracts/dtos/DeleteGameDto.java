/**
 * 
 */
package com.us.pokkarapi.services.game.datacontracts.dtos;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class DeleteGameDto extends GameDto {
	private String rawGameId;
	private String rawUserId;
}
