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
import com.vadmin.entities.general.PlataformasVideojuegos;
import com.vadmin.request.general.PlataformasVideojuegosRequest;
import com.vadmin.response.general.PlataformasVideojuegosResponse;
import com.vadmin.service.general.IplataformasVideojuegosS;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestControllerAdmin
@RestController
public class PlataformasVideojuegosC {
	
	private IplataformasVideojuegosS plataformasVideojuegosS;
    private ModelMapper mapper;

    @Autowired
	public void setMapper(ModelMapper mapper) {
		this.mapper = mapper;
		PropertyMap<PlataformasVideojuegosRequest, PlataformasVideojuegos> mappingRequestToEntidad = new PropertyMap<PlataformasVideojuegosRequest, PlataformasVideojuegos>() {
			   protected void configure() {
			      map().getFkPlataforma().setId(source.getFkPlataforma());
			      map().getFkVideojuegos().setId(source.getFkVideojuegos());
			   }
			};

		this.mapper.addMappings(mappingRequestToEntidad);
	}

	@Autowired
	public void setPlataformasVideojuegosS(IplataformasVideojuegosS plataformasVideojuegosS) {
		this.plataformasVideojuegosS = plataformasVideojuegosS;
		
	}


	@PostMapping("/plataformas-videojuegos")
	public ResponseEntity<Object> save(@Valid @RequestBody PlataformasVideojuegosRequest request, BindingResult bindingResult,
			HttpServletRequest req) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("Error Validacion", HttpStatus.BAD_REQUEST);
		}
		PlataformasVideojuegos entidad = mapper.map(request, PlataformasVideojuegos.class);
		plataformasVideojuegosS.save(entidad);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entidad.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(value = "/plataformas-videojuegos/{id}")
	public EntityModel<PlataformasVideojuegosResponse> findRecordById(@PathVariable Long id) throws NotFoundException {
		Optional<PlataformasVideojuegos> optional = plataformasVideojuegosS.findRecordById(id);

		if (optional.isEmpty()) {
			throw new NotFoundException("ID NO ENCONTRADO " + id);
		}
		PlataformasVideojuegos entidad = optional.get();
		PlataformasVideojuegosResponse response = mapper.map(entidad, PlataformasVideojuegosResponse.class);

		response.add(linkTo(methodOn(VideojuegosC.class).findRecordById(id)).withSelfRel());
		response.getFkPlataforma().add(linkTo(methodOn(PlataformasC.class)
                 .findRecordById(response.getFkPlataforma().getId())).withSelfRel());
		response.getFkVideojuegos().add(linkTo(methodOn(VideojuegosC.class)
                .findRecordById(response.getFkVideojuegos().getId())).withSelfRel());
		
		return EntityModel.of(response);
	}
	
	@GetMapping(value = "/plataformas-videojuegos")
	public ResponseEntity<List<PlataformasVideojuegosResponse>> findAll() throws NotFoundException {
		List<PlataformasVideojuegos> findAll = plataformasVideojuegosS.findAll();
		Type listType = new TypeToken<List<PlataformasVideojuegosResponse>>() {
		}.getType();
		List<PlataformasVideojuegosResponse> toResponse = mapper.map(findAll, listType);
		toResponse.forEach(
				data ->{ data.add(linkTo(methodOn(PlataformasVideojuegosC.class).findRecordById(data.getId())).withSelfRel());
				         data.getFkPlataforma().add(linkTo(methodOn(PlataformasC.class).findRecordById(data.getId())).withSelfRel());
				         data.getFkVideojuegos().add(linkTo(methodOn(VideojuegosC.class).findRecordById(data.getId())).withSelfRel());
					}
				);

		return new ResponseEntity<>(toResponse, HttpStatus.OK);
	}
	
	@PutMapping("/plataformas-videojuegos")
	public ResponseEntity<Object> update(@RequestBody PlataformasVideojuegosRequest request) {
		PlataformasVideojuegos entidad = mapper.map(request, PlataformasVideojuegos.class);
		PlataformasVideojuegos saveEntidad = plataformasVideojuegosS.save(entidad);
		PlataformasVideojuegosResponse response = mapper.map(saveEntidad, PlataformasVideojuegosResponse.class);

		response.add(linkTo(methodOn(PlataformasVideojuegosC.class).findRecordById(response.getId())).withSelfRel());
		response.getFkPlataforma().add(linkTo(methodOn(PlataformasC.class)
                .findRecordById(response.getFkPlataforma().getId())).withSelfRel());
		response.getFkVideojuegos().add(linkTo(methodOn(VideojuegosC.class)
               .findRecordById(response.getFkVideojuegos().getId())).withSelfRel());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/plataformas-videojuegos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		plataformasVideojuegosS.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
