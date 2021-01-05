/**
 * 
 */
package com.us.pokkarapi.services.storypoint.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.us.pokkarapi.services.storypoint.datacontracts.daos.StoryPointDao;

/**
 * @author sajansoosaimicheal
 *
 */

@Repository
public interface StoryPointRepository extends JpaRepository<StoryPointDao,Long> {

	List<StoryPointDao> findByPointAndUseridAndIsactive(Long point, Long userId, boolean isActive);

	@Transactional
	@Modifying()
	@Query("UPDATE StoryPointDao  SET modifiedby = :modifiedby, modifiedon = :modifiedon, isactive = :isactive WHERE id = :id")
	int deleteStoryPoint(
			@Param(value = "id") Long id,
			@Param(value = "isactive") Boolean isactive, 
			@Param(value = "modifiedby") String modifiedby, 
			@Param(value = "modifiedon") Date modifiedon);

}
