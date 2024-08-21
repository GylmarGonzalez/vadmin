package com.vadmin.request.general;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Size;

public class VideojuegosRequest {
	
	private Long id;

	@Size(min = 1, max = 50, message = "El campo nombre tiene un tama�o maximo de 50 caracteres")
	private String nombre;
	
	@Size(min = 1, max = 5000, message = "El campo descripcion tiene un tama�o maximo de 5000 caracteres")
	private String descripcion;
	
	@Size(min = 1, max = 10, message = "El campo fkdesarrollador tiene un tama�o maximo de 10 caracteres")
	private String fkDesarrollador;

	@Size(min = 1, max = 10, message = "El campo fkpublicador tiene un tama�o maximo de 10 caracteres")
	private String fkPublicador;

	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate fechaSalida;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFkDesarrollador() {
		return fkDesarrollador;
	}

	public void setFkDesarrollador(String fkDesarrollador) {
		this.fkDesarrollador = fkDesarrollador;
	}

	public String getFkPublicador() {
		return fkPublicador;
	}

	public void setFkPublicador(String fkPublicador) {
		this.fkPublicador = fkPublicador;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

}
