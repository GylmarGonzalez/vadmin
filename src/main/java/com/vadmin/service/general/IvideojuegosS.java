package com.vadmin.service.general;

import java.util.List;
import java.util.Optional;

import com.vadmin.entities.general.Videojuegos;

public interface IvideojuegosS {
	
	Optional<Videojuegos> findRecordById(Long id);
	List<Videojuegos> findAll();
	Long save(Videojuegos entidad);
	void delete(Videojuegos entidad);

}
