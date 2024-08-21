package com.vadmin.response.general;

import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;


public class PlataformasResponse extends RepresentationModel<CatalogosGenericosResponse>{
	
	private Long id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id, nombre);
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
		PlataformasResponse other = (PlataformasResponse) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

}
