package com.sush.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sush.model.Category;

public class TestBean {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sush");
		context.refresh();
		Category category=(Category)context.getBean("category");
		category.display();
        context.close();
	}

}
