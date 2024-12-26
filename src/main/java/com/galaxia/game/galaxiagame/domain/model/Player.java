package com.galaxia.game.galaxiagame.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends GameObject {
	private String id;
	private String name;
	private int lives;
	private int score;
	private boolean canShoot;
	private String moveLeftKey;
	private String moveRightKey;
	private String shootKey;
	public String image;

	public Player(String id, String name, int score, int x, int y, String moveLeftKey, String moveRightKey, String shootKey) {
		super(x, y, 10);
		this.id = id;
		this.name = name;
		this.score = score;
		this.lives = 3;
		this.canShoot = true;
		this.moveLeftKey = moveLeftKey;
		this.moveRightKey = moveRightKey;
		this.shootKey = shootKey;
		this.image = getImageForType();
	}

	private String getImageForType() {
		return "resources/images/nave.png";
	}

	public void loseLife() {
		if (lives > 0) lives--;
	}

	public boolean isAlive() {
		return lives > 0;
	}

	public void moveLeft() {
		x -= speed;
	}

	public void moveRight() {
		x += speed;
	}

	public Bullet shoot() {
		if (canShoot) {
			return new Bullet(x, y - 1, -15); // Dispara hacia arriba
		}
		return null;
	}


	@Override
	public void update() {
		// Lógica adicional si es necesario
	}
}
