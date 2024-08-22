package com.vadmin.controller.general;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
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
import com.vadmin.conf.api.NotFoundException;
import com.vadmin.conf.api.RestControllerAdmin;
import com.vadmin.entities.general.GeneroVideojuegos;
import com.vadmin.request.general.GeneroVideojuegosRequest;
import com.vadmin.response.general.GeneroVideojuegosResponse;
import com.vadmin.service.general.IgeneroVideojuegosS;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestControllerAdmin
@RestController
public class GeneroVideojuegosC {
	
	private IgeneroVideojuegosS generoVideojuegosS;
    private ModelMapper mapper;

    @Autowired
	public void setGeneroVideojuegosS(IgeneroVideojuegosS generoVideojuegosS) {
		this.generoVideojuegosS = generoVideojuegosS;
	}

    @Autowired
	public void setMapper(ModelMapper mapper) {
		this.mapper = mapper;
		
		PropertyMap<GeneroVideojuegosRequest, GeneroVideojuegos> mappingRequestToEntidad = new PropertyMap<GeneroVideojuegosRequest, GeneroVideojuegos>() {
			   protected void configure() {
			      map().getFkVideojuegos().setId(source.getFkVideojuegos());
			   }
			};

		this.mapper.addMappings(mappingRequestToEntidad);
	}
    
    @PostMapping("/genero-videojuegos")
	public ResponseEntity<Object> save(@Valid @RequestBody GeneroVideojuegosRequest request, BindingResult bindingResult,
			HttpServletRequest req) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("Error Validacion", HttpStatus.BAD_REQUEST);
		}
		GeneroVideojuegos entidad = mapper.map(request, GeneroVideojuegos.class);
		generoVideojuegosS.save(entidad);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entidad.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(value = "/genero-videojuegos/{id}")
	public EntityModel<GeneroVideojuegosResponse> findRecordById(@PathVariable Long id) throws NotFoundException {
		Optional<GeneroVideojuegos> optional = generoVideojuegosS.findRecordById(id);

		if (optional.isEmpty()) {
			throw new NotFoundException("ID NO ENCONTRADO " + id);
		}
		GeneroVideojuegos entidad = optional.get();
		GeneroVideojuegosResponse response = mapper.map(entidad, GeneroVideojuegosResponse.class);

		response.add(linkTo(methodOn(VideojuegosC.class).findRecordById(id)).withSelfRel());
		response.getFkVideojuegos().add(linkTo(methodOn(VideojuegosC.class)
                .findRecordById(response.getFkVideojuegos().getId())).withSelfRel());
		
		return EntityModel.of(response);
	}
	
	@GetMapping(value = "/genero-videojuegos")
	public ResponseEntity<List<GeneroVideojuegosResponse>> findAll() throws NotFoundException {
		List<GeneroVideojuegos> findAll = generoVideojuegosS.findAll();
		Type listType = new TypeToken<List<GeneroVideojuegosResponse>>() {
		}.getType();
		List<GeneroVideojuegosResponse> toResponse = mapper.map(findAll, listType);
		toResponse.forEach(
				data ->{ data.add(linkTo(methodOn(GeneroVideojuegosC.class).findRecordById(data.getId())).withSelfRel());
				         data.getFkVideojuegos().add(linkTo(methodOn(VideojuegosC.class).findRecordById(data.getId())).withSelfRel());
					}
				);

		return new ResponseEntity<>(toResponse, HttpStatus.OK);
	}
	
	@PutMapping("/genero-videojuegos")
	public ResponseEntity<Object> update(@RequestBody GeneroVideojuegosRequest request) {
		GeneroVideojuegos entidad = mapper.map(request, GeneroVideojuegos.class);
		GeneroVideojuegos saveEntidad = generoVideojuegosS.save(entidad);
		GeneroVideojuegosResponse response = mapper.map(saveEntidad, GeneroVideojuegosResponse.class);

		response.add(linkTo(methodOn(GeneroVideojuegosC.class).findRecordById(response.getId())).withSelfRel());
		response.getFkVideojuegos().add(linkTo(methodOn(VideojuegosC.class)
               .findRecordById(response.getFkVideojuegos().getId())).withSelfRel());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/genero-videojuegos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		generoVideojuegosS.delete(id);
		return ResponseEntity.noContent().build();
	}
    
    

}
