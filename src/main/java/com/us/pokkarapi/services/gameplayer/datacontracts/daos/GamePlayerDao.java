package com.us.pokkarapi.services.gameplayer.datacontracts.daos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

@Entity
@Data
@Table(name = "gameplayer")
public class GamePlayerDao {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "gameid")
	@JMap
	private Long gameid;
	
	@Column(name = "userid")
	@JMap
	private Long userid;
	
	@Column(name = "guestid")
	@JMap
	private Long guestid;	
	
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
