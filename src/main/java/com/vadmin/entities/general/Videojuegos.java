package com.vadmin.entities.general;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "videojuegos")
public class Videojuegos {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nombre", length = 50, nullable = false)
	@Size(min = 1, max = 50, message = "El campo nombre tiene un tama�o maximo de 50 caracteres")
	private String nombre;
	
	@Column(name = "descripcion", length = 5000, nullable = false)
	@Size(min = 1, max = 5000, message = "El campo descripcion tiene un tama�o maximo de 5000 caracteres")
	private String descripcion;
	
	@Column(name = "fkdesarrollador", length = 10, nullable = false)
	@Size(min = 1, max = 10, message = "El campo fkdesarrollador tiene un tama�o maximo de 10 caracteres")
	private String fkDesarrollador;
	
	@Column(name = "fkpublicador", length = 10, nullable = false)
	@Size(min = 1, max = 10, message = "El campo fkpublicador tiene un tama�o maximo de 10 caracteres")
	private String fkPublicador;
	
	@Column(name = "fechasalida", columnDefinition = "DATE")
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
