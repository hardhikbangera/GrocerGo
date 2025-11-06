package com.food.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.Service.Item_detailsService;
import com.food.model.Item_details;

@Controller
@RequestMapping("/api")
public class Item_detailsController {
	@Autowired
	Item_detailsService itemDetailsService;

	@GetMapping
	public ResponseEntity<List<Item_details>> getAllItem(){
		return ResponseEntity.ok( itemDetailsService.getAllItem());
	}
	@GetMapping("/item-details/{id}")
	public ResponseEntity<Item_details> getItemByid(@PathVariable Long id){
		return ResponseEntity.ok( itemDetailsService.getItemByid(id));
	}
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Item_details>> getItemByid(@PathVariable String category){
		return ResponseEntity.ok( itemDetailsService.getItemByCategory(category));
	}
	
}
