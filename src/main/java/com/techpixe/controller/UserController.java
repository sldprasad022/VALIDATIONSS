package com.techpixe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techpixe.entity.User;
import com.techpixe.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestParam String username,@RequestParam String email,@RequestParam String mobilenumber,@RequestParam String password)
	{
		User savedUser = userService.saveUser(username, email, mobilenumber, password);
		return new ResponseEntity<User>(savedUser,HttpStatus.OK);
	}
}
