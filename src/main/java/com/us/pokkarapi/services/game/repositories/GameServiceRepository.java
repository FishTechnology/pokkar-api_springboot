/**
 * 
 */
package com.us.pokkarapi.services.game.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.us.pokkarapi.services.game.datacontracts.daos.GameDao;

/**
 * @author sajansoosaimicheal
 *
 */

@Repository
public interface GameServiceRepository extends JpaRepository<GameDao,Long> {
	
	List<GameDao> findByUseridAndStatusNotIn(Long userid, List<String> status);
	
	List<GameDao> findByUseridAndName(Long userid, String name);
	
	List<GameDao> findByUseridAndIdAndStatusNotIn(Long userid, Long id, List<String> status);
	
	@Transactional
	@Modifying()
	@Query("UPDATE GameDao  SET modifiedby = :modifiedby, modifiedon = :modifiedon, status = :status WHERE id = :id and userid = :userid")
	int deleteGameById(
			@Param(value = "id") Long id,
			@Param(value = "userid") Long userid,
			@Param(value = "status") String status, 
			@Param(value = "modifiedby") String modifiedby, 
			@Param(value = "modifiedon") Date modifiedon);

	@Transactional
	@Modifying
	@Query("UPDATE GameDao  SET modifiedby = :modifiedby, modifiedon = :modifiedon, status = :status WHERE id = :id and userid = :userid")
	int updateGameSetStatusForId(
			@Param(value = "id") Long id,
			@Param(value = "userid") Long userid,
			@Param("status") String status, 
			@Param(value = "modifiedby") String modifiedby, 
			@Param(value = "modifiedon") Date modifiedon
			);

	List<GameDao> findByIdAndStatusNotIn(Long id, List<String> status);

}