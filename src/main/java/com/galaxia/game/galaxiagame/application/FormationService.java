package com.galaxia.game.galaxiagame.application;

import com.galaxia.game.galaxiagame.domain.model.Bullet;
import com.galaxia.game.galaxiagame.domain.model.Enemy;
import com.galaxia.game.galaxiagame.domain.model.EnemyFormation;

import java.util.List;

public class FormationService {
	private final EnemyFormation formation;

	public FormationService(EnemyFormation formation) {
		this.formation = formation;
	}

	public void moveEnemies() {
		for (List<Enemy> row : formation.getFormation()) {
			for (Enemy enemy : row) {
				enemy.update();
			}
		}
	}

	public Bullet enemyAttack() {
		Enemy enemy = formation.getNextAttackingEnemy();
		return enemy != null ? enemy.attack() : null;
	}
}
