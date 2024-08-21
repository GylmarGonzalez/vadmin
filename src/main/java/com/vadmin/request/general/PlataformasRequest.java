package com.vadmin.request.general;

import jakarta.validation.constraints.Size;

public class PlataformasRequest {
	
	private Long id;

	@Size(min = 1, max = 30, message = "El campo nombre tiene un tama�o maximo de 30 caracteres")
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
