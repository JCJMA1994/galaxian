package com.galaxia.game.galaxiagame.infraestructure.controller;

import com.galaxia.game.galaxiagame.domain.model.Enemy;
import com.galaxia.game.galaxiagame.domain.model.EnemyFormation;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Setter
@Named("enemyController")
@ViewScoped
public class EnemyController implements Serializable {
	private EnemyFormation formation;

	@PostConstruct
	public void init() {
		formation = new EnemyFormation();
		startEnemyBehavior();
	}


	public List<List<Enemy>> getFormation() {
		return formation.getFormation();
	}

	public void moveEnemies() {
		formation.moveEnemies();
	}

	public void enemyAttack() {
		for (List<Enemy> row : formation.getFormation()) {
			for (Enemy enemy : row) {
				if (Math.random() > 0.7) {
					enemy.attack();
				}
				if (Math.random() > 0.9) {
					enemy.shoot();
				}
			}
		}
	}

	private void startEnemyBehavior() {
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				moveEnemies();
				enemyAttack();
			}
		}, 0, 1000); // Cada 1 segundo
	}
}
