package com.vadmin.repository.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vadmin.entities.general.Plataformas;

@Repository
public interface IplataformasRepo  extends JpaRepository<Plataformas, Long>{

}
