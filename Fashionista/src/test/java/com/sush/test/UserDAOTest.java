package com.sush.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.sush.dao.UserDAO;
import com.sush.model.Supplier;
import com.sush.model.User;

public class UserDAOTest {
	static UserDAO userDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sush");
		context.refresh();
	    userDAO=(UserDAO)context.getBean("UserDAO");
	}
	@Ignore
    @Test
    public void registerUserTest()
    {
    	User user=new User();
    	user.setUsername("Deeksha");
        user.setPassword("deek");
        user.setCustomerName("Deeksharaj");
        user.setMobileNumber("7894532689");
        user.setEmailId("deeksharaj19@gmail.com");
        user.setRole("Admin");
        user.setEnabled("enable");
        assertTrue("Problem in Adding User:",userDAO.registerUser(user));
    }
    //@Ignore
    @Test
    public void modifyUserTest()
    {
    	User user=userDAO.getUser("Deeksha");
    	user.setUsername("Preethi");
        user.setPassword("chintoo");
        user.setCustomerName("Pratheeksha");
        user.setMobileNumber("9573256190");
        user.setEmailId("pratheeksha@gmail.com");
        user.setRole("Admin");
        user.setEnabled("enable");
        assertTrue("Problem in modifying the User:",userDAO.modifyUser(user));
    }
   

}
