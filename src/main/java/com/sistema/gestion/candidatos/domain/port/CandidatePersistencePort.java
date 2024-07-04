package com.sistema.gestion.candidatos.domain.port;

import java.util.List;
import java.util.Optional;

import com.sistema.gestion.candidatos.domain.model.Candidate;

public interface CandidatePersistencePort {

	public Candidate create(Candidate candidate);
	public Optional<Candidate> findById(Long id);
	public Optional<Candidate> findByEmail(String email);
	public List<Candidate> getAll();
	public Candidate update(Candidate candidate);
    public void deleteCandidate(Long id);
}

