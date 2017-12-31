package com.niit.QuickShopBackEnd.dao;

import java.util.List;

import com.niit.QuickShopBackEnd.model.OrderItems;

public interface OrderItemsDao {
	
	public boolean saveorupdate(OrderItems orderItems);
	public boolean delete(OrderItems orderItems);
	public OrderItems getOrderItem_Id(String orderItem_Id);
	List<OrderItems> list();
	

}
