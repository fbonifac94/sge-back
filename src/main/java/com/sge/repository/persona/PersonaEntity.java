package com.sge.repository.persona;

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
@Table(name = "personas")
@NoArgsConstructor
@Data
public class PersonaEntity implements Serializable {

	private static final long serialVersionUID = 494484390790205032L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pers_id")
	private Long persId;

	@Column(name = "pers_nombre")
	private String persNombre;

	@Column(name = "pers_apellido")
	private String persApellido;

	public PersonaEntity(Long persId) {
		this.persId = persId;
	}

	public PersonaEntity(String persNombre, String persApellido) {
		this.persNombre = persNombre;
		this.persApellido = persApellido;
	}

}
