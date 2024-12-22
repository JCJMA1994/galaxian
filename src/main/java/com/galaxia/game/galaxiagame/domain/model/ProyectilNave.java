package com.galaxia.game.galaxiagame.domain.model;

import java.awt.Color;

public class ProyectilNave extends Proyectil {

    public ProyectilNave(int x, int y) {
        super(Color.YELLOW, x, y);
    }

    @Override
    public void mover() {
        posicion.setY(posicion.getY() - VELOCIDAD);
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

}
