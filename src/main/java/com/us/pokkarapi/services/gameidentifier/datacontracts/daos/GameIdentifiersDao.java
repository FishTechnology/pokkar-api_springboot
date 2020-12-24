/**
 * 
 */
package com.us.pokkarapi.services.gameidentifier.datacontracts.daos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */

@Entity
@Data
@Table(name = "gameidentifiers")
public class GameIdentifiersDao {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JMap
    private Long id;	
	
	@Column(name = "identifier")
	@JMap
	private String identifier;
	
	@Column(name = "createdon")
	@JMap
	private Date createdon;
	
	@Column(name = "createdby")
	@JMap
	private String createdby;
	
	@Column(name = "modifiedon")
	@JMap
	private Date modifiedon;
	
	@Column(name = "modifiedby")
	@JMap
	private String modifiedby;
	
	@Column(name = "isactive")
	@JMap
	private Boolean isactive;
}
