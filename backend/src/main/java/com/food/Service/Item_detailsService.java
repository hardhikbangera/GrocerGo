package com.food.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Repository.Item_detailsRepository;
import com.food.model.Item_details;

@Service
public class Item_detailsService {

	@Autowired
	private Item_detailsRepository item_details_repo;
	

	public List<Item_details> getAllItem(){
		return item_details_repo.findAll();
	}
	public Item_details getItemByid(Long id){
		return item_details_repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Food item not found"));
	}
	public List<Item_details> getItemByCategory(String name){
		return item_details_repo.findByCategory(name);		
	}
	public void addItem(Item_details item) {
		item_details_repo.save(item);
	}
	public void delete(Long id) {
		item_details_repo.deleteById(id);
	}
}
