package com.vadmin.controller.general;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import com.vadmin.conf.api.RestControllerAdmin;
import com.vadmin.entities.general.CatalogosGenericos;
import com.vadmin.request.general.CatalogosGenericosRequest;
import com.vadmin.response.general.CatalogosGenericosResponse;
import com.vadmin.service.general.IcatalogoGenericoS;
import com.vadmin.conf.api.NotFoundException;

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
	public ResponseEntity<Object> save(@Valid @RequestBody CatalogosGenericosRequest request,BindingResult bindingResult, HttpServletRequest req) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("Error Validacion", HttpStatus.BAD_REQUEST);
		}
		CatalogosGenericos entidad = mapper.map(request, CatalogosGenericos.class);
		catalogoGenericoS.save(entidad);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entidad.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
    
	@GetMapping(value = "/catalogo-generico/{id}")
	public EntityModel<CatalogosGenericosResponse> findRecordById(@PathVariable Long id) throws NotFoundException {
		Optional<CatalogosGenericos> optional = catalogoGenericoS.findRecordById(id);
		
		if (optional.isEmpty()) {
			throw new NotFoundException("ID NO ENCONTRADO " + id);
		}
		 CatalogosGenericos catalogosGenericos = optional.get();
		 CatalogosGenericosResponse response = mapper.map(catalogosGenericos, CatalogosGenericosResponse.class);

		 response.add(linkTo(methodOn(CatalogosGenericosC.class)
                 .findRecordById(id)).withSelfRel());
		 return EntityModel.of(response);
	}
	
	@GetMapping(value = "/catalogo-generico")
	public ResponseEntity<List<CatalogosGenericosResponse>> findAll() throws NotFoundException {
		List<CatalogosGenericos> findAll = catalogoGenericoS.findAll();
		Type listType = new TypeToken<List<CatalogosGenericosResponse>>(){}.getType();
		List<CatalogosGenericosResponse> toResponse = mapper.map(findAll,listType);
		toResponse.forEach(
				data ->  data.add(linkTo(methodOn(CatalogosGenericosC.class)
		                 .findRecordById(data.getId())).withSelfRel())
				);
		
		return new ResponseEntity<>(toResponse, HttpStatus.OK);
	}
	
	@PutMapping("/catalogo-generico")
	public ResponseEntity<Object> update(@RequestBody CatalogosGenericosRequest request) {
		CatalogosGenericos entidad = mapper.map(request, CatalogosGenericos.class);
		catalogoGenericoS.save(entidad);
		CatalogosGenericosResponse response = mapper.map(entidad, CatalogosGenericosResponse.class);
		
		 response.add(linkTo(methodOn(CatalogosGenericosC.class)
                 .findRecordById(response.getId())).withSelfRel());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/catalogo-generico/{id}") 
	public ResponseEntity<?> delete(@PathVariable Long id) {
		catalogoGenericoS.delete(id);
		return ResponseEntity.noContent().build();
	}

}
