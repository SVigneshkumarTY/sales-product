package com.tyss.productsales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.productsales.dao.SalesDao;
import com.tyss.productsales.dto.Sales;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesDao salesdao;
	
	@Override
	public boolean postSales(Sales sales,int productid) {
		return salesdao.postSales(sales,productid);
	}

	@Override
	public List<Sales> getSales() {
		return salesdao.getSales();
	}

	@Override
	public List<Sales> monthlysales() {
		return salesdao.monthlysales();
	}

}
