package com.galaxia.game.galaxiagame.domain.model;

public class Bullet extends GameObject {
	public Bullet(int x, int y, int speed) {
		super(x, y, speed);
	}

	@Override
	public void update() {
		y += speed;
	}

	public boolean isOutOfBounds(int maxHeight) {
		return y < 0 || y > maxHeight;
	}
}
