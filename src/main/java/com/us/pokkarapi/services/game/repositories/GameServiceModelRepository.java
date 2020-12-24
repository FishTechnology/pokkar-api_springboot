/**
 * 
 */
package com.us.pokkarapi.services.game.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.us.pokkarapi.controllers.game.models.GameModel;

/**
 * @author sajansoosaimicheal
 *
 */
@Repository
public interface GameServiceModelRepository extends JpaRepository<GameModel,Long> {

	List<GameModel> findByUseridAndStatusNotInOrderByIdAsc(long parsedUserId, List<String> status);
}
