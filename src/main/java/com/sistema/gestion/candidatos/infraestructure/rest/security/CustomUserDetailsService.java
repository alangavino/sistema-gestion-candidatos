package com.sistema.gestion.candidatos.infraestructure.rest.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.sistema.gestion.candidatos.infraestructure.adapter.entity.UsuarioEntity;
import com.sistema.gestion.candidatos.infraestructure.adapter.exception.ResourceNotFoundException;
import com.sistema.gestion.candidatos.infraestructure.adapter.repository.UsuarioRepository;




@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws ResourceNotFoundException {

		UsuarioEntity usuario = usuarioRepository.findUsuarioByUsername(username).orElseThrow(
				() -> new ResourceNotFoundException("User not found with username :" + username));		

		return new User(usuario.getUsername(),usuario.getPassword(),getRolesDefault());

	}
		private List<GrantedAuthority> getRolesDefault(){
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			return authorities;
			 		
		
	}	
}
