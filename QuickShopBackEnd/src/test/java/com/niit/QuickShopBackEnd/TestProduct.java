package com.niit.QuickShopBackEnd;

import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.CategoryDao;
import com.niit.QuickShopBackEnd.dao.ProductDao;
import com.niit.QuickShopBackEnd.dao.SupplierDao;
import com.niit.QuickShopBackEnd.model.Category;
import com.niit.QuickShopBackEnd.model.Product;
import com.niit.QuickShopBackEnd.model.Supplier;

public class TestProduct {

public static void main(String[] args) {
		
		AnnotationConfigApplicationContext Context= new AnnotationConfigApplicationContext();
		Context.scan("com.niit.*");
		Context.refresh();
		
		Product product=(Product)Context.getBean("product");
	    ProductDao productDao =(ProductDao)Context.getBean("productDao");
		Category category=(Category)Context.getBean("category");
		CategoryDao categoryDao =(CategoryDao)Context.getBean("categoryDao");
		Supplier supplier=(Supplier)Context.getBean("supplier");
		SupplierDao supplierDao =(SupplierDao)Context.getBean("supplierDao");
		
		
		product.setPid("p101");
		product.setPname("Apple S7");
		product.setPdesp("Advance Features");
		product.setPrice(12000);
		product.setQty(7);
		
		
		if(productDao.saveorupdate(product)==true)
			
		{
			System.out.println(" Done");
		}
		else
        {
			System.out.println("Not  Done");
		}
		
		product.setPid("p102");
		product.setPname("Moto X Play");
		product.setPrice(1000);
		product.setPdesp("Basic Features");
		product.setQty(5);
		
		 category=categoryDao.getCatId("c101");
		 product.setCategory(category);
			
		  supplier=supplierDao.getSid("111");
		   product.setSupplier(supplier);
			
		
		if(productDao.saveorupdate(product)==true)
		{
			System.out.println(" Done");
		}
		else
      {
						System.out.println("Not  Done");
		}
		
		
	   
		product=productDao.getPid("p101");
		
		if(productDao.delete(product)==true)
		{
			System.out.println("Deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		
		product=productDao.getPid("p102");
		{
		System.out.println(product.getPid());
		System.out.println(product.getPname());
		}
        
		List<Product> lpdt=productDao.list();
				
		if(lpdt==null||lpdt.isEmpty())
		  {
			System.out.println("Product is empty");
		  }
		else
			for(Product c:lpdt)
		  {
			System.out.println(c.getPid());
		    System.out.println(c.getPname());
		    System.out.println(c.getPdesp());
		    
		    System.out.println(c.getPrice());
		    System.out.println(c.getQty());
		  
		   
		    
	      }	
		
		 List<Product> prod=productDao.getProductByCategory("c101");
		
		 for(Product p:prod)
		 {
			 System.out.println(p.getPid());
			 System.out.println(p.getPname());
			 System.out.println(p.getPrice());
			 System.out.println(p.getQty());
			 System.out.println(p.getPdesp());
			 
		 }
		
		
		 //List<Product> supp=productDao.getProductBySupplier("111");
		 
		 //System.out.println(supplier.getSid());
		
}
		
	
}
