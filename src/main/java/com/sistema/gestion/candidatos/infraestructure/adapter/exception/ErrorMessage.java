package com.sistema.gestion.candidatos.infraestructure.adapter.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorMessage {

	  private int statusCode;
	  private Date timestamp;
	  private String message;
	  private String description;
}
