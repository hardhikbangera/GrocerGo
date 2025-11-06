package com.food.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.stereotype.Service;

import com.food.Repository.Order_itemsRepository;
import com.food.model.Order_items;

@Service
public class Order_itemsService {

	@Autowired
	Order_itemsRepository orderItemRepo;
	
	public List<Order_items> findAllItems() {
		return orderItemRepo.findAll();
	}
	public Order_items findByid(Integer id) {
		return orderItemRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Cannot find item"));
	}
}
