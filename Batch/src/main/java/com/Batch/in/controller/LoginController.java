package com.Batch.in.controller;

import com.Batch.in.dto.AuthenticationRequest;
import com.Batch.in.dto.AuthenticationResponse;
import com.Batch.in.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/auth/")
public class LoginController {


	private final LoginService loginService;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(
			@RequestBody AuthenticationRequest request
	) {
		return ResponseEntity.ok(loginService.authenticate(request));
	}


}
