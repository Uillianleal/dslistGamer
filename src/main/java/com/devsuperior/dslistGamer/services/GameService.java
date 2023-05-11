package com.devsuperior.dslistGamer.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslistGamer.dto.GameDTO;
import com.devsuperior.dslistGamer.entities.Game;
import com.devsuperior.dslistGamer.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameDTO> findAll() {
		List<Game> result = repository.findAll();
		List<GameDTO> dto = result.stream().map(x -> new GameDTO(x))
				.collect(Collectors.toList());
		return dto;
	}
	
}
