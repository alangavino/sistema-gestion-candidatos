package com.sistema.gestion.candidatos.domain.port;

import com.sistema.gestion.candidatos.domain.model.Login;
import com.sistema.gestion.candidatos.domain.model.dto.request.LoginRequestDTO;

public interface LoginPort {

	Login authToken(LoginRequestDTO request);
}
