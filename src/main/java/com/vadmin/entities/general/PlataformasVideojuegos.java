package com.vadmin.entities.general;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "plataformas_videojuegos")
public class PlataformasVideojuegos {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@OneToOne
	@NotNull(message = "fkVideojuegos no puede ser vacio")
	private Videojuegos fkVideojuegos;
	
	@OneToOne
	@NotNull(message = "fkplataforma no puede ser vacio")
	private Plataformas fkPlataforma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Videojuegos getFkVideojuegos() {
		return fkVideojuegos;
	}

	public void setFkVideojuegos(Videojuegos fkVideojuegos) {
		this.fkVideojuegos = fkVideojuegos;
	}

	public Plataformas getFkPlataforma() {
		return fkPlataforma;
	}

	public void setFkPlataforma(Plataformas fkPlataforma) {
		this.fkPlataforma = fkPlataforma;
	}
	
}
