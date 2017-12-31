package com.niit.QuickShopBackEnd.dao;
import java.util.List;

import com.niit.QuickShopBackEnd.model.Supplier;
public interface SupplierDao {
	
	public boolean saveorupate(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier getSid(String sid);
	public List<Supplier> list();
	
	
}
