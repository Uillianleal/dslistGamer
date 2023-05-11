package com.devsuperior.dslistGamer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslistGamer.dto.GameDTO;
import com.devsuperior.dslistGamer.dto.GameMinDTO;
import com.devsuperior.dslistGamer.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService service;
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = service.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GameDTO> findById(@PathVariable Long id) {
		GameDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
