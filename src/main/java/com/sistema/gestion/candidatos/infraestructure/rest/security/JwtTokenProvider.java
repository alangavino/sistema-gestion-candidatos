package com.sistema.gestion.candidatos.infraestructure.rest.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	
  
  @Value("${app.jwt-secret}")
  private String jwtSecret;
  
  @Value("${app.jwt-expiration-milliseconds}")
  private int jwtExpirationMs;
 
  public String generarToken(Authentication authentication){
	  	  
	  String username=authentication.getName();
	  Date fechaActual= new Date();	  
	  Date fechaExpiracion= new Date(fechaActual.getTime()+jwtExpirationMs);	  
	  String token= 
			  Jwts.builder().
			  setSubject(username)		
			  .setIssuedAt(new Date()).setExpiration(fechaExpiracion)
			        .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	  
	  return token;
  }
 
  public String obtenerUsernameDelJWT(String token) {
	  
	  Claims claims=Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	  
	  return claims.getSubject();
  }
  
  public boolean validarToken(String token) {
		
	Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
	return true;
	  
  }
  
	
public String obtenerTokenDelHeader(HttpServletRequest request) {
		
		String bearerToken=request.getHeader("Authorization");
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
			return bearerToken.substring(7,bearerToken.length());
		}
		return null;
	}

	
 public Boolean hasTokenExpired(String token) {
    	
    	
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
  
}
