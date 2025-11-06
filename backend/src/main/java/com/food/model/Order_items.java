package com.food.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_items")
public class Order_items {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer_details customer_details;
	
	@ManyToOne
	@JoinColumn(name="ItemId")
	private Item_details Item_details;
	
	private Integer quantity;
	private Double price;
	private String weightVariant;
	
	public Order_items() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer_details getCustomer_details() {
		return customer_details;
	}
	public void setCustomer_details(Customer_details customer_details) {
		this.customer_details = customer_details;
	}
	public Item_details getItem_details() {
		return Item_details;
	}
	public void setItem_details(Item_details item_details) {
		Item_details = item_details;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getWeightVariant() {
		return weightVariant;
	}
	public void setWeightVariant(String weightVariant) {
		this.weightVariant = weightVariant;
	}
}
