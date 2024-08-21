package com.vadmin.entities.general;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "catalogos_genericos")
public class CatalogosGenericos {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "tipo", length = 30, nullable = false)
	@Size(min = 1, max = 30, message = "El campo tipo tiene un tama�o maximo de 30 caracteres")
	private String tipo;
	
	@Column(name = "codigo", length = 10, nullable = false)
	@Size(min = 1, max = 10, message = "El campo codigo tiene un tama�o maximo de 10 caracteres")
	private String codigo;
	
	@Column(name = "nombre", length = 30, nullable = false)
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
