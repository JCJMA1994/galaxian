package com.galaxia.game.galaxiagame.application;

import com.galaxia.game.galaxiagame.domain.model.Enemigo;
import com.galaxia.game.galaxiagame.domain.model.Jugador;

import java.util.List;

public interface JugadorService {

	List<Jugador> jugadores();

	void reiniciar();

	void procesarPuntuacion(Jugador jugador, Enemigo enemigo);

	void procesarVida(Jugador jugador);

	List<Integer> getPuntuaciones();

	List<Integer> getVidas();

	boolean isGameOver();

	List<Jugador> getJugadores();
}
