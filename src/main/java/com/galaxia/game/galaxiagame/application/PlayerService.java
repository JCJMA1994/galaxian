package com.galaxia.game.galaxiagame.application;

import com.galaxia.game.galaxiagame.domain.model.Bullet;
import com.galaxia.game.galaxiagame.domain.model.Player;

public class PlayerService {
	public void move(Player player, String command) {
		if (command.equals(player.getMoveLeftKey())) {
			player.moveLeft();
		} else if (command.equals(player.getMoveRightKey())) {
			player.moveRight();
		}
	}

	public Bullet shoot(Player player, String command) {
		if (command.equals(player.getShootKey())) {
			return player.shoot();
		}
		return null;
	}

	public void loseLife(Player player) {
		player.loseLife();
	}
}
