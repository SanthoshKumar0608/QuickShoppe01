package com.niit.QuickShopBackEnd.model;

import javax.persistence.Table;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Category {

	@Id
	private String catid;
	private String catname;
	@OneToMany(mappedBy ="category")
	private List<Product> product;
	
	public Category()
	{
		this.catid="Cat"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public List<Product> getProduct() {
		return product;
		
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public String getCatid() {
		return catid;
	}
	public void setCatid(String catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
		
}
