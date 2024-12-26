package com.galaxia.game.galaxiagame.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Enemy extends GameObject {

	private String type;
	private int points;
	public String image;
	public boolean isAttacking;
	public boolean isShooting;

	public Enemy(int x, int y, String type, int points) {
		super(x, y, 5); // Velocidad predeterminada
		this.type = type;
		this.points = points;
		this.image = getImageForType(type);
		this.isAttacking = false;
		this.isShooting = false;
	}

	private String getImageForType(String type) {
		return switch (type) {
			case "Type1", "Type5" -> "resources/images/azul.png";
			case "Type2" -> "resources/images/rojo.png";
			case "Type4" -> "resources/images/amarillo.png";
			default -> "resources/images/morado.png";
		};
	}

	public Bullet attack() {
		this.isAttacking = true;
		return new Bullet(x, y + 1, 10);
	}

	public void move() {
		// Lógica de movimiento horizontal
		this.x += (Math.random() > 0.5) ? 10 : -10;
	}


	public void shoot() {
		// Inicia un disparo
		this.isShooting = true;
	}

	@Override
	public void update() {
		x += speed; // Movimiento horizontal
	}
}
