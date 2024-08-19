package com.vadmin.service.general;

import java.util.List;
import java.util.Optional;

import com.vadmin.entities.general.CatalogosGenericos;

public interface IcatalogoGenericoS {

	Optional<CatalogosGenericos> findRecordById(Long id);
	List<CatalogosGenericos> findAll();
	Long save(CatalogosGenericos entidad);
	void delete(CatalogosGenericos entidad);
	
}
