package com.vadmin.request.general;


import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Size;

public class GeneroVideojuegosRequest {
	

	private Long id;
	@Size(min = 1, max = 10, message = "El campo fkgenero tiene un tama�o maximo de 10 caracteres")
	private String fkgenero;
    @JoinColumn(name = "fkVideojuegos", referencedColumnName = "id")
	private Long fkVideojuegos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFkgenero() {
		return fkgenero;
	}

	public void setFkgenero(String fkgenero) {
		this.fkgenero = fkgenero;
	}

	public Long getFkVideojuegos() {
		return fkVideojuegos;
	}

	public void setFkVideojuegos(Long fkVideojuegos) {
		this.fkVideojuegos = fkVideojuegos;
	}

}
