package com.galaxia.game.galaxiagame.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vida {
	private int vidas;

	public Vida() {
		this.vidas = 3;
	}
}
