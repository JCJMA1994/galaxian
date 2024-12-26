package com.galaxia.game.galaxiagame.infraestructure.controller;

import com.galaxia.game.galaxiagame.domain.Game;
import com.galaxia.game.galaxiagame.domain.model.Enemy;
import com.galaxia.game.galaxiagame.domain.model.Player;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("gameController")
@ViewScoped
public class GameController implements Serializable {
	private Game game;

	@PostConstruct
	public void init() {
		game = new Game();
		game.start();
	}

	public List<Player> getPlayers() {
		return game.getPlayers();
	}

	public List<List<Enemy>> getEnemyFormation() {
		return game.getEnemyFormation().getFormation();
	}

	public boolean isGameOver() {
		return game.getPlayers().stream().allMatch(player -> player.getLives() <= 0);
	}

	public void updateGame() {
		game.start();
	}
}
