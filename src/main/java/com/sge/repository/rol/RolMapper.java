package com.sge.repository.rol;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sge.domain.Rol;

@Mapper(componentModel = "spring")
public interface RolMapper {

	@Mapping(source = "entity.rolId", target = "id")
	@Mapping(source = "entity.rolNombre", target = "nombre")
	public Rol entityToDomain(RolEntity entity);
}
