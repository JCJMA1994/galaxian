package com.galaxia.game.galaxiagame.application;

import com.galaxia.game.galaxiagame.domain.model.Bullet;
import com.galaxia.game.galaxiagame.domain.model.EnemyFormation;
import com.galaxia.game.galaxiagame.domain.model.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class GameService {
	private List<Player> players;
	private EnemyFormation formation;
	private List<Bullet> bullets;

	public GameService(List<Player> players, EnemyFormation formation, List<Bullet> bullets) {
		this.players = players;
		this.formation = formation;
		this.bullets = bullets;
	}

	public void updateGame() {
		for (Player player : players) {
			player.update();
		}
		formation.moveEnemies();

		for (Bullet bullet : bullets) {
			bullet.update();
		}
	}

	public void enemyAttack() {
		Bullet bullet = formation.getNextAttackingEnemy().attack();
		if (bullet != null) {
			bullets.add(bullet);
		}
	}

	public boolean isGameOver() {
		for (Player player : players) {
			if (player.isAlive()) {
				return false;
			}
		}
		return true;
	}
}
