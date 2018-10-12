package com.sush.dao;

import java.util.List;

import com.sush.model.Category;
import com.sush.model.Product;

public interface ProductDao 
{
	List<Product> getAllProducts(); 
	Product getProduct(int id);
	void deleteProduct(int id); 
	List<Category> getCategories();
	void saveOrUpdateProduct(Product product);
}
