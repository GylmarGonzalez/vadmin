package com.vadmin.service.impl.general;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vadmin.entities.general.GeneroVideojuegos;
import com.vadmin.repository.general.IgeneroVideojuegosRepo;
import com.vadmin.service.general.IgeneroVideojuegosS;

@Service
public class GeneroVideojuegosS implements IgeneroVideojuegosS{
	
	private IgeneroVideojuegosRepo generoVideojuegosRepo;

	@Autowired
	public void setGeneroVideojuegosRepo(IgeneroVideojuegosRepo generoVideojuegosRepo) {
		this.generoVideojuegosRepo = generoVideojuegosRepo;
	}

	@Override
	public Optional<GeneroVideojuegos> findRecordById(Long id) {
		return generoVideojuegosRepo.findById(id);
	}

	@Override
	public List<GeneroVideojuegos> findAll() {
		return generoVideojuegosRepo.findAll();
	}

	@Override
	public Long save(GeneroVideojuegos entidad) {
		return generoVideojuegosRepo.save(entidad).getId();
	}

	@Override
	public void delete(GeneroVideojuegos entidad) {
		generoVideojuegosRepo.delete(entidad);
	}

}
