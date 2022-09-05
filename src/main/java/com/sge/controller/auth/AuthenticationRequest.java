package com.sge.controller.auth;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticationRequest {

	@NotBlank(message = "El campo username no puede ser nulo ni vacio.")
	private String username;
	
	@NotBlank(message = "El campo password no puede ser nulo ni vacio.")
	private String password;
}
