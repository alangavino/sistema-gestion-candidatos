package com.sistema.gestion.candidatos.domain.model.dto.request;


import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequestDTO {
	@NotBlank(message="The userName must not be empty or null")
	private String userName;
	@NotBlank(message="The password must not be empty or null")
	private String password;
	
}
