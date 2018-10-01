package com.sush.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
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
	@Ignore
   // @Test
    public void addCategoryTest()
    {
    	Category category=new Category();
    	category.setCategoryName("Lakme");
        category.setCategoryDescr("All Lakme make-up products");
        category.setCategoryName("Revlon");
        category.setCategoryDescr("All Revlon make-up products");
        assertTrue("Problem in Adding Category:",categoryDAO.addCategory(category));
    }
	//@Ignore
    @Test
    public void updateCategoryTest()
    {
    	Category category=categoryDAO.getCategory(93);
    	category.setCategoryName("ColorBar");
        category.setCategoryDescr("All ColorBar products");
        assertTrue("Problem in updating the Category:",categoryDAO.updateCategory(category));
    }
    @Ignore
    @Test
    public void deleteCategoryTest()
    {
    	Category category=categoryDAO.getCategory(2);
        category.setCategoryDescr("All Revlon make-up products");
        assertTrue("Problem in deleting the Category:",categoryDAO.deleteCategory(category));
    }
    
    @Ignore
    @Test
    public void listCategoriesTest()
    {
    	List<Category>listCategories=categoryDAO.listCategories();
    	assertNotNull("Problem in listing categories",listCategories);
    	for(Category category:listCategories)
    	{
    		System.out.print(category.getCategoryId()+":::");
    		System.out.print(category.getCategoryName()+":::");
    		System.out.print(category.getCategoryDescr());
    	}
    		
    	
    }
}
