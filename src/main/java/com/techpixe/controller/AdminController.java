package com.techpixe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController 
{
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome()
	{
		String message  = "Welcome to Admin !!";
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
}
