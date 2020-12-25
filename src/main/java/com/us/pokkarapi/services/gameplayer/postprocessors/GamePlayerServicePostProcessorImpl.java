/**
 * 
 */
package com.us.pokkarapi.services.gameplayer.postprocessors;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.us.pokkarapi.services.datacontracts.ErrorMessage;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.CreateGamePlayerDto;
import com.us.pokkarapi.services.gameplayer.datacontracts.dtos.DeleteGamePlayerDto;

/**
 * @author sajansoosaimicheal
 *
 */
@Service
public class GamePlayerServicePostProcessorImpl implements GamePlayerServicePostProcessor {

	@Override
	public List<ErrorMessage> createGamePlayerPostProcessor(CreateGamePlayerDto createGamePlayerDto) {
		return Collections.emptyList();
	}

	@Override
	public void deleteGamePlayerPostProcessor(DeleteGamePlayerDto deleteGamePlayerDto) {
				
	}

}
