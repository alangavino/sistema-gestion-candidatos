package com.sistema.gestion.candidatos.domain.model;


import java.time.Instant;

import com.sistema.gestion.candidatos.domain.model.constant.Gender;
import com.sistema.gestion.candidatos.domain.model.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Candidate {

	private Long id;	
	private String name;
	private String email;
	private Gender gender;	
	private Double salary;
	private String position;	
	private Status status;
	private Instant creationDate;
	private Instant modificationDate;
}
