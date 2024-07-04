package com.sistema.gestion.candidatos.infraestructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sistema.gestion.candidatos.domain.model.Login;
import com.sistema.gestion.candidatos.domain.model.dto.request.LoginRequestDTO;
import com.sistema.gestion.candidatos.domain.port.LoginPort;
import com.sistema.gestion.candidatos.infraestructure.rest.security.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginAdapter implements LoginPort{
	
		
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider   jwtTokenProvider;
	
	@Override
	public Login authToken(LoginRequestDTO request) {
	
		Authentication authenticaion= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authenticaion);
		
		String token=jwtTokenProvider.generarToken(authenticaion);
		
		return new Login().setAccesTtoken(token).setTypeToken("Bearer");
	}

}
