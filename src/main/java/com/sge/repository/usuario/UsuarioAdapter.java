package com.sge.repository.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sge.repository.persona.PersonaEntity;
import com.sge.repository.rol.RolEntity;

@Service
public class UsuarioAdapter {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioEntity getUsuarioByUsername(String username) {
		return usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(""));
	}

	public UsuarioEntity insertUsuario(PersonaEntity persona, RolEntity rol, String mail, String username,
			String password, Boolean enabled) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(persona, mail, username, password, enabled, rol);
		return usuarioRepository.save(usuarioEntity);
	}
}
