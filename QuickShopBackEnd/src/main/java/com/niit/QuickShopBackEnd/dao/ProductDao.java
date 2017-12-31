package com.niit.QuickShopBackEnd.dao;

import java.util.List;

import com.niit.QuickShopBackEnd.model.Product;

public interface ProductDao {
	public boolean saveorupdate(Product product);
	public boolean delete(Product product);
	public Product getPid(String pid);
    public List<Product> getProductByCategory(String catid);
    public List<Product> getProductBySupplier(String sid);
	public List<Product> list();
	

}
