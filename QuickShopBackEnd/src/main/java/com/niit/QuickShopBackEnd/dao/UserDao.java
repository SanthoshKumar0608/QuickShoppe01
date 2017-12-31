package com.niit.QuickShopBackEnd.dao;

import java.util.List;

import com.niit.QuickShopBackEnd.model.User;

public interface UserDao {
	
	public boolean saveorupdate(User user);
	public boolean delete(User user);
	public User getUid(String uid);
	public List<User> list();
	public User isValid(String umail, String upwd);
	public User getUseremail(String umail);
		

}
