package com.vadmin.service.impl.general;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vadmin.entities.general.CatalogosGenericos;
import com.vadmin.repository.general.IcatalogoGenericoRepo;
import com.vadmin.service.general.IcatalogoGenericoS;

@Service
public class CatalogoGenericoS  implements IcatalogoGenericoS{
	
	private  IcatalogoGenericoRepo catalogoGenericoRepo;
	
	@Autowired
	public void setCatalogoGenericoRepo(IcatalogoGenericoRepo catalogoGenericoRepo) {
		this.catalogoGenericoRepo = catalogoGenericoRepo;
	}

	@Override
	public Optional<CatalogosGenericos> findRecordById(Long id) {
		return catalogoGenericoRepo.findById(id);
	}

	@Override
	public List<CatalogosGenericos> findAll() {
		return catalogoGenericoRepo.findAll();
	}

	@Override
	public Long save(CatalogosGenericos entidad) {
		return catalogoGenericoRepo.save(entidad).getId();
	}

	@Override
	public void delete(CatalogosGenericos entidad) {
		catalogoGenericoRepo.delete(entidad);
	}

}
