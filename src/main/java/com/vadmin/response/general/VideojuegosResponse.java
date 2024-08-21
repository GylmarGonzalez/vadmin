package com.vadmin.response.general;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

public class VideojuegosResponse extends RepresentationModel<CatalogosGenericosResponse>{
	
	private Long id;
	private String nombre;
	private String descripcion;
	private String fkDesarrollador;
	private String fkPublicador;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(descripcion, fechaSalida, fkDesarrollador, fkPublicador, id, nombre);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideojuegosResponse other = (VideojuegosResponse) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(fechaSalida, other.fechaSalida)
				&& Objects.equals(fkDesarrollador, other.fkDesarrollador)
				&& Objects.equals(fkPublicador, other.fkPublicador) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

}
