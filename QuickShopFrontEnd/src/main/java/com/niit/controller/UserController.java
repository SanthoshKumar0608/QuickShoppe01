package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.QuickShopBackEnd.dao.UserDao;
import com.niit.QuickShopBackEnd.model.Product;
import com.niit.QuickShopBackEnd.model.Supplier;
import com.niit.QuickShopBackEnd.model.User;
@Controller
public class UserController {
	
	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/User")
	public ModelAndView User()
	{
		
		ModelAndView obj=new ModelAndView("signup");
		List<User> users=userDao.list();
		obj.addObject("user", new User());
		
		obj.addObject("users", users);
		return obj;
		
	}
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute("user")User user)
	
	{
		ModelAndView obj=new ModelAndView("redirect:/User");
	if(userDao.saveorupdate(user)== true)
	{
		obj.addObject("msg", "User is added successfully");
	}else
	{
	obj.addObject("msg", "Category is not added");
	}
	return obj;
}
	
//	@RequestMapping("/editUser/{uid}")
//	public ModelAndView editUser(@PathVariable("uid")String id)
//	{
//		ModelAndView obj=new ModelAndView("user");
//		List<User> users=userDao.list();
//		user=userDao.getUid(id);
//		obj.addObject("user", new User());
//		obj.addObject("user", users);
//		return obj;
//			
//	}
}
