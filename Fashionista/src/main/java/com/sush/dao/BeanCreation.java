package com.sush.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sush.model.Category;

@Configuration
public class BeanCreation {
	@Bean(name="category")
	public Category createCategoryBean()
	{
		System.out.println("i am in create category bean");
		return new Category();
	}

}
