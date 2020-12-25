/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.us.pokkarapi.controllers.gameplayer.models.GamePlayerModel;

/**
 * @author sajansoosaimicheal
 *
 */
@Repository
public interface GamePlayerServiceModelRepository extends JpaRepository<GamePlayerModel,Long>{

	List<GamePlayerModel> findByGameidAndIsactiveOrderByIdAsc(long gameId, boolean isactive);

}
