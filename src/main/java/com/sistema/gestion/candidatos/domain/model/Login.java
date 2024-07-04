package com.sistema.gestion.candidatos.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Login {
	
	private String accesTtoken;
	private String typeToken;
}
