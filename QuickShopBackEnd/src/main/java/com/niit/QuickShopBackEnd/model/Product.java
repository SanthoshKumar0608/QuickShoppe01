package com.niit.QuickShopBackEnd.model;





import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product {
	
	@Id
	private String pid;
	private String pname;
	private String pdesp;
	private int price;
	private int qty;
	
	public Product()
	{
		this.pid="P"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@ManyToOne
	@JoinColumn(name="catid")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="sid")
	private Supplier supplier;
	
	@Transient 
	private MultipartFile pimg;
	
	public MultipartFile getPimg() {
		return pimg;
	}
	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}
	public Supplier getSupplier() {
		
		return supplier;
	}
	public void setSupplier(Supplier supplier) 
	{
				this.supplier = supplier;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesp() {
		return pdesp;
	}
	public void setPdesp(String pdesp) {
		this.pdesp = pdesp;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
		
}
