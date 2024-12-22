package com.galaxia.game.galaxiagame.domain.model;

import java.awt.Color;

public class ProyectilEnemigo extends Proyectil {

    public ProyectilEnemigo(int x, int y) {
        super(Color.RED, x, y);
    }

    @Override
    public void mover() {
        posicion.setY(posicion.getY() + VELOCIDAD);
    }
}
