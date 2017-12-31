package com.niit.QuickShopBackEnd.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Shipping {
	
	@Id
	private String Spid;
	private String First_Name;
	private String Last_Name;
	private String Shipping_Id;
	private String House_No;
	private String Country;
	private String City;
	private String Pincode;
	private String Email;
	private String Mobile_No;
	
	
	public Shipping()
	{
		this.Spid="SP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	public String getSpid() {
		return Spid;
	}
	public void setSpid(String spid) {
		Spid = spid;
	}


	@ManyToOne
	@JoinColumn(name="uid")
	private User user;
	
	
	
	
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getShipping_Id() {
		return Shipping_Id;
	}
	public void setShipping_Id(String shipping_Id) {
		Shipping_Id = shipping_Id;
	}
	public String getHouse_No() {
		return House_No;
	}
	public void setHouse_No(String house_No) {
		House_No = house_No;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile_No() {
		return Mobile_No;
	}
	public void setMobile_No(String mobile_No) {
		Mobile_No = mobile_No;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
		

}
