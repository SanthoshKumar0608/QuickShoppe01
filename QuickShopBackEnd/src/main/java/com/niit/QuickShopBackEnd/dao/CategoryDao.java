package com.niit.QuickShopBackEnd.dao;

import java.util.List;

import com.niit.QuickShopBackEnd.model.Category;

public interface CategoryDao {

	public boolean saveorupdate(Category category);
	public boolean delete(Category category);
	public Category getCatId(String catid);
	public List<Category> list();
	
}
