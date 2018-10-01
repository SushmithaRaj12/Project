package com.sush.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sush.model.Category;

@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
    @Autowired
    SessionFactory sessionFactory;
    
	@Override
	public boolean addCategory(Category category) {
		try
		{
			System.out.println("Entering add Cat");
			Session session = sessionFactory.getCurrentSession();
			//System.out.println("Session : "+ (session == null)+" => " + session);
			session.save(category);
			System.out.println("Inserted cat successfully");
			//session.close();
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Insert cat failed");
		return false;	
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().delete(category);
		return true;
		}
		catch(Exception e)
		{
		
		return false;
	    }
	}

	@Override
	public boolean updateCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().update(category);
		return true;
		}
		catch(Exception e)
		{
		return false;
	    }
	}	

	@Override
	public List<Category> listCategories() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category>listcategories=query.list();
		session.close();
		return listcategories;
	}

	@Override
	public Category getCategory(int categoryId) {
		Session session=sessionFactory.openSession();  
		Category category=(Category)session.get(Category.class, categoryId);
		session.close();
		return category;
	}
	
}
