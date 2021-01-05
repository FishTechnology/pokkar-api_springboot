/**
 * 
 */
package com.us.pokkarapi.services.storypoint.datacontracts.dtos;

import java.util.Date;

import com.googlecode.jmapper.annotations.JMap;
import com.us.pokkarapi.services.datacontracts.BaseDto;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */

@Data
public class StoryPointDto extends BaseDto {

    private Long id;	
	

	private Long userid;	


	private Long point;	
	

	private Date createdon;	
	

	private String createdby;	
	

	private Date modifiedon;	
	

	private String modifiedby;	
	

	private Boolean isactive;
}
