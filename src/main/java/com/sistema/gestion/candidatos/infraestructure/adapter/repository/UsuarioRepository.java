package com.sistema.gestion.candidatos.infraestructure.adapter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.gestion.candidatos.infraestructure.adapter.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	Optional<UsuarioEntity> findByName(String name);
	Optional<UsuarioEntity> findUsuarioByUsername(String username);
	public Boolean  existsByUsername(String username);
	public Boolean  existsByEmail(String email);


}