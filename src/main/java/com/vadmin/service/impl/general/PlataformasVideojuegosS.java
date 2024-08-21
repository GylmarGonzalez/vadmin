package com.vadmin.service.impl.general;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vadmin.entities.general.PlataformasVideojuegos;
import com.vadmin.repository.general.IplataformasVideojuegosRepo;
import com.vadmin.service.general.IplataformasVideojuegosS;

@Service
public class PlataformasVideojuegosS implements IplataformasVideojuegosS{
	
	private IplataformasVideojuegosRepo plataformasVideojuegosRepo;
	
	@Autowired
	public void setPlataformasVideojuegosRepo(IplataformasVideojuegosRepo plataformasVideojuegosRepo) {
		this.plataformasVideojuegosRepo = plataformasVideojuegosRepo;
	}

	@Override
	public Optional<PlataformasVideojuegos> findRecordById(Long id) {
		return plataformasVideojuegosRepo.findById(id);
	}

	@Override
	public List<PlataformasVideojuegos> findAll() {
		return plataformasVideojuegosRepo.findAll();
	}

	@Override
	public PlataformasVideojuegos save(PlataformasVideojuegos entidad) {
		 return plataformasVideojuegosRepo.save(entidad);
	}

	@Override
	public void delete(Long id) {
		plataformasVideojuegosRepo.deleteById(id);
	}

}
