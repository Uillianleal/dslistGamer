package com.devsuperior.dslistGamer.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslistGamer.dto.GameListDTO;
import com.devsuperior.dslistGamer.entities.GameList;
import com.devsuperior.dslistGamer.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = repository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x))
				.collect(Collectors.toList());
		return dto;
	}
	
}
