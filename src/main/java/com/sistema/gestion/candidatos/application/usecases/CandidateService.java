package com.sistema.gestion.candidatos.application.usecases;

import java.util.List;

import com.sistema.gestion.candidatos.domain.model.dto.CandidateResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.CandidateRequestDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.CandidateUpdateRequestDTO;

public interface CandidateService {
	public CandidateResponseDTO createCandidate(CandidateRequestDTO resquest);
	public CandidateResponseDTO getCandidateById(Long id);
	public List<CandidateResponseDTO> getAllCandidates();
	public CandidateResponseDTO updateCandidate(CandidateUpdateRequestDTO resquest,Long id);
    public void deleteCandidate(Long id);
}
