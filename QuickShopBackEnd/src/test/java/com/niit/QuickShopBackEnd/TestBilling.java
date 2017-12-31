package com.niit.QuickShopBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.BillingDao;

import com.niit.QuickShopBackEnd.model.Billing;


public class TestBilling {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext Context= new AnnotationConfigApplicationContext();
		
		Context.scan("com.niit.*");
		Context.refresh();
		
		Billing billing=(Billing)Context.getBean("billing");
		BillingDao billingDao =(BillingDao)Context.getBean("billingDao");
		
		
		billing.setBill_Id("b101");
		billing.setHouse_No("111");
		billing.setEmail("saa@gail.com");
		billing.setCountry("india");
		billing.setPinCode("54678");
		billing.setMobile_No("9483834383");
		
		if (billingDao.saveorupdate(billing)==true) 
		  {
			System.out.println("Saved");
		  }else
		 {
			 System.out.println("Not Saved");
		 }
		
		billing.setBill_Id("b102");
		billing.setHouse_No("222");
		billing.setEmail("dddda@gail.com");
		billing.setCountry("india");
		billing.setPinCode("5678");
		billing.setMobile_No("56688");
		
		if (billingDao.saveorupdate(billing)==true) 
		  {
			System.out.println("Saved");
		  }else
		 {
			 System.out.println("Not Saved");
		 }
		
		billing=billingDao.getBill_Id("b102");
		if(billingDao.delete(billing)==true)
		{
			System.out.println("Deleted");
		}else
		{
			System.out.println("Not Deleted");
		}
		
		billing=billingDao.getBill_Id("b101");
		{
			System.out.println(billing.getBill_Id());
			System.out.println(billing.getCountry());
			System.out.println(billing.getEmail());
			System.out.println(billing.getHouse_No());
			System.out.println(billing.getMobile_No());
			System.out.println(billing.getPinCode());
		
		}
		
		List<Billing> lbill=billingDao.list();
		if(lbill==null || lbill.isEmpty());
		{
			System.out.println("List is empty");
		}
		
			for(Billing c:lbill)
			{
				System.out.println(c.getBill_Id());
				System.out.println(c.getCountry());
				System.out.println(c.getEmail());
				System.out.println(c.getHouse_No());
				System.out.println(c.getMobile_No());
				System.out.println(c.getPinCode());
			}
			
	}
	
}
