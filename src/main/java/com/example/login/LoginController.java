package com.example.login;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.login.beans.LoginInfo;
import com.example.login.exceptions.LoginException;
import com.example.login.services.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginInfo info) {
//		LoginInfo info = new LoginInfo(creds.get("username").asText(), creds.get("password").asText());
		try {
			loginService.validateUser(info);
		} catch(LoginException e) {
			
			return new ResponseEntity<Object>(Collections.singletonMap("message", e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(Collections.singletonMap("message", "Login successful!"), HttpStatus.OK);
	}

}
