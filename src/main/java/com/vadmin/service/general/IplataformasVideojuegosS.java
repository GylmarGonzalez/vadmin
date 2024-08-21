package com.vadmin.service.general;

import java.util.List;
import java.util.Optional;

import com.vadmin.entities.general.PlataformasVideojuegos;

public interface IplataformasVideojuegosS {
	
	Optional<PlataformasVideojuegos> findRecordById(Long id);
	List<PlataformasVideojuegos> findAll();
	PlataformasVideojuegos save(PlataformasVideojuegos entidad);
	void delete(Long id);

}
