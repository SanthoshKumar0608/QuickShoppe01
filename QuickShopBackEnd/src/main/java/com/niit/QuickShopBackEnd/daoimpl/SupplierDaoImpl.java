package com.niit.QuickShopBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.QuickShopBackEnd.dao.SupplierDao;
import com.niit.QuickShopBackEnd.model.Supplier;

@Repository("supplierDao")
@EnableTransactionManagement
@Transactional

public class SupplierDaoImpl implements SupplierDao {
	
@Autowired
SessionFactory sessionFactory;

public SupplierDaoImpl(SessionFactory sessionFatory)
     {
    	 this.sessionFactory=sessionFactory;
	 }



public boolean saveorupate(Supplier supplier) {
	sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	return true;
}


public boolean delete(Supplier supplier) {
	sessionFactory.getCurrentSession().delete(supplier);
	return true;
}


public Supplier getSid(String sid) {
	String q1="from Supplier where sid='"+sid+"'";
	Query w=sessionFactory.getCurrentSession().createQuery(q1);
	List<Supplier> list=(List<Supplier>) w.list();
	if(list ==null || list.isEmpty())
	{
		return null;
		
	}
	  return list.get(0);
}

@SuppressWarnings("deprecation")
public List<Supplier> list() {
	List<Supplier> supplier =(List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	return supplier;
}



}
