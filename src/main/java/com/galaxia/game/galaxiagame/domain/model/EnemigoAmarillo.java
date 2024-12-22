package com.galaxia.game.galaxiagame.domain.model;


public class EnemigoAmarillo extends Enemigo {

	public EnemigoAmarillo() {
	}

	@Override
	public int darPuntos() {
		return isAtacando() ? 120 : 60;
	}

	public String getImagen() {
		return "../imagenes/amarillo.png";
	}
}
