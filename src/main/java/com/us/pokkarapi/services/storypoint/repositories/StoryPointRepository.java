/**
 * 
 */
package com.us.pokkarapi.services.storypoint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.us.pokkarapi.services.storypoint.datacontracts.daos.StoryPointDao;

/**
 * @author sajansoosaimicheal
 *
 */

@Repository
public interface StoryPointRepository extends JpaRepository<StoryPointDao,Long> {

	List<StoryPointDao> findByPointAndUseridAndIsactive(Long point, Long userId, boolean isActive);

}
