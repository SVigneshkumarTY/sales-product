package com.tyss.productsales.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.productsales.dao.ProductDao;
import com.tyss.productsales.dto.Products;
import com.tyss.productsales.dto.Sales;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductDao productdao;
	
	@Override
	public boolean postProduct(Products products) {		
		return productdao.postProduct(products);
	}

	@Override
	public List<Products> getproducts() {
		return productdao.getproducts();
	}

	@Override
	public List<Products> checkProducts() {
		return productdao.checkProducts();
	}

	@Override
	public List<Products> daterange(Date start, Date end) {
		return productdao.daterange(start, end);
	}

	@Override
	public List<Products> quarterlysales() {
		return productdao.quarterlysales();
	}
	
	

}
