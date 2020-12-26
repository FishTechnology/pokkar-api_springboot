/**
 * 
 */
package com.us.pokkarapi.services.userstory.datacontracts.dtos;

import java.util.Date;

import com.googlecode.jmapper.annotations.JMap;
import com.us.pokkarapi.services.datacontracts.BaseDto;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class UserStoryDto extends BaseDto  {

	@JMap
	private Long id;
	
	@JMap
	private String name;
	
	@JMap
	private String description;
	
	@JMap
	private String acceptanceCriteria;
	
	@JMap
	private Long gameId;	
	
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
	private Boolean isActive;
}
