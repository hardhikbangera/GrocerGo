package com.food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.model.Order_items;

public interface Order_itemsRepository extends JpaRepository<Order_items, Integer>{

}
