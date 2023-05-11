package com.devsuperior.dslistGamer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslistGamer.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
