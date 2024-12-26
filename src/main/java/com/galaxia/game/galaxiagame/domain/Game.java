package com.galaxia.game.galaxiagame.domain;

import com.galaxia.game.galaxiagame.domain.model.Bullet;
import com.galaxia.game.galaxiagame.domain.model.Enemy;
import com.galaxia.game.galaxiagame.domain.model.EnemyFormation;
import com.galaxia.game.galaxiagame.domain.model.Player;
import com.galaxia.game.galaxiagame.application.FormationService;
import com.galaxia.game.galaxiagame.application.GameService;
import com.galaxia.game.galaxiagame.application.PlayerService;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
	private List<Player> players;
	private EnemyFormation enemyFormation;
	private List<Bullet> bullets;
	private PlayerService playerService;
	private FormationService formationService;
	private GameService gameService;

	public Game() {
		// Inicializar jugadores
		players = new ArrayList<>();
		players.add(new Player("Player1", "Player1", 100,100, 500, "ArrowLeft", "ArrowRight", "Space"));
		players.add(new Player("Player2", "Player2", 100,300, 500, "KeyA", "KeyD", "KeyW"));

		// Inicializar formación de enemigos
		enemyFormation = new EnemyFormation();

		// Inicializar lista de balas
		bullets = new ArrayList<>();

		// Inicializar servicios
		playerService = new PlayerService();
		formationService = new FormationService(enemyFormation);
		gameService = new GameService(players, enemyFormation, bullets);
	}

	public void start() {
		while (!gameService.isGameOver()) {
			updateGame();
		}
		System.out.println("Game Over!");
	}

	private void updateGame() {
		// Actualizar jugadores
		for (Player player : players) {
			player.update();
		}

		// Mover enemigos
		formationService.moveEnemies();

		// Turno de disparo enemigo
		Bullet enemyBullet = formationService.enemyAttack();
		if (enemyBullet != null) {
			bullets.add(enemyBullet);
		}

		// Actualizar balas
		bullets.forEach(Bullet::update);

		// Verificar colisiones
		checkCollisions();
	}

	private void checkCollisions() {
		List<Bullet> bulletsToRemove = new ArrayList<>();
		List<Enemy> enemiesToRemove = new ArrayList<>();

		for (Bullet bullet : bullets) {
			// Colisión bala-jugador
			for (Player player : players) {
				if (bullet.getY() >= player.getY() && bullet.getX() == player.getX()) {
					player.loseLife();
					bulletsToRemove.add(bullet);
				}
			}

			// Colisión bala-enemigo
			for (List<Enemy> row : enemyFormation.getFormation()) {
				for (Enemy enemy : row) {
					if (bullet.getY() <= enemy.getY() && bullet.getX() == enemy.getX()) {
						enemiesToRemove.add(enemy);
						bulletsToRemove.add(bullet);
					}
				}
			}
		}

		bullets.removeAll(bulletsToRemove);
		for (List<Enemy> row : enemyFormation.getFormation()) {
			row.removeAll(enemiesToRemove);
		}
	}

	private Player findShootingPlayer(Bullet bullet) {
		for (Player player : players) {
			if (player.getX() == bullet.getX()) {
				return player;
			}
		}
		return null;
	}

}
