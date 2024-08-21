package com.vadmin.request.general;

import jakarta.validation.constraints.Size;

public class CatalogosGenericosRequest {
	
	private Long id;
	
	@Size(min = 1, max = 30, message = "El campo tipo tiene un tama�o maximo de 30 caracteres")
	private String tipo;
	
	@Size(min = 1, max = 10, message = "El campo codigo tiene un tama�o maximo de 10 caracteres")
	private String codigo;
	
	@Size(min = 1, max = 30, message = "El campo nombre tiene un tama�o maximo de 30 caracteres")
	
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
