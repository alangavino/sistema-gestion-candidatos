package com.sistema.gestion.candidatos.infraestructure.adapter.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sistema.gestion.candidatos.domain.model.Candidate;
import com.sistema.gestion.candidatos.domain.model.Usuario;
import com.sistema.gestion.candidatos.infraestructure.adapter.entity.CandidateEntity;
import com.sistema.gestion.candidatos.infraestructure.adapter.entity.UsuarioEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InfraMapperObject {

	private final ModelMapper modelMapper;

	public CandidateEntity  mapearCandidateTOCandidateEntity(Candidate candidate) {
		CandidateEntity candidateEntity=modelMapper.map(candidate, CandidateEntity.class);
		return candidateEntity;
	}

	public Candidate  mapearCandidateEntityTOCandidate(CandidateEntity candidateEntity) {
		Candidate candidate=modelMapper.map(candidateEntity, Candidate.class);
		return candidate;
	}	

	
	public Usuario  mapearUsuarioEntityTOUsuario(UsuarioEntity usuarioEntity) {
		Usuario uuario=modelMapper.map(usuarioEntity, Usuario.class);
		return uuario;
	}
	
	public UsuarioEntity  mapearUsuarioTOUsuarioEntity(Usuario usuario) {
		UsuarioEntity usuarioEntity=modelMapper.map(usuario, UsuarioEntity.class);
		return usuarioEntity;
	}
}
