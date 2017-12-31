package com.niit.QuickShopBackEnd.dao;

import java.util.List;

import com.niit.QuickShopBackEnd.model.Cart;

public interface CartDao {
	
	public boolean saveorupdate(Cart cart);
	public boolean delete(Cart cart);
	public Cart getCart_Id(String Cart_Id);
	public List<Cart> list();

}
