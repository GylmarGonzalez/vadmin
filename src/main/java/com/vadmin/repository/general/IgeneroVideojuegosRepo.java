package com.vadmin.repository.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vadmin.entities.general.GeneroVideojuegos;

@Repository
public interface IgeneroVideojuegosRepo  extends JpaRepository<GeneroVideojuegos, Long>{

}
