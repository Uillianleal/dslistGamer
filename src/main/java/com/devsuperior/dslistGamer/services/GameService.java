package com.devsuperior.dslistGamer.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslistGamer.dto.GameDTO;
import com.devsuperior.dslistGamer.dto.GameMinDTO;
import com.devsuperior.dslistGamer.entities.Game;
import com.devsuperior.dslistGamer.repositories.GameRepository;
import com.devsuperior.dslistGamer.services.exceptions.ResourceNotFoundException;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = repository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x))
				.collect(Collectors.toList());
		return dto;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {	
		Optional<Game> obj = repository.findById(id);
		Game entity = obj.orElseThrow(() ->  new ResourceNotFoundException("Id not found"));
		return new GameDTO(entity);
	}
	
}
