package com.food.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.Service.Order_itemsService;
import com.food.model.Order_items;

@Controller
@RequestMapping("/api")
public class Order_itemsController {

	@Autowired
	Order_itemsService orderItemService;

	@GetMapping("/allItem")
	public ResponseEntity<List<Order_items>> findAllitems() {
		return ResponseEntity.ok(orderItemService.findAllItems());
	}
	@GetMapping("/order-items/{id}")
	public ResponseEntity<Order_items> findAllitems(@PathVariable Integer id) {
		return ResponseEntity.ok(orderItemService.findByid(id));
	}
}
