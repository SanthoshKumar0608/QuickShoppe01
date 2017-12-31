package com.niit.QuickShopBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.UserDao;
import com.niit.QuickShopBackEnd.model.User;

public class TestUser {
	
	public static void main(String[] args) {
		
		
		
		AnnotationConfigApplicationContext Context= new AnnotationConfigApplicationContext();
		Context.scan("com.niit.*");
		Context.refresh();
		
		User user=(User) Context.getBean("user");
		UserDao userDao=(UserDao) Context.getBean("userDao");
		
	user.setUid("111");
	user.setUname("Santhosh");
	user.setUpwd("xyz");
	user.setRpwd("xyz");
	user.setMobile("94949949494994");
	user.setUmail("wxyz@gmail.com");
	user.setUaddress("Saaaaa");
	user.setRole("Admin");
	
	if(userDao.saveorupdate(user)== true)
	{
		System.out.println("Successfully Saved");
	}
	else
	{
		System.out.println("Not Saved");
	}
	
	user.setUid("123");
	user.setUname("Santhosh");
	user.setUpwd("xyz");
	user.setMobile("94949949494994");
	user.setUmail("wxyz@gmail.com");
	user.setUaddress("Saaaaa");
	user.setRole("Admin");
	
	if(userDao.saveorupdate(user)== true)
	{
		System.out.println("Successfully Saved");
	}
	else
	{
		System.out.println("Not Saved");
	}
	
	user=userDao.getUid("123");
	
	if(userDao.delete(user)==true)
	{
		System.out.println("Deleted");
	}
	else
	{
		System.out.println("Not Deleted");
	}
	
	user=userDao.getUid("111");
	{
		System.out.println(user.getUid());
		System.out.println(user.getUname());
		System.out.println(user.getMobile());
		System.out.println(user.getRole());
		System.out.println(user.getUaddress());
		System.out.println(user.getUmail());
		System.out.println(user.getUpwd());
	}
	
	
	List<User> luser=userDao.list();
	if(luser==null || luser.isEmpty())
	{
		System.out.println("LIST iS empty");
	}
	else
	for(User c:luser)
	{
		System.out.println(c.getMobile());
		System.out.println(c.getRole());
		System.out.println(c.getUaddress());
		System.out.println(c.getUid());
		System.out.println(c.getUmail());
		System.out.println(c.getUname()); 
		System.out.println(c.getUpwd());
	}
	}

}
