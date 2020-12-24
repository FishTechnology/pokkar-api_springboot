package com.us.pokkarapi.controllers.gameplayer.models;

import java.util.Date;

import lombok.Data;

@Data
public class GamePlayerModel {

    private Long id;
	
	private String name;
	
	private Long userid;
	
	private Date createdon;
	
	private String createdby;
	
	private Date modifiedon;
	
	private String modifiedby;
	
	private String status;
}
