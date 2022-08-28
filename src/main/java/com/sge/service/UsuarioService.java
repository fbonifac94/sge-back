package com.sge.service;

import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.sge.domain.Usuario;
import com.sge.repository.persona.PersonaAdapter;
import com.sge.repository.persona.PersonaEntity;
import com.sge.repository.rol.RolAdapter;
import com.sge.repository.rol.RolEntity;
import com.sge.repository.usuario.UsuarioAdapter;
import com.sge.repository.usuario.UsuarioMapper;
import com.sge.utils.TiposUsuarios;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioAdapter usuarioAdapter;

	@Autowired
	private PersonaAdapter personaAdapter;

	@Autowired
	private RolAdapter rolAdapter;

	@Autowired
	private UsuarioMapper usuarioMapper;

	public Usuario getUsuarioByUsername(String username) {
		return usuarioMapper.entityToDomain(usuarioAdapter.getUsuarioByUsername(username));
	}

	@Transactional
	public Usuario createUsuario(String tipoUsuario, String nombre, String apellido, String username, String mail,
			String password) {
		TiposUsuarios tipoUsu = Stream.of(TiposUsuarios.values()).filter(elem -> elem.getTipo().equals(tipoUsuario))
				.findFirst().orElseThrow(() -> new RuntimeException());
		PersonaEntity persona = personaAdapter.insertPersona(nombre, apellido);
		RolEntity rol = rolAdapter.findRolByNombre(tipoUsu.getRol());
		String encryptedPasswod = BCrypt.hashpw(password, BCrypt.gensalt(12));
		Boolean enabled = (tipoUsu.equals(TiposUsuarios.ALUMNO)) ? false : true;
		return usuarioMapper
				.entityToDomain(usuarioAdapter.insertUsuario(persona, rol, mail, username, encryptedPasswod, enabled));
	}
}
