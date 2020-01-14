package com.tyss.productsales.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.productsales.dto.Products;

@Repository
public class ProductDaoImpl implements ProductDao{

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean postProduct(Products products) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(products);
		transaction.commit();
		return true;
	}

	@Override
	public List<Products> getproducts() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String info = "from Products";
		Query query = manager.createQuery(info);
		List<Products> list = query.getResultList();
		if (list == null) {
			return null;
		}
		return list;
	}

	@Override
	public List<Products> checkProducts() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String check ="from Products prod where prod.productId not in (select sales.products from Sales sales group by sales.products)";
		Query query = manager.createQuery(check);
		List<Products> notsales= query.getResultList();
		if(notsales == null) {
			return null;
		}
		return notsales;
	}

	@Override
	public List<Products> daterange(Date start, Date end) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String range = "select product_name from products where product_id in (select products from sales where delivered_date between :start and :end)";
		Query query = manager.createNativeQuery(range);
		query.setParameter("start", start);
		query.setParameter("end", end);
		List<Products> rangebydates = query.getResultList();
		if(rangebydates == null) {
			return null;
		}
		return rangebydates;
	}

	@Override
	public List<Products> quarterlysales() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String salesbyquarter = "select product_name from products where product_id in (select products from sales where delivered_date in (quarter('2019-12-01')))";
		Query query = manager.createQuery(salesbyquarter);
		List<Products> quarter = query.getResultList();
		if(quarter == null) {
			return null;
		}
		return quarter;
	}

	

}
