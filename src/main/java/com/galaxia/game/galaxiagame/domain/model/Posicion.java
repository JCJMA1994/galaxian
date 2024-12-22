package com.galaxia.game.galaxiagame.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Posicion {
	private int x;
	private int y;

	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
