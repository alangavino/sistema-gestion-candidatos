package com.sistema.gestion.candidatos.domain.model.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UsuarioRequestDTO {
	
	@NotBlank(message="The name must not be empty or null")
	private String name;
	@NotBlank(message="The name must not be empty or null")
	private String lastName;	
	@NotBlank(message="The name must not be empty or null")
	private String username;
	@NotBlank(message="The name must not be empty or null")
	private String password;
	@Email
	@NotBlank(message="The email must not be empty or null")
	private String email;


	
}
