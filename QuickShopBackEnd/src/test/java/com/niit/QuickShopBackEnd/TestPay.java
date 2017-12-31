package com.niit.QuickShopBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.PayDao;
import com.niit.QuickShopBackEnd.model.Pay;


public class TestPay {
	
	public static void main(String[] arg)
	{
		
		AnnotationConfigApplicationContext Context=new AnnotationConfigApplicationContext();
		Context.scan("com.niit.*");
		Context.refresh();
		
		Pay pay=(Pay)Context.getBean("pay");
		PayDao payDao=(PayDao)Context.getBean("payDao");
		pay.setPay_Id("111");
		pay.setPay_Method("Credit Card");
		pay.setStatus("Sucess");
		
		if(payDao.saveorupdate(pay)==true)
		{
			System.out.println("Done");
		}else
		{
			System.out.println("File is not Saved!!!!");
		}
		
		pay.setPay_Id("222");
		pay.setPay_Method("Debit Card");
		pay.setStatus("Failure");
		
		if(payDao.saveorupdate(pay)==true)
		{
			System.out.println("Done");
		}else
		{
			System.out.println("File is not Saved!!!!");
		}
			
		pay=payDao.getPay_Id("222");
		if(payDao.delete(pay)==true)
		{
		  System.out.println("Deleted");	
		}else
		{
			System.out.println("Not Deleted");
		}
		
		pay=payDao.getPay_Id("111");
		{
			System.out.println(pay.getPay_Id());
			System.out.println(pay.getPay_Method());
			System.out.println(pay.getStatus());
		}
		
		List<Pay> lpay=payDao.list();
		if(lpay==null || lpay.isEmpty())
		{
			System.out.println("Pay list is empty");
		}else
			for(Pay c:lpay)
		{
			System.out.println(c.getPay_Id());
			System.out.println(c.getPay_Method());
			System.out.println(c.getStatus());
		}
		
		
		
	}
	

}
