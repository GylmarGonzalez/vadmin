package com.vadmin.response.general;

import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;


public class GeneroVideojuegosResponse extends RepresentationModel<GeneroVideojuegosResponse>{
	
	private Long id;
	private String fkgenero;

	private VideojuegosResponse fkVideojuegos;

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

	public VideojuegosResponse getFkVideojuegos() {
		return fkVideojuegos;
	}

	public void setFkVideojuegos(VideojuegosResponse fkVideojuegos) {
		this.fkVideojuegos = fkVideojuegos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fkVideojuegos, fkgenero, id);
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
		GeneroVideojuegosResponse other = (GeneroVideojuegosResponse) obj;
		return Objects.equals(fkVideojuegos, other.fkVideojuegos) && Objects.equals(fkgenero, other.fkgenero)
				&& Objects.equals(id, other.id);
	}

}
