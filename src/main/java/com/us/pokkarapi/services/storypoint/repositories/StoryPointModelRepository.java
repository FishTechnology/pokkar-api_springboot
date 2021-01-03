/**
 * 
 */
package com.us.pokkarapi.services.storypoint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.us.pokkarapi.controllers.storypoint.models.StoryPointModel;

/**
 * @author sajansoosaimicheal
 *
 */
@Repository
public interface StoryPointModelRepository extends JpaRepository<StoryPointModel,Long> {

	List<StoryPointModel> findByUseridAndIsactive(long userId, boolean isActive);

}
