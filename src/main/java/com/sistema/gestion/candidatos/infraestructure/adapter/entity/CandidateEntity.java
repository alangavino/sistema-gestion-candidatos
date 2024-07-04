package com.sistema.gestion.candidatos.infraestructure.adapter.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sistema.gestion.candidatos.domain.model.constant.Gender;
import com.sistema.gestion.candidatos.domain.model.constant.Status;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "candidates")
@Data
@Accessors(chain = true)
public class CandidateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	@NotNull
	@Column(columnDefinition = "ENUM('male', 'feminine')")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private Double salary;
	private String position;

	@NotNull
	@Column(columnDefinition = "ENUM('pre_selection', 'selection', 'hiring','incorporation')")
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "creation_date")
	private Instant creationDate;

	@Column(name = "modification_date")
	private Instant modificationDate;
}
