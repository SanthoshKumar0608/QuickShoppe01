package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.QuickShopBackEnd.dao.CategoryDao;
import com.niit.QuickShopBackEnd.dao.ProductDao;
import com.niit.QuickShopBackEnd.model.Category;
import com.niit.QuickShopBackEnd.model.Product;

@Controller
public class CategoryController {
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Product product;
	
	@Autowired 
	ProductDao productDao;
	
	@RequestMapping("/Category")
	public ModelAndView Category()
	{
		ModelAndView obj= new ModelAndView("category");
		List<Category> categories=categoryDao.list();
		obj.addObject("category", new Category());
		obj.addObject("categories", categories);
		return obj;
	}

	
	@RequestMapping("/addCategory")
	public ModelAndView addCategory(@ModelAttribute("category")Category category)
	{
		ModelAndView obj=new ModelAndView("redirect:/Category");
		if(categoryDao.saveorupdate(category)==true)
		{
			obj.addObject("msg", "Category is added successfully");
			
		}
		else
		{
			obj.addObject("msg", "Category is not added");
		}
		return obj;
	}
	
	@RequestMapping("/editCategory/{catid}")
		public ModelAndView editCategory(@PathVariable("catid")String id)
	{
		ModelAndView obj=new ModelAndView("category");
		List<Category> categories=categoryDao.list();
		category=categoryDao.getCatId(id);
		obj.addObject("category", category);
		obj.addObject("categories", categories);
		return obj;
			
	}
	
	@RequestMapping("/deleteCategory/{catid}")
	public ModelAndView deleteCategory(@PathVariable("catid") String id)
	{
		ModelAndView obj= new ModelAndView("redirect:/Category");
		category=categoryDao.getCatId(id);
		List<Product> plist=productDao.getProductByCategory(id);
		if(plist==null||plist.isEmpty())
		{
			categoryDao.delete(category);
			System.out.println("Product list is empty .. Category is been deleted");
		}
		else
		{
						
			for(Product p:plist)
			{
				productDao.delete(p);
			}
			categoryDao.delete(category);
			System.out.println("Product list deleted and category is deleted");
		}
		
		return obj;
	}
	
}
