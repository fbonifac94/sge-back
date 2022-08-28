package com.sge.repository.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	@Query("SELECT u FROM UsuarioEntity u WHERE u.username = :username")
	Optional<UsuarioEntity> findByUsername(String username);
}
