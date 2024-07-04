package com.sistema.gestion.candidatos.application.service;

import org.springframework.stereotype.Service;

import com.sistema.gestion.candidatos.application.mapper.AppMapperObject;
import com.sistema.gestion.candidatos.application.usecases.LoginService;
import com.sistema.gestion.candidatos.domain.model.dto.LoginResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.LoginRequestDTO;
import com.sistema.gestion.candidatos.domain.port.LoginPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginManagementService implements LoginService{

	private final AppMapperObject appMapperObject;
	private final LoginPort loginPort;	
	
	@Override
	public LoginResponseDTO authToken(LoginRequestDTO request) {

		
		return appMapperObject.mapearLoginToLoginRs(loginPort.authToken(request));
	}

}
