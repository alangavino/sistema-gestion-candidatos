package com.sistema.gestion.candidatos.domain.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginResponseDTO {

	private String accesTtoken;
	private String typeToken;
}
