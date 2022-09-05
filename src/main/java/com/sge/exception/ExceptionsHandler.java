package com.sge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { AuthenticationException.class })
	protected ResponseEntity<Object> handleConflict(AuthenticationException ex, WebRequest request) {
		BodyBuilder status = ResponseEntity.status(HttpStatus.UNAUTHORIZED);
		if (ex.getClass().isAssignableFrom(UsernameNotFoundException.class)
				| ex.getClass().isAssignableFrom(BadCredentialsException.class)) {
			return status.body("Usuario o contraseña invalida.");
		} else if (ex.getClass().isAssignableFrom(DisabledException.class)) {
			return status.body("Usuario bloqueado.");
		}
		return status.build();
	}
}
