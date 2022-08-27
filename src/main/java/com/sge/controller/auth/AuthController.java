package com.sge.controller.auth;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sge.auth.JwtService;
import com.sge.domain.Usuario;
import com.sge.service.UsuarioService;

@RestController
@RequestMapping
public class AuthController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private JwtService jwtService;

	@PostMapping(path = "/authenticate", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody LoginRequest body) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword()));
		Usuario usuario = usuarioService.getUsuarioByUsername(body.getUsername());
		String jwt = jwtService.generateJwt(usuario);
		return ResponseEntity.ok(jwt);
	}

}
