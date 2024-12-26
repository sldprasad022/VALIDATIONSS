package com.techpixe.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.techpixe.entity.User;
import com.techpixe.repository.UserRepository;
import com.techpixe.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(String username, String email, String mobilenumber, String password)
	{
		
		System.err.println("called");
		//1st Approach for validating mobile Number
//		if (mobilenumber != null && (mobilenumber < 1000000000L || mobilenumber > 9999999999L)) 
//		{
//		    throw new IllegalArgumentException("Mobile number must be exactly 10 digits");
//		}
		
		User existsEmail = userRepository.findByEmail(email);
		
		if (existsEmail!=null)
		{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Email already exists");
		}
		
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setMobilenumber(mobilenumber);
		user.setPassword(password);
		user.setRole("ROLE_USER");
		
		return  userRepository.save(user);
		
	}

}
