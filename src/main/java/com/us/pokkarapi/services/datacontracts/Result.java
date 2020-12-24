package com.us.pokkarapi.services.datacontracts;

import java.util.List;

import lombok.Data;

@Data
public class Result {
	
	private Long id;
	
	private List<ErrorMessage> messages;

}
