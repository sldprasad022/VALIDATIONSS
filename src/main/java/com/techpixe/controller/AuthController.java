package com.techpixe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController 
{
	@GetMapping("/get")
	public ResponseEntity<String> get()
	{
		String msg = "Auth can be access by anyone.";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
