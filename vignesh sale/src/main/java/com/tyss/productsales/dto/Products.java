package com.tyss.productsales.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="products")
public class Products {

	@Id
	@GeneratedValue
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;

	@Column(name="price")
	private double price;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="magf_date")
	private Date manufacturingDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="exp_date")
	private Date exprityDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
	private List<Sales> sales;

	public List<Sales> getSales() {
		return sales;
	}

	public void setSales(List<Sales> sales) {
		this.sales = sales;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Date getExprityDate() {
		return exprityDate;
	}

	public void setExprityDate(Date exprityDate) {
		this.exprityDate = exprityDate;
	}
	
	
}
