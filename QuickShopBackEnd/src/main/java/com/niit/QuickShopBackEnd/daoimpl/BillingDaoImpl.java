package com.niit.QuickShopBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.QuickShopBackEnd.dao.BillingDao;
import com.niit.QuickShopBackEnd.model.Billing;


@Repository("billingDao")
@EnableTransactionManagement
@Transactional
public class BillingDaoImpl implements BillingDao{
	
	@Autowired
	SessionFactory sessionFactory;
	public BillingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	

	@Override
	public boolean saveorupdate(Billing billing) {
		sessionFactory.getCurrentSession().saveOrUpdate(billing);
		return true;
	}

	@Override
	public boolean delete(Billing billing) {
		sessionFactory.getCurrentSession().delete(billing);
		return true;
	}

	@Override
	public Billing getBill_Id(String Bill_Id) {
		String q1="from Billing where Bill_Id='"+Bill_Id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Billing> list=(List<Billing>) w.list();
		if(list ==null || list.isEmpty())
		{
			return null;
			
		}
		  return list.get(0);
	   }

	@Override
	public List<Billing> list() {
		{
			List<Billing> billing =(List<Billing>) sessionFactory.getCurrentSession().createCriteria(Billing.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return billing;
		}
	
	}	

}
