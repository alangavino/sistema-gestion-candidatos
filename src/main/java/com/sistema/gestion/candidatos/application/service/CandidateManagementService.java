package com.sistema.gestion.candidatos.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sistema.gestion.candidatos.application.mapper.AppMapperObject;
import com.sistema.gestion.candidatos.application.usecases.CandidateService;
import com.sistema.gestion.candidatos.domain.model.Candidate;
import com.sistema.gestion.candidatos.domain.model.dto.CandidateResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.CandidateRequestDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.CandidateUpdateRequestDTO;
import com.sistema.gestion.candidatos.domain.port.CandidatePersistencePort;
import com.sistema.gestion.candidatos.infraestructure.adapter.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidateManagementService implements CandidateService {

	private final CandidatePersistencePort candidatePersistencePort;
	private final AppMapperObject appMapperObject;	
	@Override
	public CandidateResponseDTO createCandidate(CandidateRequestDTO resquest) {
		
	
			if(candidatePersistencePort.findByEmail(resquest.getEmail()).isPresent()) {
				
				throw new  ResourceNotFoundException("the candidate is in process with email = " + resquest.getEmail());
			}
	     
	     
		Candidate candidate=appMapperObject.mapearCandidateRqTOCandidate(resquest);
		
		Candidate newCandidate=	candidatePersistencePort.create(candidate);
		
		return appMapperObject.mapearCandidateTOCandidateRs(newCandidate);
	
	}

	@Override
	public CandidateResponseDTO getCandidateById(Long id) {
		Candidate candidate=candidatePersistencePort.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Candidate with id = " + id));

		return appMapperObject.mapearCandidateTOCandidateRs(candidate);

	}

	@Override
	public List<CandidateResponseDTO> getAllCandidates() {
		List<Candidate> candidates=candidatePersistencePort.getAll();
		return candidates.stream().map(candidate->appMapperObject.mapearCandidateTOCandidateRs(candidate)).collect(Collectors.toList());
	}

	@Override
	public CandidateResponseDTO updateCandidate(CandidateUpdateRequestDTO resquest, Long id) {
	
		Candidate candidateOld=candidatePersistencePort.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("Not found Candidate with id = " + id));
		
		Candidate candidate=appMapperObject.mapearCandidateUpdateRqTOCandidate(candidateOld,resquest);
		
		return appMapperObject.mapearCandidateTOCandidateRs(candidatePersistencePort.update(candidate));

	}

	@Override
	public void deleteCandidate(Long id) {
		candidatePersistencePort.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Candidate with id = " + id));

		candidatePersistencePort.deleteCandidate(id);
	}
	
}
