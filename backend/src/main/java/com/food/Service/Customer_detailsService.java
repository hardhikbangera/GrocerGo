package com.food.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Repository.Customer_detailsRepository;
import com.food.Repository.Item_detailsRepository;
import com.food.Repository.Order_itemsRepository;
import com.food.dto.Cart_itemDTO;
import com.food.dto.Customer_detailsDTO;
import com.food.model.Customer_details;
import com.food.model.Item_details;
import com.food.model.Order_items;

import jakarta.transaction.Transactional;

@Service
public class Customer_detailsService {

	@Autowired 
	private Customer_detailsRepository customer_detailsRepo;
	
	@Autowired
	private Item_detailsRepository itemDetailsRepo;
	
	@Autowired
	private Order_itemsRepository orderItemRepo;
	
	@Transactional
	public Customer_details createOrder(Customer_detailsDTO orderRequest) {		
		Customer_details cutomer=new Customer_details();
		
		cutomer.setCustomer_name(orderRequest.getCustomer_name());
		cutomer.setCustomer_address(orderRequest.getCustomer_address());
		cutomer.setCustomer_phone_number(orderRequest.getCustomer_phone_number());
		cutomer.setTime(LocalDateTime.now());
		cutomer.setStatus("PENDING");
		Customer_details savedCustomer=customer_detailsRepo.save(cutomer);
		
		List<Order_items> list=new ArrayList<>();
		for(Cart_itemDTO cartItem:orderRequest.getCart_item()) {
			Item_details item=itemDetailsRepo.findById(cartItem.getCartItemId())
					.orElseThrow(()->new RuntimeException("Item not found"));
			
			Order_items orderItems=new Order_items();
			orderItems.setCustomer_details(savedCustomer);
			orderItems.setItem_details(item);
			orderItems.setPrice(cartItem.getPrice());
			orderItems.setQuantity(cartItem.getQuantity());
			orderItems.setWeightVariant(cartItem.getWeightVariant());
			orderItemRepo.save(orderItems);
			list.add(orderItems);			
		}		
		return savedCustomer;		
	}
	public List<Customer_details>  getAllOrders(){
		return customer_detailsRepo.findAll();
	}
}
