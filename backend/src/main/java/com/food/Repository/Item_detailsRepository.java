package com.food.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.Item_details;

@Repository
public interface Item_detailsRepository extends JpaRepository<Item_details, Long>{
	List<Item_details> findByCategory(String name);
	}
