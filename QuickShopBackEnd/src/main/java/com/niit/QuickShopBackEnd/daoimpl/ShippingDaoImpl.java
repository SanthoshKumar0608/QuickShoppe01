package com.niit.QuickShopBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.QuickShopBackEnd.dao.ShippingDao;

import com.niit.QuickShopBackEnd.model.Shipping;

@Repository("shippingDao")
@EnableTransactionManagement
@Transactional

public class ShippingDaoImpl implements ShippingDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ShippingDaoImpl(SessionFactory sessionFactory)
	{
		
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdate(Shipping shipping) {
		sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return true;
	}

	@Override
	public boolean delete(Shipping shipping) {
		sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return false;
	}

	@Override
	public Shipping getSpid(String Spid) {
		String q1="from Shipping where Spid='"+Spid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Shipping> list=(List<Shipping>) w.list();
		if(list ==null || list.isEmpty())
		{
			return null;
			
		}
		  return list.get(0);
	}

	@Override
	@SuppressWarnings("deprecation")
	public List<Shipping> list() {
		List<Shipping> shipping =(List<Shipping>) sessionFactory.getCurrentSession().createCriteria(Shipping.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return shipping;
		
	}

	


}
