package com.sush.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sush.dao.CategoryDAO;
import com.sush.model.Category;

public class CategoryDAOTest {
	
    static CategoryDAO categoryDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sush");
		context.refresh();
	    categoryDAO=(CategoryDAO)context.getBean("CategoryDAO");
	}
    @Test
    public void addCategoryTest()
    {
    	Category category=new Category();
    	category.setCategoryName("Sony");
        category.setCategoryDescr("All sony LED TV's");
        assertTrue("Problem in Adding Category:",categoryDAO.addCategory(category));
    }
}
