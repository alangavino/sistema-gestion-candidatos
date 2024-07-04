package com.sistema.gestion.candidatos.infraestructure.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sistema.gestion.candidatos.application.usecases.LoginService;
import com.sistema.gestion.candidatos.domain.model.dto.LoginResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.LoginRequestDTO;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@ApiOperation("Authenticate userio and generate token")
	@PostMapping("/token")
	public ResponseEntity<LoginResponseDTO> authToken(@RequestBody LoginRequestDTO request){

		return ResponseEntity.ok(loginService.authToken(request));
}
}
