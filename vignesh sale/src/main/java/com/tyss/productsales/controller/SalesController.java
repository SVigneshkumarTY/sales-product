package com.tyss.productsales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.productsales.dto.Products;
import com.tyss.productsales.dto.Response;
import com.tyss.productsales.dto.Sales;
import com.tyss.productsales.service.ProductService;
import com.tyss.productsales.service.SalesService;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class SalesController {

	@Autowired
	private SalesService saleservice;
	
	Response response = new Response();
	
	
	@PostMapping(path="/sales/{productid}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Response addsales(@RequestBody Sales sales, @PathVariable int productid) {
		if(saleservice.postSales(sales,productid)) {
			response.setMessagecode(200);
			response.setMessageStatus("posted successfully");
		}else {
			response.setMessagecode(400);
			response.setMessageStatus("Invalid data not able to post");
		}
		return response;
	}
	
	@GetMapping(path="/sales",produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getsales() {
		List<Sales> listsales=saleservice.getSales();
		if(listsales!=null) {
			response.setMessagecode(200);
			response.setMessageStatus("got the list of Sales");
			response.setSales(listsales);
		}else {
			response.setMessagecode(400);
			response.setMessageStatus("deatils not got,some bad request");
		}	
		return response;
	}
	
	@GetMapping(path="/monthlysales", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getmonthlysales() {
		List<Sales> monthlySales = saleservice.monthlysales();
		if(monthlySales != null) {
			response.setMessagecode(200);
			response.setMessageStatus("monthly sales list got");
			response.setSales(monthlySales);
		}else {
			response.setMessagecode(400);
			response.setMessageStatus("deatils not got,some bad request");
		}
		return response;
	}
}
