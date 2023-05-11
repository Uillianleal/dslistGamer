package com.devsuperior.dslistGamer.dto;

import org.springframework.beans.BeanUtils;

import com.devsuperior.dslistGamer.entities.GameList;

public class GameListDTO {

	private Long id;
	private String name;
	
	public GameListDTO() {}

	public GameListDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public GameListDTO(GameList entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
