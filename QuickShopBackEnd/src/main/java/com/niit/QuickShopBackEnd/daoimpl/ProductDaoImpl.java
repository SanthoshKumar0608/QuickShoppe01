package com.niit.QuickShopBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.QuickShopBackEnd.dao.ProductDao;
import com.niit.QuickShopBackEnd.model.Product;
@Repository("productDao")
@EnableTransactionManagement
@Transactional

public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory) {
		       this.sessionFactory=sessionFactory;
	}


	public boolean saveorupdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}


	public boolean delete(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}


	public Product getPid(String pid) {
		String q1="from Product where pid='"+pid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Product> list=(List<Product>) w.list();
		if(list ==null || list.isEmpty())
		{
			return null;
			
		}
		  return list.get(0);
	}
	
	@SuppressWarnings("deprecation")
	public List<Product> list() {
		List<Product> product =(List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
								.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return product;
	}


	public List<Product> getProductByCategory(String catid) {
		String q2="from Product where catid='"+catid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q2);
		List<Product> list=(List<Product>) w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list;
	}


	public List<Product> getProductBySupplier(String sid) {
		String q3="from Product where sid='"+sid+"'";
		Query  w=sessionFactory.getCurrentSession().createQuery(q3);
		List<Product> list=(List<Product>) w.list();
		if(list==null || list.isEmpty())
		{
		return null;
		}else
		{
			return list;
		}
	}
	

}
