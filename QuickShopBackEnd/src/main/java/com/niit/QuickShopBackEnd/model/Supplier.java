package com.niit.QuickShopBackEnd.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {
	@Id
	 private String sid;
	 private String sname;
	 private double snumber;
	 private String sadd;
	 
	 public Supplier()
		{
			this.sid="SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
		}
		
	
	 @OneToMany(mappedBy="supplier")
	 private List<Product> product;
	 
	public List<Product> getProduct(){
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getSnumber() {
		return snumber;
	}
	public void setSnumber(double snumber) {
		this.snumber = snumber;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}

}
