package com.niit.QuickShopBackEnd;

import java.util.List;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.QuickShopBackEnd.dao.CategoryDao;
import com.niit.QuickShopBackEnd.dao.ProductDao;
import com.niit.QuickShopBackEnd.model.Category;
import com.niit.QuickShopBackEnd.model.Product;

public class TestCategory {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext Context= new AnnotationConfigApplicationContext();
		Context.scan("com.niit.*");
		Context.refresh();
		
		Category category=(Category)Context.getBean("category");
		
		CategoryDao categoryDao =(CategoryDao)Context.getBean("categoryDao");
		
		
		category.setCatid("c101");
		category.setCatname("Men");
		if(categoryDao.saveorupdate(category)==true)
		{
			System.out.println(" Category Data is saved ");
					}
		else
        {
			System.out.println("Not  Done");
		}
		
		category.setCatid("c102");
		category.setCatname("Women");
		if(categoryDao.saveorupdate(category)==true)
		{
			System.out.println(" Category detail Deleted");
		}
		else
        {
			System.out.println("Not  Done");
		}
		
//		category=categoryDao.getCatId("c102");
//		if(categoryDao.delete(category)==true)
//			
//		{
//			System.out.println("Deleted");
//		}
//		else
//		{
//			System.out.println("Not deleted");
//		}
		
		category=categoryDao.getCatId("c101");
		{
		System.out.println(category.getCatid());
		System.out.println(category.getCatname());
		}
		
		List<Category> lcat=categoryDao.list();
		
		if(lcat==null||lcat.isEmpty())
		  {
			System.out.println("Category is empty");
		  }
		else
			for(Category c:lcat)
		  {
			System.out.println(c.getCatid());
		    System.out.println(c.getCatname());
	      }
	}
	
}