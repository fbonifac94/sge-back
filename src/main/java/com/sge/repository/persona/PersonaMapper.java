package com.sge.repository.persona;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sge.domain.Persona;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

	@Mapping(source = "entity.persId", target = "id")
	@Mapping(source = "entity.persNombre", target = "nombre")
	@Mapping(source = "entity.persApellido", target = "apellido")
	public Persona entityToDomain(PersonaEntity entity);
}
