package com.galaxia.game.galaxiagame.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Elemento {
	protected  Posicion posicion;
	protected Color color;

	public Elemento() {
	}

	public Elemento(Color color) {
		this.color = color;
	}
}
