package com.vadmin.service.impl.general;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vadmin.entities.general.Plataformas;
import com.vadmin.repository.general.IplataformasRepo;
import com.vadmin.service.general.IplataformasS;

@Service
public class PlataformasS  implements IplataformasS{
	
	private IplataformasRepo plataformasRepo;
	
	@Autowired
	public void setPlataformasRepo(IplataformasRepo plataformasRepo) {
		this.plataformasRepo = plataformasRepo;
	}

	@Override
	public Optional<Plataformas> findRecordById(Long id) {
		return plataformasRepo.findById(id);
	}

	@Override
	public List<Plataformas> findAll() {
		return plataformasRepo.findAll();
	}

	@Override
	public Long save(Plataformas entidad) {
		return plataformasRepo.save(entidad).getId();
	}

	@Override
	public void delete(Plataformas entidad) {
		plataformasRepo.delete(entidad);
	}



}
