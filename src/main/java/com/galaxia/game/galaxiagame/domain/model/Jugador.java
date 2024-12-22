package com.galaxia.game.galaxiagame.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jugador {
	private String nombre;
	private Puntuacion puntuacion;
	private Vida vida;
}
