package com.galaxia.game.galaxiagame.application;

import com.galaxia.game.galaxiagame.domain.model.Bullet;
import com.galaxia.game.galaxiagame.domain.model.Enemy;

public class EnemyService {
	public void move(Enemy enemy) {
		enemy.update();
	}

	public Bullet attack(Enemy enemy) {
		return enemy.attack();
	}
}

