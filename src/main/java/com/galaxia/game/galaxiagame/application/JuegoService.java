package com.galaxia.game.galaxiagame.application;

import com.galaxia.game.galaxiagame.domain.model.Jugador;
import com.galaxia.game.galaxiagame.domain.model.Nave;

public interface JuegoService {

	void inicializarJuego();

	void actualizarVista();

	void procesarActualizacion();

	void actualizar();

	void verificarColisiones();

	boolean gameOver();

	void verificarColisionesProyectil(Jugador jugador, Nave nave);

	void verificarColisionesNave(Jugador jugador, Nave nave);

	void reiniciarJuego();

	void manejarGameOver();

}
