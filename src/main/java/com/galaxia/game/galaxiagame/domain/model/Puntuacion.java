package com.galaxia.game.galaxiagame.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Puntuacion {
	private int puntos;

	public Puntuacion() {
		this.puntos = 0;
	}
}
