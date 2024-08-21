package com.vadmin.service.general;

import java.util.List;
import java.util.Optional;

import com.vadmin.entities.general.Plataformas;

public interface IplataformasS {
	
	Optional<Plataformas> findRecordById(Long id);
	List<Plataformas> findAll();
	Long save(Plataformas entidad);
	void delete(Long id);

}
