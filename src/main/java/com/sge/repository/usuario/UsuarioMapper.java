package com.sge.repository.usuario;

import org.mapstruct.Mapper;

import com.sge.domain.Persona;
import com.sge.domain.Rol;
import com.sge.domain.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	default Usuario entityToDomain(UsuarioEntity entity) {
		if (entity == null) {
			return null;
		}
		Persona persona = new Persona(entity.getPersona().getPersId(), entity.getPersona().getPersNombre(),
				entity.getPersona().getPersApellido());
		Rol rol = new Rol(entity.getRol().getRolId(), entity.getRol().getRolNombre());

		return new Usuario(entity.getUsuarioId(), entity.getMail(), entity.getUsername(), entity.isEnabled(), persona,
				rol);
	}
}
