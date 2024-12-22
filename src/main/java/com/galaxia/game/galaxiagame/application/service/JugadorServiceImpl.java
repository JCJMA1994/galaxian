package com.galaxia.game.galaxiagame.application.service;

import com.galaxia.game.galaxiagame.domain.model.Enemigo;
import com.galaxia.game.galaxiagame.domain.model.Jugador;
import com.galaxia.game.galaxiagame.application.JugadorService;

import java.util.List;

public class JugadorServiceImpl implements JugadorService {
	@Override
	public List<Jugador> jugadores() {
		return List.of();
	}

	@Override
	public void reiniciar() {

	}

	@Override
	public void procesarPuntuacion(Jugador jugador, Enemigo enemigo) {

	}

	@Override
	public void procesarVida(Jugador jugador) {

	}

	@Override
	public List<Integer> getPuntuaciones() {
		return List.of();
	}

	@Override
	public List<Integer> getVidas() {
		return List.of();
	}

	@Override
	public boolean isGameOver() {
		return false;
	}

	@Override
	public List<Jugador> getJugadores() {
		return List.of();
	}
}
