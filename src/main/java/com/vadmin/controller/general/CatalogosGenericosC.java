package com.vadmin.controller.general;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vadmin.conf.api.RestControllerAdmin;
import com.vadmin.entities.general.CatalogosGenericos;
import com.vadmin.request.general.CatalogosGenericosRequest;
import com.vadmin.service.general.IcatalogoGenericoS;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestControllerAdmin
@RestController
public class CatalogosGenericosC {
	
	private IcatalogoGenericoS catalogoGenericoS;
	

    private ModelMapper mapper;

	@Autowired
	public void setCatalogoGenericoS(IcatalogoGenericoS catalogoGenericoS) {
		this.catalogoGenericoS = catalogoGenericoS;
	}

    @Autowired
	public void setMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}


    @PostMapping("/catalogo-generico")
	public ResponseEntity<String> guardar(@Valid @RequestBody CatalogosGenericosRequest request,BindingResult bindingResult, HttpServletRequest req) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("Error Validacion", HttpStatus.BAD_REQUEST);
		}
		CatalogosGenericos entidad = mapper.map(request, CatalogosGenericos.class);
		catalogoGenericoS.save(entidad);
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
	

}
