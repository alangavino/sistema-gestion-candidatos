package com.sistema.gestion.candidatos.infraestructure.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sistema.gestion.candidatos.domain.model.Candidate;
import com.sistema.gestion.candidatos.domain.port.CandidatePersistencePort;
import com.sistema.gestion.candidatos.infraestructure.adapter.entity.CandidateEntity;
import com.sistema.gestion.candidatos.infraestructure.adapter.mapper.InfraMapperObject;
import com.sistema.gestion.candidatos.infraestructure.adapter.repository.CandidateRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CandidateJpaAdapter implements CandidatePersistencePort{

	private final CandidateRepository candidateRepository;
	private final InfraMapperObject infraMapperObject;	
	
	@Override
	public Candidate create(Candidate candidate) {
		
		CandidateEntity candidateEntity=infraMapperObject.mapearCandidateTOCandidateEntity(candidate);
	
		CandidateEntity newCandidateEntity=candidateRepository.save(candidateEntity);
		
		return infraMapperObject.mapearCandidateEntityTOCandidate(newCandidateEntity);
	}

	@Override
	public Optional<Candidate> findById(Long id) {
		
		Optional<CandidateEntity> candidateEntityOpt =candidateRepository.findById(id);
		
		if(!candidateEntityOpt.isPresent()) {
			return Optional.empty();
			
		}
		return Optional.of(infraMapperObject.mapearCandidateEntityTOCandidate(candidateEntityOpt.get()));
	}

	@Override
	public Optional<Candidate> findByEmail(String email) {
		
		Optional<CandidateEntity> candidateEntityOpt =candidateRepository.findCandidateByEmail(email);
		
		if(!candidateEntityOpt.isPresent()) {
			return Optional.empty();
			
		}
		return Optional.of(infraMapperObject.mapearCandidateEntityTOCandidate(candidateEntityOpt.get()));
		

	}

	@Override
	public List<Candidate> getAll() {
		List<CandidateEntity> candidatesEntity=candidateRepository.findAll();
		return candidatesEntity.stream().map(candidateEntity->infraMapperObject.mapearCandidateEntityTOCandidate(candidateEntity)).collect(Collectors.toList());
	}

	@Override
	public Candidate update(Candidate candidate) {
		CandidateEntity candidateEntity=infraMapperObject.mapearCandidateTOCandidateEntity(candidate);
		CandidateEntity newCandidateEntity=candidateRepository.save(candidateEntity);
		return infraMapperObject.mapearCandidateEntityTOCandidate(newCandidateEntity);
	}
	
	@Override
	public void deleteCandidate(Long id) {
	
		candidateRepository.deleteById(id);
	}



}
