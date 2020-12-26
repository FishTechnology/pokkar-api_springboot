/**
 * 
 */
package com.us.pokkarapi.controllers.userstory.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

/**
 * @author sajansoosaimicheal
 *
 */

@Entity
@Data
@Table(name = "userstory")
public class UserStoryModel extends RepresentationModel<UserStoryModel> {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JMap
    private Long id;
	
	@Column(name = "name")
	@JMap
	private String name;
	
	@Column(name = "userid")
	@JMap
	private Long userid;
	
	@Column(name = "gameid")
	@JMap
	private Long gameid;
	
	@Column(name = "description")
	@JMap
	private String description;
	
	@Column(name = "acceptance_criteria")
	@JMap
	private String acceptanceCriteria;
	
	@Column(name = "createdon")
	@JMap
	private Date createdon;
	
	@Column(name = "createdby")
	@JMap
	private String createdby;
	
	@Column(name = "modifiedon")
	@JMap
	private Date modifiedon;
	
	@Column(name = "modifiedby")
	@JMap
	private String modifiedby;
	
	@Column(name = "isactive")
	@JMap
	private boolean isactive;
	
}
