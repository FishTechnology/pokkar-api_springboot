package com.us.pokkarapi.controllers.gameplayer.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.googlecode.jmapper.annotations.JMap;
import com.us.pokkarapi.controllers.game.models.GameModel;

import lombok.Data;

@Entity
@Data
@Table(name = "gameplayer")
public class GamePlayerModel extends RepresentationModel<GamePlayerModel> {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JMap
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
	private boolean isactive;
}
