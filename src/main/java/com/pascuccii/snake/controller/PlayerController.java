package com.pascuccii.snake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pascuccii.snake.entity.Player;
import com.pascuccii.snake.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService service;

	@PostMapping("/addPlayer")
	public Player addPlayer(@RequestBody Player player) {
		return service.savePlayer(player);
	}

	@PostMapping("/writeScore")
	public Player writeScore(@RequestBody Player player) {
		return service.writeScore(player);
	}

	@PostMapping("/addPlayers")
	public List<Player> addPlayers(@RequestBody List<Player> players) {
		return service.savePlayer(players);
	}
	
	@GetMapping("/players")
	public List<Player> findAllPlayers() {
		return service.getPlayers();
	}

	@GetMapping("/playerById/{id}")
	public Player findPlayerById(@PathVariable Integer id) {
		return service.getPlayerById(id);
	}

	@GetMapping("/playerByName/{name}")
	public Player findPlayerByName(@PathVariable String name) {
		return service.getPlayerByName(name);
	}

	@PutMapping("/update")
	public Player updatePlayer(@RequestBody Player player) {
		return service.updatePlayer(player);
	}
	
	@DeleteMapping("/delete/{id}")
	private String deletePlayer(@PathVariable Integer id) {
		return service.deletePlayer(id);
	}
	
}
