package com.tyss.productsales.service;

import java.util.Date;
import java.util.List;

import com.tyss.productsales.dto.Products;

public interface ProductService {

	public boolean postProduct(Products products);
	
	public List<Products> getproducts();
	
	public List<Products> checkProducts();
	
	public List<Products> daterange(Date start, Date end);
	
	public List<Products> quarterlysales();
}
