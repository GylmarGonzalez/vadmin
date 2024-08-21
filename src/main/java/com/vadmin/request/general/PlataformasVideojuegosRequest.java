package com.vadmin.request.general;


import jakarta.validation.constraints.NotNull;

public class PlataformasVideojuegosRequest {

	private Long id;
	@NotNull(message = "fkVideojuegos no puede ser vacio")
	private Long fkVideojuegos;
	@NotNull(message = "fkplataforma no puede ser vacio")
	private Long fkPlataforma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFkVideojuegos() {
		return fkVideojuegos;
	}

	public void setFkVideojuegos(Long fkVideojuegos) {
		this.fkVideojuegos = fkVideojuegos;
	}

	public Long getFkPlataforma() {
		return fkPlataforma;
	}

	public void setFkPlataforma(Long fkPlataforma) {
		this.fkPlataforma = fkPlataforma;
	}
	
}
