package in.codertechnologies.pettycash.dto;

import java.sql.*;


public class Daily {
	
	private int did , pId ,productPrice, productQuantity, productTotal ;
	private Date date1;
	
	
	public Product getDailyProduct() {
		return dailyProduct;
	}
	public void setDailyProduct(Product dailyProduct) {
		this.dailyProduct = dailyProduct;
	}
	
	private Product dailyProduct;
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getProductTotal() {
		return productTotal;
	}
	@Override
	public String toString() {
		return "Daily [did=" + did + ", pId=" + pId + ", productPrice=" + productPrice + ", productQuantity="
				+ productQuantity + ", productTotal=" + productTotal + ", date1=" + date1 + ", dailyProduct="
				+ dailyProduct + "]";
	}
	public void setProductTotal(int productTotal) {
		this.productTotal = productTotal;
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		
		this.date1 = date1;
	}


	}
