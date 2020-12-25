/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.datacontracts.dtos;

import java.util.Date;

import com.googlecode.jmapper.annotations.JMap;
import com.us.pokkarapi.services.datacontracts.BaseDto;
import com.us.pokkarapi.services.game.datacontracts.dtos.GameDto;
import com.us.pokkarapi.services.game.enums.GameStatus;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class GamePlayerDto extends BaseDto  {

	@JMap
	private Long id;
	
	@JMap
	private Long gameId;	
	
	@JMap
	private Long guestid;	
	
	@JMap
	private Long userid;	
	
	@JMap
	private Date createdon;	
	
	@JMap
	private String createdby;	
	
	@JMap
	private Date modifiedon;	
	
	@JMap
	private String modifiedby;
	
	@JMap
	private Boolean isactive;
}
