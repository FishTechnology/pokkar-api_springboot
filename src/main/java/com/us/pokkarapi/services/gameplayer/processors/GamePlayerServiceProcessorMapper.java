/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.processors;

import com.us.pokkarapi.services.gameplayer.datacontracts.daos.GamePlayerDao;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;

/**
 * @author sajansoosaimicheal
 *
 */
public interface GamePlayerServiceProcessorMapper {

	GamePlayerDao mapGamePlayerDao(CreateGamePlayerDto createGamePlayerDto);

}
