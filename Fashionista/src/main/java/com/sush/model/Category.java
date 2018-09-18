package com.sush.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	@Id
	@GeneratedValue
	int categoryId;
	String categoryName;
	String categoryDescr;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescr() {
		return categoryDescr;
	}
	public void setCategoryDescr(String categoryDescr) {
		this.categoryDescr = categoryDescr;
	}
	public void display()
	{
		System.out.println("Display method");
	}

}
