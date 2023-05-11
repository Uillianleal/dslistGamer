package com.devsuperior.dslistGamer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslistGamer.entities.Game;
import com.devsuperior.dslistGamer.entities.GameList;

public interface GameRepository extends JpaRepository<Game, Long>{

}
