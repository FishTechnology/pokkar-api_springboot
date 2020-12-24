package com.us.pokkarapi.controllers.game.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.googlecode.jmapper.annotations.JMap;
import com.us.pokkarapi.controllers.gameidentifier.models.GameIdentifierModel;

import lombok.Data;

@Entity
@Data
@Table(name = "games")
public class GameModel extends RepresentationModel<GameModel>  {
	
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
	
	@Column(name = "status")
	@JMap
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "game_Identifier_id", referencedColumnName = "id")
	@JMap
	private GameIdentifierModel gameIdentifier;
	
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
