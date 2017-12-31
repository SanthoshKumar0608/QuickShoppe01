package com.niit.QuickShopBackEnd.dao;

import java.util.List;

import com.niit.QuickShopBackEnd.model.Pay;

public interface PayDao{
	
	public boolean saveorupdate(Pay pay);
	public boolean delete(Pay pay);
	public Pay getPay_Id(String Pay_Id);
	public List<Pay> list();
	

}
