package com.sistema.gestion.candidatos.application.usecases;

import java.util.List;

import com.sistema.gestion.candidatos.domain.model.dto.UsuarioResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.UsuarioRequestDTO;


public interface UsuarioService {
	
	public List<UsuarioResponseDTO> findAllUsuarios();
	
	public UsuarioResponseDTO  createUsuario(UsuarioRequestDTO usuario);
	
	public void  deleteUsuarioById(long id);
}
