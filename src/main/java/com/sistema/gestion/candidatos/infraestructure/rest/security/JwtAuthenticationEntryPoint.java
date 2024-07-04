package com.sistema.gestion.candidatos.infraestructure.rest.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

	final String ERROR_MESSAGE= "User not authorized";

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        
        Map<String ,String > rsp =new HashMap<>(); 
       
		rsp.put("code", HttpStatus.UNAUTHORIZED.value() + "") ;		
        rsp.put("msg", ERROR_MESSAGE) ;
        rsp.put("path", request.getServletPath());
        rsp.put("timestamp", System.currentTimeMillis() + "");
       
        response.getWriter().write(new ObjectMapper().writeValueAsString(rsp));
        response.getWriter().flush();
		response.getWriter().close();        

		
	}

	
}
