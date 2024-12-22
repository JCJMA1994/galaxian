package com.galaxia.game.galaxiagame.infraestructure.servlet;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Named
@SessionScoped
public class HelloWorld implements Serializable {
	private String message;

	public String doGet() {
		return "gameStart.xhtml?faces-redirect=true"; // Navegar a la vista `gameStart.xhtml`
	}

	public void destroy() {
	}

}
