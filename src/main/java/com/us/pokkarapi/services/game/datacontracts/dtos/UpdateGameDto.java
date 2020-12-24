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
public class UpdateGameDto extends GameDto {

	private String rawGameId;
}
