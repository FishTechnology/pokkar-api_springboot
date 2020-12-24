/**
 * 
 */
package com.us.pokkarapi.services.gameidentifier.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.us.pokkarapi.services.gameidentifier.datacontracts.daos.GameIdentifiersDao;

/**
 * @author sajansoosaimicheal
 *
 */

@Repository
public interface GameIdentifierRepository extends JpaRepository<GameIdentifiersDao,Long> {

	@Transactional
	@Modifying
	@Query("UPDATE GameIdentifiersDao  SET modifiedby = :modifiedby, modifiedon = :modifiedon, isactive = :isactive WHERE gameid = :gameid")
	int updateGameIdentifier(
			@Param(value = "gameid") Long gameid,
			@Param(value = "isactive") Boolean isactive, 
			@Param(value = "modifiedby") String modifiedby, 
			@Param(value = "modifiedon") Date modifiedon); 
}
