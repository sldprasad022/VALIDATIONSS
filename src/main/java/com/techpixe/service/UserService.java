package com.techpixe.service;

import com.techpixe.entity.User;

public interface UserService 
{
	public User saveUser(String username,String email,String mobilenumber,String password);
}
