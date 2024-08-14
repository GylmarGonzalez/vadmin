package com.vadmin.entities.general;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "generos_videojuegos")
public class GeneroVideojuegos {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "fkgenero", length = 10, nullable = false)
	@Size(min = 1, max = 10, message = "El campo fkgenero tiene un tama�o maximo de 10 caracteres")
	private String fkgenero;
	
	@OneToOne
	@NotNull(message = "fkVideojuegos no puede ser vacio")
	private Videojuegos fkVideojuegos;

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

	public Videojuegos getFkVideojuegos() {
		return fkVideojuegos;
	}

	public void setFkVideojuegos(Videojuegos fkVideojuegos) {
		this.fkVideojuegos = fkVideojuegos;
	}

}
