/**
 * 
 */
package com.us.pokkarapi.services.datacontracts;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */
@Data
public class BaseDto {

	private HttpStatus httpStatus;
}
