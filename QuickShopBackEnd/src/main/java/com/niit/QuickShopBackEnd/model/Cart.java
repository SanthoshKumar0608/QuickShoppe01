package com.niit.QuickShopBackEnd.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Table
@Entity
@Component
public class Cart {
	@Id
	private String Cart_Id;
	private Double Grand_Total=0.0;
	private int Total_Item=0;
	
	public Cart()
	{
		this.Cart_Id="Cart"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
   @OneToMany(mappedBy="cart")
   private List<CartItems> cartitems;

public String getCart_Id() {
	return Cart_Id;
}

public void setCart_Id(String cart_Id) {
	Cart_Id = cart_Id;
}

public Double getGrand_Total() {
	return Grand_Total;
}

public void setGrand_Total(Double grand_Total) {
	Grand_Total = grand_Total;
}

public int getTotal_Item() {
	return Total_Item;
}

public void setTotal_Item(int total_Item) {
	Total_Item = total_Item;
}

public List<CartItems> getCartitems() {
	return cartitems;
}

public void setCartitems(List<CartItems> cartitems) {
	this.cartitems = cartitems;
}
   
	
	
	}
	
	


