package com.niit.QuickShopBackEnd.dao;

import java.util.List;


import com.niit.QuickShopBackEnd.model.Shipping;

public interface ShippingDao {
	
	public boolean saveorupdate(Shipping shipping);
	public boolean delete(Shipping shipping);
	public Shipping getSpid(String Spid);
	public List<Shipping> list();
	
}
