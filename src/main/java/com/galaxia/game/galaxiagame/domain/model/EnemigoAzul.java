package com.galaxia.game.galaxiagame.domain.model;

public class EnemigoAzul extends Enemigo {

	public EnemigoAzul() {
	}

	@Override
	public int darPuntos() {
		return isAtacando() ? 60 : 30;

	}

	public String getImagen() {
		return "../imagenes/azul.png";
	}
}
