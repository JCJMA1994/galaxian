package com.galaxia.game.galaxiagame.domain.model;

public class Tablero {

    public static final int ANCHO = 500;
    public static final int ALTO = 700;
    public static final int TAMANO_UNIDAD = 50;

    public Tablero() {
    }

    public Posicion generarPosicion(int x, int y) {
        return new Posicion(x, y);
    }

    public Posicion generarPosicionNave() {
        int x = ANCHO / 2;
        int y = ALTO - TAMANO_UNIDAD;
        return new Posicion(x, y);
    }

    public int getAncho() {
        return ANCHO;
    }

    public int getAlto() {
        return ALTO;
    }
}
