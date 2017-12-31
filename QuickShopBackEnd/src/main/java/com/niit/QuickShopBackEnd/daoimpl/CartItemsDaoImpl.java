package com.niit.QuickShopBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.QuickShopBackEnd.dao.CartItemsDao;
import com.niit.QuickShopBackEnd.model.Cart;
import com.niit.QuickShopBackEnd.model.CartItems;
import com.niit.QuickShopBackEnd.model.Category;

@Repository("cartItemsDao")
@EnableTransactionManagement
@Transactional
public class CartItemsDaoImpl implements CartItemsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public CartItemsDaoImpl(SessionFactory sessionFactory)
	{
		
		this.sessionFactory=sessionFactory;
		 
	}
	
	@Override
	public boolean saveorupdate(CartItems cartItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItems);
		return true;
	}

	@Override
	public boolean delete(CartItems cartItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItems);
		return false;
	}

	@Override
	public CartItems getCartitem_Id(String cartitem_Id) {
		String q1="from CartItems where cartitem_Id='"+cartitem_Id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<CartItems> list=(List<CartItems>) w.list();
		if(list ==null || list.isEmpty())
		{
			return null;
			
		}
		  return list.get(0);
	    }

	@Override
	public List<CartItems> list() {
		List<CartItems> cartItems =(List<CartItems>) sessionFactory.getCurrentSession().createCriteria(CartItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cartItems;
	}

	
}
