package com.niit.QuickShopBackEnd.daoimpl;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.QuickShopBackEnd.dao.UserDao;
import com.niit.QuickShopBackEnd.model.User;

@Repository("userDao")
@Transactional
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	@Override
	public boolean delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	public User getUid(String uid) {
		String q1="from User where uid='"+uid+"'";
		Query  w=sessionFactory.getCurrentSession().createQuery(q1);
		List<User> list=(List<User>) w.list();
		
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		 return list.get(0);
	}

	@Override
	public List<User> list() {
		List<User> list=(List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return null;
	}

	@Override
	public User isValid(String umail, String upwd) {
		String q1="from User where upwd'"+upwd+"'";
		Query  w=sessionFactory.getCurrentSession().createQuery(q1);
		List<User> list=(List<User>) w.list();
		
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return null;
	}

	@Override
	public User getUseremail(String umail) {
		String q1="from User where umail='"+umail+"'";
		Query  w=sessionFactory.getCurrentSession().createQuery(q1);
		List<User> list=(List<User>) w.list();
		
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

}
