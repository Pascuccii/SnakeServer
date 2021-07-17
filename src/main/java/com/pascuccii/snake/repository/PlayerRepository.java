package com.pascuccii.snake.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pascuccii.snake.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

	Player findByName(String name);

	
	
}
