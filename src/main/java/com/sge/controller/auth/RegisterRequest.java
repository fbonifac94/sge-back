package com.sge.controller.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {

	private String nombre;

	private String apellido;

	private String username;

	private String password;

	private String mail;
}
