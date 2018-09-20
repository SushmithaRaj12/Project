package com.sush.dao;

import com.sush.model.User;

public interface UserDAO {
	public boolean registerUser(User user);
	public boolean modifyUser(User user);
	public User  getUser(String username);
	
}
