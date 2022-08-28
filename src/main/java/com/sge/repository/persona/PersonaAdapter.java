package com.sge.repository.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaAdapter {

	@Autowired
	private PersonaRepository personaRepository;

	public PersonaEntity insertPersona(String nombre, String apellido) {
		PersonaEntity personaEntity = new PersonaEntity(nombre, apellido);
		return personaRepository.save(personaEntity);
	}
}
