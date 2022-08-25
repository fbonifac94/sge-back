package com.sge.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sge.auth.UserDetailServiceImpl;

@RestController
@RequestMapping(value = "/api/")
public class AuthController {

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@PostMapping(path = "login")
	public ResponseEntity<String> login() {
		UserDetails user = userDetailServiceImpl.loadUserByUsername("pepepares@asd.com");
		return ResponseEntity.ok(user.getUsername());
	}

}
