package com.niit.QuickShopBackEnd.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Pay {
	@Id
	private String Pay_Id;
	private String Pay_Method;
	private String Status;
	
	public Pay()
	{
		this.Pay_Id="PAY"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getPay_Id() {
		return Pay_Id;
	}
	public void setPay_Id(String pay_Id) {
		Pay_Id = pay_Id;
	}
	public String getPay_Method() {
		return Pay_Method;
	}
	public void setPay_Method(String pay_Method) {
		Pay_Method = pay_Method;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
}
