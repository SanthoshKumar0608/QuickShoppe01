package com.niit.QuickShopBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.ProductDao;
import com.niit.QuickShopBackEnd.dao.SupplierDao;
import com.niit.QuickShopBackEnd.model.Product;
import com.niit.QuickShopBackEnd.model.Supplier;

public class TestSupplier {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext Context= new AnnotationConfigApplicationContext();
		Context.scan("com.niit.**");
		Context.refresh();
		
		Supplier supplier=(Supplier)Context.getBean("supplier");
		SupplierDao supplierDao =(SupplierDao)Context.getBean("supplierDao");
						
		supplier.setSid("s101");
		supplier.setSname("FlipKart");
		supplier.setSadd("Rajajinagar");
		
		supplier.setSnumber(948383439);
		
		
		if(supplierDao.saveorupate(supplier)==true)
		{
			System.out.println(" Done");
		}
		else
      {
			System.out.println("Not  Done");
			
		}
		
		supplier.setSid("s102");
		supplier.setSname("Moto");
		supplier.setSadd("Mallewswaram");
		supplier.setSnumber(1234567);
		
		
		if(supplierDao.saveorupate(supplier)==true)
		{
			System.out.println(" Done");
		}
		else
      {
			System.out.println("Not  Done");
		}
		
//	 supplier=supplierDao.getSid("s103");
//	 if(supplierDao.delete(supplier)==true)
//	 {
//		 System.out.println("Supplier Details is deleted");
//	 }else
//	 {
//		 System.out.println("Not Deleted");
//	 }
		supplier=supplierDao.getSid("s101");
				{
			System.out.println(supplier.getSid());
			System.out.println(supplier.getSname());
			System.out.println(supplier.getSnumber());
			System.out.println(supplier.getSadd());
			
				}
		
       List<Supplier> lsup=supplierDao.list();
		
		if(lsup==null||lsup.isEmpty())
		  {
			System.out.println("Supplier is empty");
		  }
		else
			for(Supplier c:lsup)
			{
				
				System.out.println(c.getSid());
				System.out.println(c.getSname());
				System.out.println(c.getSadd());
				System.out.println(c.getSnumber());
				
			}
	}
}
		
