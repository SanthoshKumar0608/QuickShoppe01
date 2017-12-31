package com.niit.QuickShopBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.niit.QuickShopBackEnd.dao.AuthenticationDao;
import com.niit.QuickShopBackEnd.model.Authentication;
import com.niit.QuickShopBackEnd.model.Category;

@Repository("authenticationDao")
@EnableTransactionManagement
@Transactional
public class AuthenticationDaoImpl implements AuthenticationDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public AuthenticationDaoImpl(SessionFactory sessionFactory) {
		       this.sessionFactory=sessionFactory;
	}
	@Override
	public boolean saveorupdate(Authentication authentication) {
			sessionFactory.getCurrentSession().saveOrUpdate(authentication);
			return true;
	}


	@Override
	public boolean delete(Authentication authentication) {
		sessionFactory.getCurrentSession().delete(authentication);
		return true;
	}


	@Override
	public Authentication getRole_id(String role_id) {
		String q1="from Authentication where role_id='"+role_id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Authentication> list=(List<Authentication>) w.list();
		if(list ==null || list.isEmpty())
		{
			return null;
			
		}
		  return list.get(0);
	}
	
	public List<Authentication> list() {
		List<Authentication> authentication =(List<Authentication>) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return authentication;
	}

}
