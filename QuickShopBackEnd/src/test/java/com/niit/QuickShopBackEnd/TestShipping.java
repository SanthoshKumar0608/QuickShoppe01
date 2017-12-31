package com.niit.QuickShopBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.ShippingDao;
import com.niit.QuickShopBackEnd.dao.UserDao;
import com.niit.QuickShopBackEnd.model.Product;
import com.niit.QuickShopBackEnd.model.Shipping;
import com.niit.QuickShopBackEnd.model.User;



public class TestShipping {
	
	public static void main(String[] arg)
	{
		
		AnnotationConfigApplicationContext Context= new AnnotationConfigApplicationContext();
		Context.scan("com.niit.*");
		Context.refresh();
		
		Shipping shipping=(Shipping)Context.getBean("shipping");
		ShippingDao shippingDao =(ShippingDao)Context.getBean("shippingDao");
		User user=(User)Context.getBean("user");
	    UserDao userDao=(UserDao) Context.getBean("userDao");
	    
	    shipping.setSpid("233");
		shipping.setFirst_Name("Santhosh");
		shipping.setLast_Name("Kumar");
		shipping.setShipping_Id("s101");
		shipping.setHouse_No("111");
		shipping.setCity("Bangalore");
		shipping.setCountry("India");
		shipping.setPincode("560002");
		shipping.setMobile_No("9483834393");
		shipping.setEmail("Sachin.salyan06@gmail.com");
		
		user=userDao.getUid("111");
		shipping.setUser(user);
		
		if(shippingDao.saveorupdate(shipping)==true)
		{
			
			System.out.println("Done");
		}
		else
		{
			System.out.println("Not Done");
		}
		
		shipping.setSpid("222");
		shipping.setFirst_Name("Santhu");
		shipping.setLast_Name("Kumar");
		shipping.setShipping_Id("s102");
		shipping.setHouse_No("111");
		shipping.setCity("Bangalore");
		shipping.setCountry("India");
		shipping.setPincode("560002");
		shipping.setMobile_No("9483834393");
		shipping.setEmail("Sachin.salyan06@gmail.com");
		
		if(shippingDao.saveorupdate(shipping)==true)
		{
			
			System.out.println("Done");
		}
		else
		{
			System.out.println("Not Done");
		}
		
		shipping=shippingDao.getSpid("111");
		if(shippingDao.delete(shipping)==true)
		{
			System.out.println("Deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		
		shipping=shippingDao.getSpid("111");
		{
			System.out.println(shipping.getFirst_Name());
			System.out.println(shipping.getLast_Name());
						
		}
		
       List<Shipping> lpdt=shippingDao.list();
		
		if(lpdt==null||lpdt.isEmpty())
		  {
			System.out.println("Shipping is empty");
		  }
		else
			for(Shipping c:lpdt)
		  {
			System.out.println(c.getFirst_Name());
		    System.out.println(c.getLast_Name());
		    System.out.println(c.getShipping_Id());
		    System.out.println(c.getHouse_No());
		    System.out.println(c.getCity());
		    System.out.println(c.getCountry());
		    System.out.println(c.getPincode());
		    System.out.println(c.getEmail());
		    System.out.println(c.getMobile_No());
		             
		    
	      }	
	}

}
