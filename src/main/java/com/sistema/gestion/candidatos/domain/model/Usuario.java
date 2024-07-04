package com.sistema.gestion.candidatos.domain.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

	private Long id;	
	private String name;
	private String lastName;
	private String username;
    private String password; 
    private String email;
	private Instant creationDate;
}
