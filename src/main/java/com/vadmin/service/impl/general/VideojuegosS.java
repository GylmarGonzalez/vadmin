package com.vadmin.service.impl.general;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vadmin.entities.general.Videojuegos;
import com.vadmin.repository.general.IvideojuegosRepo;
import com.vadmin.service.general.IvideojuegosS;

@Service
public class VideojuegosS implements IvideojuegosS{

	private IvideojuegosRepo videojuegosRepo;

	@Autowired
	public void setVideojuegosRepo(IvideojuegosRepo videojuegosRepo) {
		this.videojuegosRepo = videojuegosRepo;
	}

	@Override
	public Optional<Videojuegos> findRecordById(Long id) {
		return videojuegosRepo.findById(id);
	}

	@Override
	public List<Videojuegos> findAll() {
		return videojuegosRepo.findAll();
	}

	@Override
	public Long save(Videojuegos entidad) {
		return videojuegosRepo.save(entidad).getId();
	}

	@Override
	public void delete(Long id) {
		videojuegosRepo.deleteById(id);
	}

}
