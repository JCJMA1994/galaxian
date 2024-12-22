package com.galaxia.game.galaxiagame.application;

import com.galaxia.game.galaxiagame.domain.model.Enemigo;
import com.galaxia.game.galaxiagame.domain.model.Tablero;
import com.galaxia.game.galaxiagame.domain.model.TipoDeEnemigo;

import java.util.List;

public interface EnemigoService {

	List<Enemigo> crearEnemigos();

	void generarNuevosEnemigos(int cantidad);

	void moverEnemigoEnMovimiento();

	void reiniciarEnemigos();

	void procesarMovimientoEnemigo();

	void agregarFilasDeEnemigos(int yInicial);

	void agregarFilaDeEnemigos(TipoDeEnemigo tipoDeEnemigo, int cantidad, int yInicial, int separacionX);

	Enemigo crearEnemigo(TipoDeEnemigo tipoDeEnemigo);

	int calcularPosX(TipoDeEnemigo tipoDeEnemigo, int indice, int separacionX);

	List<Enemigo> getEnemigos();

	Tablero getTablero();

}
