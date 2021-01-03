/**
 * 
 */
package com.us.pokkarapi.services.storypoint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.us.pokkarapi.services.storypoint.datacontracts.daos.StoryPointDao;

/**
 * @author sajansoosaimicheal
 *
 */

@Repository
public interface StoryPointRepository extends JpaRepository<StoryPointDao,Long> {

}
