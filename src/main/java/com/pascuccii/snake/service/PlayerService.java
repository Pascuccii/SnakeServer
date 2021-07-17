package com.pascuccii.snake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pascuccii.snake.entity.Player;
import com.pascuccii.snake.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repository;

	public Player writeScore(Player player) {
		Player existingPlayer = repository.findByName(player.getName());
		if (existingPlayer != null) {
			return updatePlayer(existingPlayer);
		} else {
			return savePlayer(player);
		}
	}

	public Player savePlayer(Player player) {
		return repository.save(player);
	}

	public List<Player> savePlayer(List<Player> players) {
		return repository.saveAll(players);
	}

	public List<Player> getPlayers() {
		return repository.findAll();
	}

	public Player getPlayerById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Player getPlayerByName(String name) {
		return repository.findByName(name);
	}

	public String deletePlayer(Integer id) {
		repository.deleteById(id);
		return "player " + id + " is removed";
	}

	public Player updatePlayer(Player player) {
		Player existingPlayer = repository.findById(player.getId()).orElse(null);
		if (player.getName() != null && player.getName() != "") {
			existingPlayer.setName(player.getName());
		}
		if (player.getScore() > existingPlayer.getScore()) {
			existingPlayer.setScore(player.getScore());
		}
		return repository.save(existingPlayer);

	}

}
