package com.niit.QuickShopBackEnd.dao;

import java.util.List;


import com.niit.QuickShopBackEnd.model.CartItems;

public interface CartItemsDao {
	
	public boolean saveorupdate(CartItems cartItems);
	public boolean delete(CartItems cartItems);
	public CartItems getCartitem_Id(String cartitem_Id);
	public List<CartItems> list();

}
