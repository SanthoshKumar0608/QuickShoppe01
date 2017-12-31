package com.niit.QuickShopBackEnd.dao;

import java.util.List;

import com.niit.QuickShopBackEnd.model.Authentication;

public interface AuthenticationDao {
	

		public boolean saveorupdate(Authentication authentication);
		public boolean delete(Authentication authentication);
		public Authentication getRole_id(String role_id);
		public List<Authentication> list();
		
	}



