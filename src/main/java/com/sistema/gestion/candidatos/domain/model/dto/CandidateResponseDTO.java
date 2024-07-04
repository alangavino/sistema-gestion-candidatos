package com.sistema.gestion.candidatos.domain.model.dto;



import com.sistema.gestion.candidatos.domain.model.constant.Gender;
import com.sistema.gestion.candidatos.domain.model.constant.Status;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CandidateResponseDTO {

	private Long id;
	private String name;
	private String email;
	private Gender gender;
	private Double salary;
	private String position;   
    private Status status;
}
