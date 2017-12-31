package com.niit.QuickShopBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.CartDao;
import com.niit.QuickShopBackEnd.dao.CartItemsDao;
import com.niit.QuickShopBackEnd.dao.ProductDao;
import com.niit.QuickShopBackEnd.model.Cart;
import com.niit.QuickShopBackEnd.model.CartItems;
import com.niit.QuickShopBackEnd.model.Product;


public class TestCartItems {
	
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext Context= new AnnotationConfigApplicationContext();
		Context.scan("com.niit.*");
		Context.refresh();
		
		CartItems cartItems=(CartItems)Context.getBean("cartItems");
		CartItemsDao cartItemsDao =(CartItemsDao)Context.getBean("cartItemsDao");
		Cart cart=(Cart) Context.getBean("cart");
		CartDao cartDao=(CartDao) Context.getBean("cartDao");
		Product product=(Product)Context.getBean("product");
		ProductDao productDao =(ProductDao)Context.getBean("productDao");
		
		
		cartItems.setCartitem_Id("ci101");
		cartItems.setPrice(1000);
		
		cart=cartDao.getCart_Id("102");
		cartItems.setCart(cart);
		
		product=productDao.getPid("p102");
		cartItems.setProduct(product);
	
		if(cartItemsDao.saveorupdate(cartItems)==true)
			
		{
			System.out.println(" Done");
		}
		else
        {
			System.out.println("Not  Done");
		}
		
		cartItems.setCartitem_Id("ci102");
		cartItems.setPrice(1000);
	
		if(cartItemsDao.saveorupdate(cartItems)==true)
		{
			System.out.println(" Done");
		}
		else
        {
			System.out.println("Not  Done");
		}
  
		 cartItems = cartItemsDao.getCartitem_Id("ci101");
		 if(cartItemsDao.delete(cartItems)==true)
		 {
			 System.out.println("Deleted");
		 }else
		 {
			 System.out.println("Not deleted");
		 }
		 
		 cartItems =cartItemsDao.getCartitem_Id("ci102");
		 {
			 System.out.println(cartItems.getCartitem_Id());
			 System.out.println(cartItems.getPrice());
		 }
		 
		 List<CartItems> lcart=cartItemsDao.list();
		 if(lcart==null || lcart.isEmpty())
		 {
			 System.out.println("Category is empty");
		 }else
			 for(CartItems c:lcart)
			 {
				 
				 System.out.println(c.getCartitem_Id());
				 System.out.println(c.getPrice());
		
			 }
}
}
