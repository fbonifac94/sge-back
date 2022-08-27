package com.sge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sge.domain.Usuario;
import com.sge.repository.usuario.UsuarioEntity;
import com.sge.repository.usuario.UsuarioMapper;
import com.sge.repository.usuario.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioMapper usuarioMapper;

	public Usuario getUsuarioByUsername(String username) {
		UsuarioEntity usuarioEntity = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(""));
		return usuarioMapper.entityToDomain(usuarioEntity);
	}
}
