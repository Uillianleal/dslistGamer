package com.devsuperior.dslistGamer.dto;

import java.io.Serializable;

import com.devsuperior.dslistGamer.entities.Game;
import com.devsuperior.dslistGamer.projection.GameMinProjection;

public class GameMinDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	
	public GameMinDTO () {}


	public GameMinDTO(Long id, String title, Integer year, String imgUrl, String shortDescription) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
	}
	
	public GameMinDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}
	
	public GameMinDTO(GameMinProjection projection) {
		id = projection.getId();
		title = projection.getTitle();
		year = projection.getGameYear();
		imgUrl = projection.getImgUrl();
		shortDescription = projection.getShortDescription();
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Long getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public Integer getYear() {
		return year;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public String getShortDescription() {
		return shortDescription;
	}	
}
