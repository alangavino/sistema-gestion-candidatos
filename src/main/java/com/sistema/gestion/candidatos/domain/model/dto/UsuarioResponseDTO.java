package com.sistema.gestion.candidatos.domain.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UsuarioResponseDTO {	
	
	private Long id;
	private String name;
	private String lastName;
	private String email;

}
