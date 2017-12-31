package com.niit.QuickShopBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.OrderDao;
import com.niit.QuickShopBackEnd.dao.OrderItemsDao;
import com.niit.QuickShopBackEnd.model.Order;
import com.niit.QuickShopBackEnd.model.OrderItems;

public class TestOrderItems {
	
	public static void main(String[] arg)
	{
	
	AnnotationConfigApplicationContext Context=new AnnotationConfigApplicationContext();
	Context.scan("com.niit.*");
	Context.refresh();
	
	OrderItems orderItems=(OrderItems)Context.getBean("orderItems");
	OrderItemsDao orderItemsDao=(OrderItemsDao)Context.getBean("orderItemsDao");
	
	Order order=(Order)Context.getBean("order");
	OrderDao orderDao=(OrderDao) Context.getBean("orderDao");
	
	
     orderItems.setOrderItem_Id("o101");
     orderItems.setProduct_Id("p101");
    
     order=orderDao.getOrder_Id("o101");
     orderItems.setOrder(order);
     
     if(orderItemsDao.saveorupdate(orderItems)==true)
     {
    	 System.out.println("Its Saved");
     }
     else
     {
    	 System.out.println("Its not Saved");
     }
  

    orderItems.setOrderItem_Id("o102");
    orderItems.setProduct_Id("p102");
     if(orderItemsDao.saveorupdate(orderItems)==true)
     {
    	 System.out.println("Done");
     }else
     {
    	 System.out.println("Not Done");
     }
	
     orderItems=orderItemsDao.getOrderItem_Id("o102");
     if(orderItemsDao.delete(orderItems)==true)
    	 
     {
    	 System.out.println("Deleted");
     }else
     {
    	 
    	 System.out.println("Not Deleted");     
     
	}
     
    orderItems=orderItemsDao.getOrderItem_Id("o101");
    {
    	System.out.println(orderItems.getOrderItem_Id());
    }
     
	List<OrderItems> lcat=orderItemsDao.list();
	if(lcat==null || lcat.isEmpty())
	{
		System.out.println("Category is empty");
	}else
		for(OrderItems c:lcat)
	{
		System.out.println(c.getOrderItem_Id());
	    
	}
	}
	}
