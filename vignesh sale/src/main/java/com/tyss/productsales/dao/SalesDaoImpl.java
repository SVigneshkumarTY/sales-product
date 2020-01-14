package com.tyss.productsales.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.productsales.dto.Products;
import com.tyss.productsales.dto.Sales;

@Repository
public class SalesDaoImpl implements SalesDao{

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	
	@Override
	public boolean postSales(Sales sales,int productid) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		sales.setProducts(manager.find(Products.class, productid));
		manager.persist(sales);
		transaction.commit();
		return true;
	}

	@Override
	public List<Sales> getSales() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String info = "From Sales";
		Query query = manager.createQuery(info);
		List<Sales> list = query.getResultList();
		if (list == null) {
			return null;
		}
		return list;
	}

	@Override
	public List<Sales> monthlysales() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String monthsales= "select products,extract(month from delivered_date) as month, count(products) from sales group by extract(month from delivered_date) order by month";
		Query query = manager.createNativeQuery(monthsales);
		List<Sales> monthlysales = query.getResultList();
		if(monthlysales == null) {
			return null;
		}
		return monthlysales;
	}
	
	

}
