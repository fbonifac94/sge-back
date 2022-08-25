package com.sge.repository.persona;

import static javax.persistence.GenerationType.IDENTITY;

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
public class PersonaEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pers_id")
	private Long persId;
	
	@Column(name = "pers_nombre")
	private String persNombre;
	
	@Column(name = "pers_apellido")
	private String persApellido;
	
}
