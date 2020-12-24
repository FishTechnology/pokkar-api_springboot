/**
 * 
 */
package com.us.pokkarapi.services.game.datacontracts.dtos;

import java.util.Date;

import com.googlecode.jmapper.annotations.JMap;
import com.us.pokkarapi.services.datacontracts.BaseDto;
import com.us.pokkarapi.services.game.enums.GameStatus;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class GameDto extends BaseDto {

	@JMap
	private Long id;		
	
	@JMap
	private String name;	
	
	@JMap
	private Long userid;	
	
	private String status;	

	private GameStatus parsedStatus;	
	
	@JMap
	private Long gameIdentifierId;
	
	@JMap
	private Date createdon;	
	
	@JMap
	private String createdby;	
	
	@JMap
	private Date modifiedon;	
	
	@JMap
	private String modifiedby;
}
