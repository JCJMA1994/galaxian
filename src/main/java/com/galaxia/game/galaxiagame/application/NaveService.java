package com.galaxia.game.galaxiagame.application;

import com.galaxia.game.galaxiagame.domain.model.Nave;
import com.galaxia.game.galaxiagame.domain.model.Tablero;

import java.util.List;

public interface NaveService {

	void procesarMovimiento();

	void seleccionarTeclas();

	List<Nave> crearNaves(Tablero tablero);

	List<Nave> getNave();

	void actualizarProyectil();

	void isProyectilActivo();
}
