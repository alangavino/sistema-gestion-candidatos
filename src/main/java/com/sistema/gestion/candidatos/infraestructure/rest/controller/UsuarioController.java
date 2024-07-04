package com.sistema.gestion.candidatos.infraestructure.rest.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sistema.gestion.candidatos.application.usecases.UsuarioService;
import com.sistema.gestion.candidatos.domain.model.dto.UsuarioResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.UsuarioRequestDTO;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@ApiOperation("Get the list of usuarios")
	@GetMapping("/usuarios")
	public ResponseEntity<List<UsuarioResponseDTO>> getAllUsuarios() {

		List<UsuarioResponseDTO> usuarios = usuarioService.findAllUsuarios();

		if (usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(usuarios, HttpStatus.OK);

	}	 

	@ApiOperation("Register a new usuario")
	  @PostMapping("/registerUsuario")
	  public ResponseEntity<UsuarioResponseDTO> createUsuario(@Valid @RequestBody UsuarioRequestDTO usuario) {
	
	    return new ResponseEntity<>(usuarioService.createUsuario(usuario), HttpStatus.CREATED);
	  }

    @ApiOperation("Delete an usuario by id")
	  @DeleteMapping("/usuario/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
	   
		  usuarioService.deleteUsuarioById(id); 
		  
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
}
