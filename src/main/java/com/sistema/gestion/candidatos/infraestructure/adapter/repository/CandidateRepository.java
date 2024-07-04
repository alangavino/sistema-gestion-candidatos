package com.sistema.gestion.candidatos.infraestructure.adapter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.gestion.candidatos.infraestructure.adapter.entity.CandidateEntity;



public interface CandidateRepository extends JpaRepository<CandidateEntity, Long>{

	public Optional<CandidateEntity> findCandidateByEmail(String email);
}
