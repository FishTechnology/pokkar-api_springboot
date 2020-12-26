/**
 * 
 */
package com.us.pokkarapi.services.userstory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.us.pokkarapi.services.userstory.datacontracts.daos.UserStoryDao;

/**
 * @author sajansoosaimicheal
 *
 */
public interface UserStoryServiceRepository extends JpaRepository<UserStoryDao,Long>{

}
