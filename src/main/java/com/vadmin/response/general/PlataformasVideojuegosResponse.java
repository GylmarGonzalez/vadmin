package com.vadmin.response.general;

import org.springframework.hateoas.RepresentationModel;

import com.vadmin.request.general.PlataformasRequest;
import com.vadmin.request.general.VideojuegosRequest;

public class PlataformasVideojuegosResponse extends RepresentationModel<PlataformasVideojuegosResponse>{
	
	private Long id;
	private  VideojuegosResponse fkVideojuegos;
	private PlataformasResponse fkPlataforma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VideojuegosResponse getFkVideojuegos() {
		return fkVideojuegos;
	}

	public void setFkVideojuegos(VideojuegosResponse fkVideojuegos) {
		this.fkVideojuegos = fkVideojuegos;
	}

	public PlataformasResponse getFkPlataforma() {
		return fkPlataforma;
	}

	public void setFkPlataforma(PlataformasResponse fkPlataforma) {
		this.fkPlataforma = fkPlataforma;
	}

}
