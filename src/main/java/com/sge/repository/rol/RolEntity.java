package com.sge.repository.rol;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Data
public class RolEntity implements Serializable {

	private static final long serialVersionUID = -5475001572181518957L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rol_id")
	private Long rolId;

	@Column(name = "rol_nombre")
	private String rolNombre;

	public RolEntity(Long rolId) {
		this.rolId = rolId;
	}
}
