package com.niit.QuickShopBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.CartDao;
import com.niit.QuickShopBackEnd.dao.CartItemsDao;
import com.niit.QuickShopBackEnd.model.Cart;
import com.niit.QuickShopBackEnd.model.CartItems;


public class TestCart {
	
	public static void main(String args[])
	{
		
		AnnotationConfigApplicationContext Context= new AnnotationConfigApplicationContext();
		
		Context.scan("com.niit.*");
		Context.refresh();
		
		Cart cart=(Cart) Context.getBean("cart");
		CartDao cartDao=(CartDao) Context.getBean("cartDao");
		CartItems cartItems=(CartItems)Context.getBean("cartItems");
		CartItemsDao cartItemsDao =(CartItemsDao)Context.getBean("cartItemsDao");
		
		
		cart.setCart_Id("101");
		cart.setGrand_Total(1000.00);
		cart.setTotal_Item(2);
		
		if(cartDao.saveorupdate(cart)==true)
		{
			System.out.println("Done");
		}else
		{
			System.out.println("Not Done");
		}
		
		cart.setCart_Id("102");
		cart.setGrand_Total(1001.00);
		cart.setTotal_Item(4);
		
		if(cartDao.saveorupdate(cart)==true)
		{
			System.out.println("Done");
		}else
		{
			System.out.println("Not Done");
		}
		
		 cart=cartDao.getCart_Id("101");
		 if(cartDao.delete(cart)==true)
		 {
			 System.out.println("Deleted");
		 }
		 else 
		 {
			 System.out.println("Not Deleted");
		 }
		 
		 cart=cartDao.getCart_Id("102");
		 {
			 System.out.println(cart.getCart_Id());
			 System.out.println(cart.getTotal_Item());
			 System.out.println(cart.getGrand_Total());
		 }
		 
		 List<Cart> lcart=cartDao.list();
		  if(cartDao==null || lcart.isEmpty())
		  {
			  System.out.println("Cart is empty");
		  }else
			  for(Cart c:lcart)
		  {
			  
			  System.out.println(c.getCart_Id());
			  System.out.println(c.getTotal_Item());
			  System.out.println(c.getGrand_Total());
		  }
		 
	}

}
