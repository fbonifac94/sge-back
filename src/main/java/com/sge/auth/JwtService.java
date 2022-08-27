package com.sge.auth;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.sge.domain.Usuario;

@Service
public class JwtService {

	private final Algorithm hmac512;
	private final JWTVerifier verifier;

	@Value("${jwt.expiration.minutes}")
	private Integer expirationMinutes;

	public JwtService(@Value("${jwt.secret}") final String secret) {
		this.hmac512 = Algorithm.HMAC512(secret);
		this.verifier = JWT.require(this.hmac512).build();
	}

	public String generateJwt(Usuario usuario) {
		LocalDateTime createDate = LocalDateTime.now();
		LocalDateTime expireDate = createDate.plusMinutes(60);

		return JWT.create()
				.withSubject(usuario.getUsername())
				.withClaim("rol", usuario.getRol().getNombre())
				.withIssuedAt(Date.from(createDate.atZone(ZoneId.systemDefault()).toInstant()))
				.withExpiresAt(Date.from(expireDate.atZone(ZoneId.systemDefault()).toInstant()))
				.sign(this.hmac512);
	}
	
	public String validateTokenAndGetUsername(final String token) {
        try {
            return verifier.verify(token).getSubject();
        } catch (final JWTVerificationException verificationEx) {
            return null;
        }
    }
};