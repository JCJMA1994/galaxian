package com.galaxia.game.galaxiagame.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EnemyFormation {
	@Getter
	private List<List<Enemy>> formation;
	private boolean movingRight = true;

	public EnemyFormation() {
		formation = new ArrayList<>();
		int[] rows = {10, 8, 6, 4, 2, 1};
		int startY = 50;
		int screenWidth = 1200;

		for (int i = 0; i < rows.length; i++) {
			List<Enemy> row = new ArrayList<>();
			int rowWidth = rows[i] * 60;
			int startX = (screenWidth - rowWidth) / 2;

			for (int j = 0; j < rows[i]; j++) {
				row.add(new Enemy(startX + (j * 60), startY + (i * 50), "Type" + (i + 1), 100 * (i + 1)));
			}
			formation.add(row);
		}
	}

	public Enemy getNextAttackingEnemy() {
		for (List<Enemy> row : formation) {
			if (!row.isEmpty()) {
				return row.get((int) (Math.random() * row.size()));
			}
		}
		return null;
	}

	public void moveEnemies() {
		for (List<Enemy> row : formation) {
			for (Enemy enemy : row) {
				if (movingRight) {
					enemy.setX(enemy.getX() + enemy.getSpeed());
				} else {
					enemy.setX(enemy.getX() - enemy.getSpeed());
				}
			}
		}

		if (formation.get(0).get(0).getX() <= 0 ||
				formation.get(0).get(formation.get(0).size() - 1).getX() >= 800) {
			movingRight = !movingRight;
			moveEnemiesDown();
		}
	}

	private void moveEnemiesDown() {
		for (List<Enemy> row : formation) {
			for (Enemy enemy : row) {
				enemy.setY(enemy.getY() + 20);
			}
		}
	}
}
