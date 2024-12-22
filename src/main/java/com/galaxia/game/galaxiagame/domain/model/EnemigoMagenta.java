package com.galaxia.game.galaxiagame.domain.model;

public class EnemigoMagenta extends Enemigo {

    public EnemigoMagenta() {
    }

    @Override
    public int darPuntos() {
        return isAtacando() ? 80 : 40;

    }
    public String getImagen() {
        return "../imagenes/morado.png";
    }
}
