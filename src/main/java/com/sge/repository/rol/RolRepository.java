package com.sge.repository.rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> {

	@Query("SELECT r FROM RolEntity r WHERE r.rolNombre = :nombre")
	public RolEntity findByNombre(String nombre);
}
