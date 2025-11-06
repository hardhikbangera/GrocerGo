package com.food.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.Service.Customer_detailsService;
import com.food.dto.Customer_detailsDTO;
import com.food.model.Customer_details;

@Controller
@RequestMapping("/api")
public class Customer_detailsController {
	@Autowired
	Customer_detailsService customerDetailsService;
	
	@GetMapping("/orders")
	public ResponseEntity<List<Customer_details>> getAllOrder(){
		return ResponseEntity.ok(customerDetailsService.getAllOrders());
	}
	@PostMapping("/orders")
	public ResponseEntity<Customer_details> createOrder(@RequestBody Customer_detailsDTO orderRequest){
		Customer_details order=customerDetailsService.createOrder(orderRequest);
		return new ResponseEntity<>(order,HttpStatus.CREATED);
	}
}
