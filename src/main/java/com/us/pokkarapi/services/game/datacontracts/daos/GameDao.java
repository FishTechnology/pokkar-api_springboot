/**
 * 
 */
package com.us.pokkarapi.services.game.datacontracts.daos;

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
@Table(name = "games")
public class GameDao {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JMap
    private Long id;
	
	@Column(name = "name")
	@JMap
	private String name;
	
	@Column(name = "userid")
	@JMap
	private Long userid;
	
	@Column(name = "game_Identifier_id")
	@JMap
	private Long gameIdentifierId;
	
	@Column(name = "status")
	@JMap
	private String status;
	
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
	

}
