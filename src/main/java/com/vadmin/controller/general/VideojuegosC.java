package com.vadmin.controller.general;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
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
import com.vadmin.entities.general.Videojuegos;
import com.vadmin.request.general.PlataformasRequest;
import com.vadmin.request.general.VideojuegosRequest;
import com.vadmin.response.general.VideojuegosResponse;
import com.vadmin.service.general.IvideojuegosS;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestControllerAdmin
@RestController
public class VideojuegosC {
	
	private IvideojuegosS videojuegosS;
    private ModelMapper mapper;

    @Autowired
	public void setMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}

	@Autowired
	public void setVideojuegosS(IvideojuegosS videojuegosS) {
		this.videojuegosS = videojuegosS;
	}
	
	@PostMapping("/videojuegos")
	public ResponseEntity<Object> save(@Valid @RequestBody VideojuegosRequest request, BindingResult bindingResult,
			HttpServletRequest req) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("Error Validacion", HttpStatus.BAD_REQUEST);
		}
		Videojuegos entidad = mapper.map(request, Videojuegos.class);
		videojuegosS.save(entidad);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entidad.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "/videojuegos/{id}")
	public EntityModel<VideojuegosResponse> findRecordById(@PathVariable Long id) throws NotFoundException {
		Optional<Videojuegos> optional = videojuegosS.findRecordById(id);

		if (optional.isEmpty()) {
			throw new NotFoundException("ID NO ENCONTRADO " + id);
		}
		Videojuegos videojuegos = optional.get();
		VideojuegosResponse response = mapper.map(videojuegos, VideojuegosResponse.class);

		response.add(linkTo(methodOn(VideojuegosC.class).findRecordById(id)).withSelfRel());
		return EntityModel.of(response);
	}

	@GetMapping(value = "/videojuegos")
	public ResponseEntity<List<VideojuegosResponse>> findAll() throws NotFoundException {
		List<Videojuegos> findAll = videojuegosS.findAll();
		Type listType = new TypeToken<List<VideojuegosResponse>>() {
		}.getType();
		List<VideojuegosResponse> toResponse = mapper.map(findAll, listType);
		toResponse.forEach(
				data -> data.add(linkTo(methodOn(VideojuegosC.class).findRecordById(data.getId())).withSelfRel()));

		return new ResponseEntity<>(toResponse, HttpStatus.OK);
	}

	@PutMapping("/videojuegos")
	public ResponseEntity<Object> update(@RequestBody VideojuegosRequest request) {
		Videojuegos entidad = mapper.map(request, Videojuegos.class);
		videojuegosS.save(entidad);
		VideojuegosResponse response = mapper.map(entidad, VideojuegosResponse.class);

		response.add(linkTo(methodOn(VideojuegosC.class).findRecordById(response.getId())).withSelfRel());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/videojuegos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		videojuegosS.delete(id);
		return ResponseEntity.noContent().build();
	}

}
