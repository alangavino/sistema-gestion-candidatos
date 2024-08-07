package com.sistema.gestion.candidatos.infraestructure.adapter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sistema.gestion.candidatos.infraestructure.rest.security.CustomUserDetailsService;
import com.sistema.gestion.candidatos.infraestructure.rest.security.JwtAuthenticationEntryPoint;
import com.sistema.gestion.candidatos.infraestructure.rest.security.JwtAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Bean
	public  JwtAuthenticationFilter jwtAuthenticationFilter(){
		return new JwtAuthenticationFilter();
		
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.exceptionHandling()         
        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
        .and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()	
		.antMatchers(
				"/api/auth/token", 
				"/api/candidates",			
				"/documentation/**", 
				"/v2/api-docs", 
				"/configuration/**", 
				"/swagger-resources/**", 
				"/swagger-ui/**").permitAll()
		.antMatchers(HttpMethod.GET, "/api/candidate/**").permitAll()
	    .anyRequest().authenticated();   
		http.headers().frameOptions().disable();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserDetailsService)
		.passwordEncoder(passwordEncoder());
		
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		
		return super.authenticationManager();
	}
}
