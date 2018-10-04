package com.sush.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sush.dao.CategoryDAO;
import com.sush.model.Category;

@Controller
public class CategoryController
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/category")
	public String showCategoryPage(Model m)
	{
		return "Category";
	}
	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("categoryName")String categoryName,@RequestParam("categoryDescr")String categoryDescr,Model m)
	
	
	{
		Category category=new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDescr(categoryDescr);
		categoryDAO.addCategory(category);
		List<Category>listCategory=categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategory);
		return "Category";
	}
	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("categoryId")int categoryId,@RequestParam("categoryName")String categoryName,@RequestParam("categoryDescr")String categoryDescr,Model m)
	{
		
		Category category=categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDescr(categoryDescr);
		categoryDAO.updateCategory(category);
		List<Category>listCategory=categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategory);
		return "Category";
		
	}
	
  @RequestMapping(value="/deleteCategory/{categoryId}")
public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
{
	  Category category=categoryDAO.getCategory(categoryId);
	  categoryDAO.deleteCategory(category);
	  List<Category>listCategory=categoryDAO.listCategories();
	   m.addAttribute("categoryList",listCategory);
	  return "Category";
}
  @RequestMapping(value="/editCategory/{categoryId}")
public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
{
	  Category category=categoryDAO.getCategory(categoryId);
	  m.addAttribute("cat",category);
	  
	  
	  return "UpdateCategory";
}
	
 
}
