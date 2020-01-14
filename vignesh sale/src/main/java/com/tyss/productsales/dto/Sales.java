package com.tyss.productsales.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sales")
public class Sales {

	@Id
	@GeneratedValue
	@Column(name="sales_id")
	private int salesId;
	
	@Column(name="sales_status")
	private String salesStatus;
	
	@Column(name="delivered_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date saledDate;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="products")
	private Products products;

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Date getSaledDate() {
		return saledDate;
	}

	public void setSaledDate(Date saledDate) {
		this.saledDate = saledDate;
	}

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public String getSalesStatus() {
		return salesStatus;
	}

	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}


}
