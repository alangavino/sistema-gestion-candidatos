package com.sistema.gestion.candidatos.application.mapper;

import java.time.Instant;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import com.sistema.gestion.candidatos.domain.model.Candidate;
import com.sistema.gestion.candidatos.domain.model.Login;
import com.sistema.gestion.candidatos.domain.model.Usuario;
import com.sistema.gestion.candidatos.domain.model.constant.Status;
import com.sistema.gestion.candidatos.domain.model.dto.CandidateResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.LoginResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.UsuarioResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.CandidateRequestDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.CandidateUpdateRequestDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.LoginRequestDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.UsuarioRequestDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppMapperObject {
	
	private final ModelMapper modelMapper;

	public Candidate  mapearCandidateRqTOCandidate(CandidateRequestDTO candidateRequestDTO) {
		Candidate candidate=modelMapper.map(candidateRequestDTO, Candidate.class);
		candidate.setCreationDate(Instant.now());
		candidate.setStatus(Status.pre_selection);
		return candidate;
	}
	
	public CandidateResponseDTO  mapearCandidateTOCandidateRs(Candidate candidate) {
		CandidateResponseDTO candidateResponseDTO=modelMapper.map(candidate, CandidateResponseDTO.class);
		return candidateResponseDTO;
	}
	
	public Candidate  mapearCandidateUpdateRqTOCandidate(Candidate candidateOld,CandidateUpdateRequestDTO candidateUpdateRequestDTO) {
		Candidate candidateRq=modelMapper.map(candidateUpdateRequestDTO, Candidate.class);		
		candidateOld.setName(candidateRq.getName());
		candidateOld.setEmail(candidateRq.getEmail());
		candidateOld.setGender(candidateRq.getGender());
		candidateOld.setSalary(candidateRq.getSalary());
		candidateOld.setPosition(candidateRq.getPosition());
		candidateOld.setStatus(candidateRq.getStatus());
		candidateOld.setModificationDate(Instant.now());
		return candidateOld;

	}

	public Usuario  mapearUsuarioRqTOUsuario(UsuarioRequestDTO usuarioRequestDTO,PasswordEncoder   passwordEncoder) {

		
		Usuario usuario=modelMapper.map(usuarioRequestDTO, Usuario.class);
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.setCreationDate(Instant.now());
		return usuario;
	}
	
	

	public UsuarioResponseDTO  mapearUsuarioToUsuarioRs(Usuario usuario) {

		
		return modelMapper.map(usuario, UsuarioResponseDTO.class);

	}	

	
	public LoginResponseDTO  mapearLoginToLoginRs(Login login) {

		
		return modelMapper.map(login, LoginResponseDTO.class);

	}
	
	
}
