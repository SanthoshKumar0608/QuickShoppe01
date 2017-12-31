package com.niit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.QuickShopBackEnd.dao.SupplierDao;

import com.niit.QuickShopBackEnd.model.Supplier;
@Controller
public class SupplierController {
	
 @Autowired
 Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/Supplier")
	public ModelAndView Supplier()
	{
		
		
		ModelAndView obj=new ModelAndView("supplier");
		List<Supplier> suppliers=supplierDao.list();
		obj.addObject("supplier", new Supplier());
		
		obj.addObject("suppliers", suppliers);
		return obj;
		
	}
	
	@RequestMapping("/addSupplier")
	public ModelAndView addSupplier(@ModelAttribute("supplier")Supplier supplier)
	
	{
		ModelAndView obj=new ModelAndView("redirect:/Supplier");
	if(supplierDao.saveorupate(supplier)== true)
	{
		obj.addObject("msg", "Suuplier is added successfully");
	}else
	{
	obj.addObject("msg", "Supplier is not added");
	}
	return obj;
}
	
	
	@RequestMapping("/editSupplier/{sid}")
	public ModelAndView editSupplier(@PathVariable("sid")String id)
	{
		ModelAndView obj=new ModelAndView("supplier");
		List<Supplier> supplierss=supplierDao.list();
		supplier=supplierDao.getSid(id);
		obj.addObject("supplier", supplier);
		obj.addObject("suppliers", supplierss);
		return obj;
			
	}
	
	   @RequestMapping("/deleteSupplier/{sid}")
		public ModelAndView deleteSupplier(@PathVariable("sid") String id)
		{
	    	 supplier=supplierDao.getSid(id);
			ModelAndView obj= new ModelAndView("redirect:/Supplier");
			
			supplierDao.delete(supplier);
				obj.addObject("msg1", "Supplier Deleted Successfully");
				return obj;
			
		}
	
}
