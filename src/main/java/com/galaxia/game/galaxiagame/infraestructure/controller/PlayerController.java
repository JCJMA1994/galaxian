package com.galaxia.game.galaxiagame.infraestructure.controller;

import com.galaxia.game.galaxiagame.domain.model.Player;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.Serializable;

@Getter
@Setter
@Named("playerController")
@SessionScoped
public class PlayerController extends HttpServlet implements Serializable {
	private Player player1;
	private Player player2;
	private String player1Name;
	private String player2Name;

	@PostConstruct
	public void init() {
		if (player1 == null) {
			player1 = new Player("1", player1Name != null ? player1Name : "Jugador 1",
					0, 10, 700, "A", "D", "W");
		}
		if (player2 == null) {
			player2 = new Player("2", player2Name != null ? player2Name : "Jugador 2",
					0, 50, 700, "J", "L", "I");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		String p1Name = req.getParameter("player1Name");
		String p2Name = req.getParameter("player2Name");

		if (p1Name != null && !p1Name.trim().isEmpty()) {
			player1Name = p1Name;
			player1.setName(p1Name);
		}

		if (p2Name != null && !p2Name.trim().isEmpty()) {
			player2Name = p2Name;
			player2.setName(p2Name);
		}
	}


	public void movePlayer1Left() {
		player1.moveLeft();
	}

	public void movePlayer1Right() {
		player1.moveRight();
	}

	public void player1Shoot() {
		player1.shoot();
	}

	public void movePlayer2Left() {
		player2.moveLeft();
	}

	public void movePlayer2Right() {
		player2.moveRight();
	}

	public void player2Shoot() {
		player2.shoot();
	}

	public void setPlayer1Name(String name) {
		this.player1Name = name;
		if (player1 != null) {
			player1.setName(name);
		}
	}

	public void setPlayer2Name(String name) {
		this.player2Name = name;
		if (player2 != null) {
			player2.setName(name);
		}
	}

	public String getPlayer1Name() {
		return player1 != null ? player1.getName() : player1Name;
	}

	public String getPlayer2Name() {
		return player2 != null ? player2.getName() : player2Name;
	}

	public int getPlayer1Lives() {
		return player1.getLives();
	}

	public int getPlayer1Score() {
		return player1.getScore();
	}

	public String getPlayer1Image() {
		return player1.getImage();
	}


	public int getPlayer2Lives() {
		return player2.getLives();
	}

	public int getPlayer2Score() {
		return player2.getScore();
	}

	public String getPlayer2Image() {
		return player2.getImage();
	}


	public String startGame() {
		// Actualizar los nombres de los jugadores antes de iniciar el juego
		if (player1Name != null && !player1Name.trim().isEmpty()) {
			player1.setName(player1Name);
		}
		if (player2Name != null && !player2Name.trim().isEmpty()) {
			player2.setName(player2Name);
		}
		return "game.xhtml?faces-redirect=true";
	}
}
