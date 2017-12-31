package com.niit.QuickShopBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.AuthenticationDao;
import com.niit.QuickShopBackEnd.model.Authentication;



public class TestAuthentication {
	
	public static void main(String[] args) {
	
	AnnotationConfigApplicationContext Context= new AnnotationConfigApplicationContext();
	
	Context.scan("com.niit.**");
	Context.refresh();
	
	Authentication authentication=(Authentication)Context.getBean("authentication");
	AuthenticationDao authenticationDao =(AuthenticationDao)Context.getBean("authenticationDao");
	
	
    authentication.setRole_id("a101");
    authentication.setRolename("Santhu");
    authentication.setUsername("1383");
	if(authenticationDao.saveorupdate(authentication)==true)
		
	{
		System.out.println(" Done");
	}
	else
    {
		System.out.println("Not  Done");
	}
	
	    authentication.setRole_id("a102");
	    authentication.setRolename("Kumar");
	    authentication.setUsername("1384");
		if(authenticationDao.saveorupdate(authentication)==true)
			
		{
			System.out.println(" Done");
		}
		else
	    {
			System.out.println("Not  Done");
		}
		
		authentication =authenticationDao.getRole_id("a102");
		if(authenticationDao.delete(authentication)==true)
		{
			System.out.println("Deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		
		
	}
}
