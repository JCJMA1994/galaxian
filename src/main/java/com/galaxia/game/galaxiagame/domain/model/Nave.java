package com.galaxia.game.galaxiagame.domain.model;

import com.galaxia.game.galaxiagame.domain.interfaces.Colisionable;
import com.galaxia.game.galaxiagame.domain.interfaces.IProyectible;
import lombok.Getter;

import java.awt.*;

@Getter
public class Nave extends  Elemento implements Colisionable, IProyectible {

	public static final int ANCHO = 55;
	public static final int ALTO = 57;
	private static final int VELOCIDAD = 10;

	private Proyectil proyectilNave;
	private boolean proyectilActivo;

	public Nave() {
		this.proyectilActivo = false;
	}

	public void asignarPosicion(Tablero tablero) {
		this.posicion = tablero.generarPosicionNave();
	}

	public void moverIzquierda() {
		if (posicion.getX() > 0) {
			int nuevaPosX = posicion.getX() - VELOCIDAD;
			posicion.setX(nuevaPosX);
		}
	}

	public void moverDerecha() {
		if (posicion.getX() < Tablero.ANCHO - ANCHO) {
			int nuevaPosX = posicion.getX() + VELOCIDAD;
			posicion.setX(nuevaPosX);
		}
	}

	@Override
	public void crearProyectil() {
		int posicionProyectilX = this.posicion.getX() + (ANCHO / 2) - 1;
		int posicionProyectilY = this.posicion.getY() - 70;
		proyectilNave = new ProyectilNave(posicionProyectilX, posicionProyectilY);

	}

	@Override
	public void lanzarProyectil() {
		if (!proyectilActivo) {
			crearProyectil();
			proyectilActivo = true;
		}
	}

	public void actualizarProyectil() {
		if (proyectilActivo) {
			proyectilNave.mover();
			if (proyectilNave.getPosicion().getY() < 0) {
				reiniciarProyectil();
			}
		}
	}

	@Override
	public boolean colisionaCon(Elemento elemento) {
		Rectangle rectNave = new Rectangle(
				posicion.getX(),
				posicion.getY(),
				ANCHO,
				ALTO
		);

		Rectangle rectElemento = new Rectangle(
				elemento.getPosicion().getX(),
				elemento.getPosicion().getY(),
				5,
				10
		);

		return rectNave.intersects(rectElemento);
	}

	@Override
	public void reiniciarProyectil() {
		proyectilActivo = false;
		proyectilNave = null;
	}
}