package com.tyss.productsales.service;

import java.util.List;

import com.tyss.productsales.dto.Sales;

public interface SalesService {

	public boolean postSales(Sales sales,int productid);
	
	public List<Sales> getSales();
	
	public List<Sales> monthlysales();
}
