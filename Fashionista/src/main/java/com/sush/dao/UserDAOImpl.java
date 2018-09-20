package com.sush.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sush.model.User;

@Repository("UserDAO")
@Transactional

public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(User user) {
		try
		{
			System.out.println("im in userdao");
			sessionFactory.getCurrentSession().save(user);
			System.out.println("saved user successfully");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("user failed");
		return false;
		}
	}

	@Override
	public boolean modifyUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Update failed");
		return false;
		}
	}

	@Override
	public User getUser(String username) {
		Session session=sessionFactory.openSession();
		User user=session.get(User.class,username);
		session.close();
		return user;
	}

}
