package com.galaxia.game.galaxiagame.application.service;

import com.galaxia.game.galaxiagame.domain.model.Enemigo;
import com.galaxia.game.galaxiagame.domain.model.Tablero;
import com.galaxia.game.galaxiagame.domain.model.TipoDeEnemigo;
import com.galaxia.game.galaxiagame.application.EnemigoService;

import java.util.List;

public class EnemigoServiceImpl implements EnemigoService {
	@Override
	public List<Enemigo> crearEnemigos() {
		return List.of();
	}

	@Override
	public void generarNuevosEnemigos(int cantidad) {

	}

	@Override
	public void moverEnemigoEnMovimiento() {

	}

	@Override
	public void reiniciarEnemigos() {

	}

	@Override
	public void procesarMovimientoEnemigo() {

	}

	@Override
	public void agregarFilasDeEnemigos(int yInicial) {

	}

	@Override
	public void agregarFilaDeEnemigos(TipoDeEnemigo tipoDeEnemigo, int cantidad, int yInicial, int separacionX) {

	}

	@Override
	public Enemigo crearEnemigo(TipoDeEnemigo tipoDeEnemigo) {
		return null;
	}

	@Override
	public int calcularPosX(TipoDeEnemigo tipoDeEnemigo, int indice, int separacionX) {
		return 0;
	}

	@Override
	public List<Enemigo> getEnemigos() {
		return List.of();
	}

	@Override
	public Tablero getTablero() {
		return null;
	}
}
