package com.sge.repository.rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolAdapter {

	@Autowired
	private RolRepository rolRepository;

	public RolEntity findRolByNombre(String nombre) {
		return rolRepository.findByNombre(nombre);
	}
}
