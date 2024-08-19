package com.vadmin.repository.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vadmin.entities.general.CatalogosGenericos;

@Repository
public interface IcatalogoGenericoRepo extends JpaRepository<CatalogosGenericos, Long>{

}
