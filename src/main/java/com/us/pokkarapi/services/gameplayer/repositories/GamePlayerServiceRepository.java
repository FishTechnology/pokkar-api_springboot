package com.us.pokkarapi.services.gameplayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.us.pokkarapi.services.gameplayer.datacontracts.daos.GamePlayerDao;

@Repository
public interface GamePlayerServiceRepository extends JpaRepository<GamePlayerDao,Long> {

}
