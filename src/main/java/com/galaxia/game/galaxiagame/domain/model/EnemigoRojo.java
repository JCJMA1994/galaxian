package com.galaxia.game.galaxiagame.domain.model;


public class EnemigoRojo extends Enemigo {

	public EnemigoRojo() {
	}

	@Override
	public int darPuntos() {
		return isAtacando() ? 100 : 50;
	}

	public String getImagen() {
		return "../imagenes/rojo.png";
	}
}
