package com.devsuperior.dslistGamer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslistGamer.dto.GameDTO;
import com.devsuperior.dslistGamer.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService service;
	
	@GetMapping
	public List<GameDTO> findAll() {
		List<GameDTO> result = service.findAll();
		return result;
	}
}
