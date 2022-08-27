package com.sge.repository.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

	@Query("SELECT u FROM UsuarioEntity u WHERE u.username = :username")
	Optional<UsuarioEntity> findByUsername(String username);
}
