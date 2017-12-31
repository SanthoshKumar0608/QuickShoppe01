package com.niit.QuickShopBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.OrderDao;
import com.niit.QuickShopBackEnd.model.Order;

public class TestOrder {
	
	public static void main(String arg[])
	
	{
		
		AnnotationConfigApplicationContext Context= new AnnotationConfigApplicationContext();
		
		Context.scan("com.niit.*");
		Context.refresh();
		
		Order order=(Order) Context.getBean("order");
		OrderDao orderDao=(OrderDao) Context.getBean("orderDao");
				
        order.setOrder_Id("o101");
		order.setOrder_Date("11/11/11");
    	order.setOrder_Time("2:00 AM");
	    order.setGrand_Total(10000);
	
	if(orderDao.saveorupdate(order)==true)
	{
		System.out.println("Saved");
	}
	else
	{
		System.out.println("Not Saved");
	}
		
	order.setOrder_Id("0102");
	order.setOrder_Date("11/11/11");
		order.setOrder_Time("2:00 AM");
		order.setGrand_Total(100000);
		
		if(orderDao.saveorupdate(order)==true)
		{
			System.out.println("Saved");
		}
		else
		{
			System.out.println("Not Saved");
		}
				
		
		order=orderDao.getOrder_Id("0101");
		if(orderDao.delete(order)==true)
		{
			System.out.println("Deleted");
		}
		else
		{
			System.out.println("Not Deleted");
		}
		
		order=orderDao.getOrder_Id("0102");
		{
			System.out.println(order.getOrder_Id());
			System.out.println(order.getOrder_Time());
			System.out.println(order.getOrder_Date());
			System.out.println(order.getGrand_Total());
		}
		
		List<Order> lorder=orderDao.list();
				if(lorder==null || lorder.isEmpty())
				{
					System.out.println("Order Item is Empty");
				}else
					for(Order c:lorder)
					{
						System.out.println(c.getGrand_Total());
						System.out.println(c.getOrder_Date());
						System.out.println(c.getOrder_Id());
						System.out.println(c.getOrder_Time());
					}
	}

}
