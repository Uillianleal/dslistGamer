package com.devsuperior.dslistGamer.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslistGamer.dto.GameListDTO;
import com.devsuperior.dslistGamer.entities.GameList;
import com.devsuperior.dslistGamer.projection.GameMinProjection;
import com.devsuperior.dslistGamer.repositories.GameListRepository;
import com.devsuperior.dslistGamer.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository repository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = repository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x))
				.collect(Collectors.toList());
		return dto;
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			repository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}

	}
	
}
