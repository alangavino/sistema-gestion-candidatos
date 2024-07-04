package com.sistema.gestion.candidatos.domain.port;

import java.util.List;

import com.sistema.gestion.candidatos.domain.model.Usuario;

public interface UsuarioPersistencePort {

	public List<Usuario> findAll();

	public Usuario createUsuario(Usuario usuario);

	public void deleteUsuarioById(Long id);

	public Boolean existsByUsername(String username);

	public Boolean existsByEmail(String email);

	public Boolean existsById(Long id);
}
