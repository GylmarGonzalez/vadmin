package com.vadmin.response.general;

import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

public class CatalogosGenericosResponse extends RepresentationModel<CatalogosGenericosResponse>{
	
	private Long id;
	private String tipo;
	private String codigo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(codigo, id, nombre, tipo);
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
		CatalogosGenericosResponse other = (CatalogosGenericosResponse) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(tipo, other.tipo);
	}
	


}
