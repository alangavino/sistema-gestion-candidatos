package com.sistema.gestion.candidatos.application.usecases;

import com.sistema.gestion.candidatos.domain.model.dto.LoginResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.LoginRequestDTO;

public interface LoginService {
	LoginResponseDTO authToken(LoginRequestDTO request);

}
