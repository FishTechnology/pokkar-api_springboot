package com.us.pokkarapi.services.gameplayer.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.us.pokkarapi.services.gameplayer.datacontracts.daos.GamePlayerDao;

@Repository
public interface GamePlayerServiceRepository extends JpaRepository<GamePlayerDao,Long> {

	List<GamePlayerDao> findByIdAndUseridAndIsactive(Long id, Long userid, Boolean isactive);
	
	@Transactional
	@Modifying()
	@Query("UPDATE GamePlayerDao  SET modifiedby = :modifiedby, modifiedon = :modifiedon, isactive = :isactive WHERE id = :id and gameid = :gameid")
	int deleteGamePlayer(
			@Param(value = "id") Long id,
			@Param(value = "isactive") Boolean isactive, 
			@Param(value = "gameid") Long gameid, 
			@Param(value = "modifiedby") String modifiedby, 
			@Param(value = "modifiedon") Date modifiedon);

}
