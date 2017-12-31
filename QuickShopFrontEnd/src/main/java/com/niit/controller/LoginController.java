package com.niit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.niit.QuickShopBackEnd.dao.UserDao;

import com.niit.QuickShopBackEnd.model.User;

@Controller
public class LoginController {
	
	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	
	
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, 
			            @RequestParam(value="logout", required=false) String logout, Model model)
	
	{
		
		if(error!=null)
			model.addAttribute("error", "Invalid User Name And Password");
		if(logout!=null)
			model.addAttribute("logout", "Login Successfully");
		return "login";
		
	}
	
	@RequestMapping(value="/j_spring_security_check", method=RequestMethod.POST)
	public String Login(@RequestParam("j_username")String umail, @RequestParam("j_password")String upwd, Model model, HttpSession session)
	{
		
		User u=userDao.isValid(umail,upwd);
		if(u==null)
		{
			model.addAttribute("msg", "Invalid username adn password");
			return "redirect:/";
			
		}
		else
		{
			session.setAttribute("user", u);
			session.setAttribute("name", u.getUname());
			//session.setAttribute("items", );
			return "redirect:/";
		}
		
	}
	 @RequestMapping(value="/j_spring_security_logout")
	 public String logout(HttpServletRequest request, HttpSession session, Model model)
	 {
		 session.invalidate();
		 session=request.getSession(true);
		 model.addAttribute("logout", "Logout Successfully");
		 return "redirect:/";
	 }
	
	

}
