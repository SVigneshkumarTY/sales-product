package com.tyss.productsales.dao;

import java.util.List;

import com.tyss.productsales.dto.Products;
import com.tyss.productsales.dto.Sales;

public interface SalesDao {

	public boolean postSales(Sales sales,int prouctid);
	
	public List<Sales> getSales();
	
	public List<Sales> monthlysales();
}
