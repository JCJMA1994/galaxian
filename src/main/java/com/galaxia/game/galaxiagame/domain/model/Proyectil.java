package com.galaxia.game.galaxiagame.domain.model;

import java.awt.*;

public class Proyectil extends Elemento{

	public static final int ANCHO = 2;
	public static final int ALTO = 8;
	protected static final int VELOCIDAD = 20;

	public Proyectil(Color color, int x, int y) {
		super(color);
		this.posicion = new Posicion(x, y);
	}

	public void mover() {
		posicion.setY(posicion.getY() - VELOCIDAD);
	}
}
