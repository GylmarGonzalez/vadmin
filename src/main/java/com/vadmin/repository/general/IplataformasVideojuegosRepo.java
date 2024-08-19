package com.vadmin.repository.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vadmin.entities.general.PlataformasVideojuegos;

@Repository
public interface IplataformasVideojuegosRepo extends JpaRepository<PlataformasVideojuegos, Long>{

}
