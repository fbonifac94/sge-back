package com.sge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

	private Long id;

	private String mail;

	private String username;

	private Boolean enabled;

	private Persona persona;

	private Rol rol;
}
