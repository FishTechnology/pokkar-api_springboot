/**
 * 
 */
package com.us.pokkarapi.services.userstory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.us.pokkarapi.controllers.userstory.models.UserStoryModel;

/**
 * @author sajansoosaimicheal
 *
 */
@Repository
public interface UserStoryServiceModelRepository  extends JpaRepository<UserStoryModel,Long> {

	List<UserStoryModel> findByGameidAndIsactiveOrderByIdAsc(long gameId, boolean isactive);

	UserStoryModel findByGameidAndIdAndIsactiveOrderByIdAsc(long gmailId, long userStoryId, boolean isactive);

}
