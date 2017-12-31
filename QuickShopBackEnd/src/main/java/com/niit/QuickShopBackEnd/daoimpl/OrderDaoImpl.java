package com.niit.QuickShopBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.QuickShopBackEnd.dao.OrderDao;

import com.niit.QuickShopBackEnd.model.Order;
@Repository("orderDao")
@EnableTransactionManagement
@Transactional
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}


	public boolean saveorupdate(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}

	@Override
	public boolean delete(Order order) {
		sessionFactory.getCurrentSession().delete(order);
		
		return true;
	}


	public Order getOrder_Id(String Order_Id) {
		String q1="from Order where Order_Id='"+Order_Id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Order> list=(List<Order>) w.list();
		if(list ==null || list.isEmpty())
		{
			return null;
			
		}
		  return list.get(0);
	   }
	
	

	@Override
	public List<Order> list() {
		List<Order> order =(List<Order>) sessionFactory.getCurrentSession().createCriteria(Order.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return order;
	}
	

}
