package com.tyss.productsales.dto;

import java.util.List;

public class Response {

	private int messagecode;
	
	private String messageStatus;
	
	private List<Products> products;
	
	private List<Sales> sales;

	public int getMessagecode() {
		return messagecode;
	}

	public void setMessagecode(int messagecode) {
		this.messagecode = messagecode;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public List<Sales> getSales() {
		return sales;
	}

	public void setSales(List<Sales> sales) {
		this.sales = sales;
	}
	
}
