package com.sge.auth;

import org.springframework.stereotype.Service;

import com.sge.repository.usuario.UsuarioEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtService {

	
	public String generateJwt(UsuarioEntity usuario) {
		if (!usuario.isEnabled()) {
			
		}
		
		Claims claims = Jwts.claims();
		
		return null;
	}
}
