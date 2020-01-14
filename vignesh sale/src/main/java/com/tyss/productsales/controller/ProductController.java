package com.tyss.productsales.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.productsales.dto.Products;
import com.tyss.productsales.dto.Response;
import com.tyss.productsales.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	Response response = new Response();
	
	
	@PostMapping(path="/products", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Response addproducts(@RequestBody Products products) {
		if(productservice.postProduct(products)) {
			response.setMessagecode(200);
			response.setMessageStatus("posted successfully");
		}else {
			response.setMessagecode(400);
			response.setMessageStatus("Invalid data not able to post");
		}
		return response;
	}
	
	@GetMapping(path="/products",produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getproducts() {
		List<Products> listproducts=productservice.getproducts();
		if(listproducts!=null) {
			response.setMessagecode(200);
			response.setMessageStatus("got the list of products");
			response.setProducts(listproducts);
		}else {
			response.setMessagecode(400);
			response.setMessageStatus("deatils not got,some bad request");
		}	
		return response;
	}
	
	@GetMapping(path="/getnotsales",produces = MediaType.APPLICATION_JSON_VALUE)
	public Response checknotSales() {
	List<Products> productnotsales = productservice.checkProducts();
	if(productnotsales ==null) {
		response.setMessagecode(400);
		response.setMessageStatus("products are not getting");
	}else {
		response.setMessagecode(200);
		response.setMessageStatus("product which are not sold list");
		response.setProducts(productnotsales);
	}
	return response;
	}
	
	@GetMapping(path="/daterange/{start}/{end}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Response daterange(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		List<Products> salebydate= productservice.daterange(start, end);
		if(salebydate == null) {
			response.setMessagecode(400);
			response.setMessageStatus("products are not getting");
		}else {
			response.setMessagecode(200);
			response.setMessageStatus("product which are not sold list");
			response.setProducts(salebydate);
		}
		return response;
	}
	
	@GetMapping(path="/quarterly", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response quarterly() {
		List<Products> quartersales = productservice.quarterlysales();
		if(quartersales == null) {
			response.setMessagecode(400);
			response.setMessageStatus("products are not getting");
		}else {
			response.setMessagecode(200);
			response.setMessageStatus("product which are not sold list");
			response.setProducts(quartersales);
		}
		return response;
	}
	
	
}
