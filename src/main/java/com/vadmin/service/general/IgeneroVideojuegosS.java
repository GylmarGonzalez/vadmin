package com.vadmin.service.general;

import java.util.List;
import java.util.Optional;

import com.vadmin.entities.general.GeneroVideojuegos;

public interface IgeneroVideojuegosS {
	
	Optional<GeneroVideojuegos> findRecordById(Long id);
	List<GeneroVideojuegos> findAll();
	GeneroVideojuegos save(GeneroVideojuegos entidad);
	void delete(Long id);

}
