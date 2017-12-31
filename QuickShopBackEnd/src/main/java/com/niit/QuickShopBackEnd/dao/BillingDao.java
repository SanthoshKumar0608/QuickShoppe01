package com.niit.QuickShopBackEnd.dao;

import java.util.List;

import com.niit.QuickShopBackEnd.model.Billing;

public interface BillingDao {

	public boolean saveorupdate(Billing billing);
	public boolean delete(Billing billing);
	public Billing getBill_Id(String billing);
	public List<Billing> list();
	
}
