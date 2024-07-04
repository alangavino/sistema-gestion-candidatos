package com.sistema.gestion.candidatos.infraestructure.adapter.entity;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UsuarioEntity {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id; 	 
	  private String name;
	  @Column(name = "lastname")
	  private String lastName;	
	  private String username;
	  private String password; 
	  private String email;
	  
	  
	  @JsonIgnore	  
	  @Column(name = "creation_date")
	  private Instant  creationDate;
	  @JsonIgnore	  
	  @Column(name = "modification_date")
	  private Instant  modificationDate;	
}
