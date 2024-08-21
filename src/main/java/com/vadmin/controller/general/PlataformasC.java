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
import com.vadmin.entities.general.Plataformas;
import com.vadmin.request.general.PlataformasRequest;
import com.vadmin.response.general.PlataformasResponse;
import com.vadmin.service.general.IplataformasS;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestControllerAdmin
@RestController
public class PlataformasC {
	
	private IplataformasS plataformasS;
    private ModelMapper mapper;

	@Autowired
	public void setPlataformasS(IplataformasS plataformasS) {
		this.plataformasS = plataformasS;
	}

    @Autowired
	public void setMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}


    @PostMapping("/plataformas")
	public ResponseEntity<Object> save(@Valid @RequestBody PlataformasRequest request,BindingResult bindingResult, HttpServletRequest req) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("Error Validacion", HttpStatus.BAD_REQUEST);
		}
		Plataformas entidad = mapper.map(request, Plataformas.class);
		plataformasS.save(entidad);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entidad.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
    
	@GetMapping(value = "/plataformas/{id}")
	public EntityModel<PlataformasResponse> findRecordById(@PathVariable Long id) throws NotFoundException {
		Optional<Plataformas> optional = plataformasS.findRecordById(id);
		
		if (optional.isEmpty()) {
			throw new NotFoundException("ID NO ENCONTRADO " + id);
		}
		 Plataformas plataformas = optional.get();
		 PlataformasResponse response = mapper.map(plataformas, PlataformasResponse.class);

		 response.add(linkTo(methodOn(PlataformasC.class)
                 .findRecordById(id)).withSelfRel());
		 return EntityModel.of(response);
	}
	
	@GetMapping(value = "/plataformas")
	public ResponseEntity<List<PlataformasResponse>> findAll() throws NotFoundException {
		List<Plataformas> findAll = plataformasS.findAll();
		Type listType = new TypeToken<List<PlataformasResponse>>(){}.getType();
		List<PlataformasResponse> toResponse = mapper.map(findAll,listType);
		toResponse.forEach(
				data ->  data.add(linkTo(methodOn(PlataformasC.class)
		                 .findRecordById(data.getId())).withSelfRel())
				);
		
		return new ResponseEntity<>(toResponse, HttpStatus.OK);
	}
	
	@PutMapping("/plataformas")
	public ResponseEntity<Object> update(@RequestBody PlataformasRequest request) {
		Plataformas entidad = mapper.map(request, Plataformas.class);
		plataformasS.save(entidad);
		PlataformasResponse response = mapper.map(entidad, PlataformasResponse.class);
		
		 response.add(linkTo(methodOn(PlataformasC.class)
                 .findRecordById(response.getId())).withSelfRel());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/plataformas/{id}") 
	public ResponseEntity<?> delete(@PathVariable Long id) {
		plataformasS.delete(id);
		return ResponseEntity.noContent().build();
	}


}
