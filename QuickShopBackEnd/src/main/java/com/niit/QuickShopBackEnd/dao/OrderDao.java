package com.niit.QuickShopBackEnd.dao;

import java.util.List;

import com.niit.QuickShopBackEnd.model.Order;

public interface OrderDao {

	public boolean saveorupdate(Order order);
	public boolean delete(Order order);
	public Order getOrder_Id(String Order_Id);
	public List<Order> list();
}
