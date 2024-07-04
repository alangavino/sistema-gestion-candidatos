package com.sistema.gestion.candidatos.application.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.sistema.gestion.candidatos.application.mapper.AppMapperObject;
import com.sistema.gestion.candidatos.application.usecases.UsuarioService;
import com.sistema.gestion.candidatos.domain.model.dto.UsuarioResponseDTO;
import com.sistema.gestion.candidatos.domain.model.dto.request.UsuarioRequestDTO;
import com.sistema.gestion.candidatos.domain.port.UsuarioPersistencePort;
import com.sistema.gestion.candidatos.infraestructure.adapter.exception.ResourceNotFoundException;
import com.sistema.gestion.candidatos.domain.model.Usuario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioManagementService implements UsuarioService{
	
	private final UsuarioPersistencePort usuarioPersistencePort;

	private final AppMapperObject appMapperObject;	
	
	@Autowired
	private PasswordEncoder   passwordEncoder;
	
	@Override
	public List<UsuarioResponseDTO> findAllUsuarios() {
	
		List<Usuario> usuarios= usuarioPersistencePort.findAll();
		
		return usuarios.stream()
				 .map(usuario->appMapperObject.mapearUsuarioToUsuarioRs(usuario)).collect(Collectors.toList());
	}

	@Override
	public UsuarioResponseDTO createUsuario(UsuarioRequestDTO usuario) {

		if(usuarioPersistencePort.existsByUsername(usuario.getUsername())) {
			throw new ResourceNotFoundException("That username already exists");
			
		}
		
		if(usuarioPersistencePort.existsByEmail(usuario.getEmail())) {
			throw new ResourceNotFoundException("That user email already exists");
			
		}
		
		Usuario usuarioMap= appMapperObject.mapearUsuarioRqTOUsuario(usuario,passwordEncoder);

		
		return appMapperObject.mapearUsuarioToUsuarioRs(usuarioPersistencePort.createUsuario(usuarioMap));
	}

	@Override
	public void deleteUsuarioById(long id) {

		 if (!usuarioPersistencePort.existsById(id)) {
		      throw new ResourceNotFoundException("Not found Usuario with id = " + id);
		    }
		 
		 usuarioPersistencePort.deleteUsuarioById(id);
	}

}
