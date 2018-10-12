package com.sush.dao;

import com.sush.model.Customer;
import com.sush.model.User;

public interface CustomerDao
{
	void registerCustomer(Customer customer);
	boolean isEmailValid(String email);
	boolean isUsernameValid(String username);
	User getUser(String username);
}
