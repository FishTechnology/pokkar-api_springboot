package com.us.pokkarapi.services.gameplayer.datacontracts.daos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "gameplayers")
public class GamePlayerDao {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
