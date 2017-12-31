package com.niit.QuickShopBackEnd.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderItems {
	@Id
	private String OrderItem_Id;
	private String Product_Id;
	
	public OrderItems()
	{
		this.OrderItem_Id="OI"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	@ManyToOne
	@JoinColumn(name="Order_Id")
	private Order order;
	
	
	public String getOrderItem_Id() {
		return OrderItem_Id;
	}
	public void setOrderItem_Id(String orderItem_Id) {
		OrderItem_Id = orderItem_Id;
	}
	public String getProduct_Id() {
		return Product_Id;
	}
	public void setProduct_Id(String product_Id) {
		Product_Id = product_Id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
