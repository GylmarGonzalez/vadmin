package com.vadmin.repository.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vadmin.entities.general.Videojuegos;

@Repository
public interface IvideojuegosRepo extends JpaRepository<Videojuegos, Long>{

}
