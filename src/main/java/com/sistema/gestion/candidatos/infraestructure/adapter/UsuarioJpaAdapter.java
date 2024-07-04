package com.sistema.gestion.candidatos.infraestructure.adapter;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sistema.gestion.candidatos.domain.model.Usuario;
import com.sistema.gestion.candidatos.domain.port.UsuarioPersistencePort;
import com.sistema.gestion.candidatos.infraestructure.adapter.entity.UsuarioEntity;
import com.sistema.gestion.candidatos.infraestructure.adapter.mapper.InfraMapperObject;
import com.sistema.gestion.candidatos.infraestructure.adapter.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioJpaAdapter implements UsuarioPersistencePort {

	private final UsuarioRepository usuarioRepository;

	private final InfraMapperObject infraMapperObject;

	@Override
	public List<Usuario> findAll() {

		List<UsuarioEntity> usuariosEntity = usuarioRepository.findAll();

		return usuariosEntity.stream()
				.map(usuarioEntity -> infraMapperObject.mapearUsuarioEntityTOUsuario(usuarioEntity))
				.collect(Collectors.toList());
	}

	@Override
	public Usuario createUsuario(Usuario usuario) {

		UsuarioEntity usuarioEntity = infraMapperObject.mapearUsuarioTOUsuarioEntity(usuario);
		UsuarioEntity newUsuarioEntity = usuarioRepository.save(usuarioEntity);

		return infraMapperObject.mapearUsuarioEntityTOUsuario(newUsuarioEntity);

	}

	@Override
	public Boolean existsByUsername(String username) {

		return usuarioRepository.existsByUsername(username);
	}

	@Override
	public Boolean existsByEmail(String email) {

		return usuarioRepository.existsByEmail(email);
	}

	@Override
	public Boolean existsById(Long id) {

		return usuarioRepository.existsById(id);
	}

	@Override
	public void deleteUsuarioById(Long id) {
		usuarioRepository.deleteById(id);

	}

}
