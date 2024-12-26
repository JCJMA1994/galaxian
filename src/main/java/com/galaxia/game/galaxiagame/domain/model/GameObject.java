package com.galaxia.game.galaxiagame.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GameObject {
	protected int x;
	protected int y;
	protected int speed;

	public GameObject(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	public abstract void update();
}
