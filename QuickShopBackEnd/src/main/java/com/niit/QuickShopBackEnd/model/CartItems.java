package com.niit.QuickShopBackEnd.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class CartItems {
	@Id
	private String Cartitem_Id;
	private float Price;
	
	public CartItems()
	{
		this.Cartitem_Id="CartId"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	@ManyToOne
	@JoinColumn(name="Cart_Id")
	private Cart cart;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pid")
	private Product product;
	
	public String getCartitem_Id() {
		return Cartitem_Id;
	}
	public void setCartitem_Id(String cartitem_Id) {
		Cartitem_Id = cartitem_Id;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
   
}
