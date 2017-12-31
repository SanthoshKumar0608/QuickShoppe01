package com.niit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.QuickShopBackEnd.dao.CategoryDao;
import com.niit.QuickShopBackEnd.dao.ProductDao;
import com.niit.QuickShopBackEnd.dao.SupplierDao;
import com.niit.QuickShopBackEnd.model.Category;
import com.niit.QuickShopBackEnd.model.Product;
import com.niit.QuickShopBackEnd.model.Supplier;

import QuickShopFrontEnd.Fileinput.FileInput;

@Controller
public class ProductController {
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	String path="G:\\Java\\QuickShopFrontEnd\\src\\main\\webapp\\resources\\images\\";
	
	@RequestMapping("/Product")
	public ModelAndView Product()
	{
		ModelAndView obj=new ModelAndView("product");
		List<Product> products=productDao.list();
		List<Supplier> suppliers=supplierDao.list();
		List<Category> categories=categoryDao.list();
		obj.addObject("product", new Product());
		obj.addObject("products", products);
		obj.addObject("categories", categories);
		obj.addObject("suppliers", suppliers);		
		return obj;
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product")Product product)
	{
		ModelAndView obj=new ModelAndView("redirect:/Product");
		if(productDao.saveorupdate(product)==true)
			
		{
			FileInput.upload(path, product.getPimg(), product.getPid()+".jpg");
			obj.addObject("msg", "Product is added successfully");
			
		}

		else
		{
			obj.addObject("msg", "Product is not added");
		}
		return obj;
	}
	
	@RequestMapping("/editProduct/{pid}")
	public ModelAndView editProduct(@PathVariable("pid")String id)
	{
		ModelAndView obj=new ModelAndView("product");
		List<Product> products=productDao.list();
		List<Supplier> suppliers=supplierDao.list();
		List<Category> categories=categoryDao.list();
		product=productDao.getPid(id);
		obj.addObject("product", product);
		obj.addObject("products", products);
		obj.addObject("categories", categories);
		obj.addObject("suppliers", suppliers);
		return obj;
			
	}
	

	
     @RequestMapping("/deleteProduct/{pid}")
	public ModelAndView deleteProduct(@PathVariable("pid") String id)
	{
    	 product=productDao.getPid(id);
		ModelAndView obj= new ModelAndView("redirect:/Product");
		
		productDao.delete(product);
			obj.addObject("msg1", "Product Deleted Successfully");
			return obj;
		
	}


}
