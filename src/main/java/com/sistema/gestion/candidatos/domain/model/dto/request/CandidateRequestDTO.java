package com.sistema.gestion.candidatos.domain.model.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CandidateRequestDTO {
   
	@NotBlank(message="The name must not be empty or null")
	private String name;
	@Email
	@NotBlank(message="The email must not be empty or null")
	private String email;
	@NotBlank(message="The gender must not be empty or null")
	private String gender;
	
	private Double salary;
	@NotBlank(message="The position must not be empty or null")
	private String position; 

}
