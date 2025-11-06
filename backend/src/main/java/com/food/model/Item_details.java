package com.food.model;

import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Item_details {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("Item_id")
	private Long Item_id;
	private String name;
	private String description;
	private Double price;
	private String image_url;
	private String category;

	
	 private Double pricePer250g;
	 private Double pricePer500g;
	 private Double pricePer1kg;
	 private Double pricePer2kg;
	 private Double pricePer5kg;
	 public Item_details(){}
	public Long getItem_id() {
		return Item_id;
	}
	public void setItem_id(Long item_id) {
		Item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String discription) {
		this.description = discription;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double d) {
		this.price = d;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Double getPricePer250g() {
		return pricePer250g;
	}
	public void setPricePer250g(Double pricePer250g) {
		this.pricePer250g = pricePer250g;
	}
	public Double getPricePer500g() {
		return pricePer500g;
	}
	public void setPricePer500g(Double pricePer500g) {
		this.pricePer500g = pricePer500g;
	}
	public Double getPricePer1kg() {
		return pricePer1kg;
	}
	public void setPricePer1kg(Double pricePer1kg) {
		this.pricePer1kg = pricePer1kg;
	}
	public Double getPricePer2kg() {
		return pricePer2kg;
	}
	public void setPricePer2kg(Double pricePer2kg) {
		this.pricePer2kg = pricePer2kg;
	}
	public Double getPricePer5kg() {
		return pricePer5kg;
	}
	public void setPricePer5kg(Double pricePer5kg) {
		this.pricePer5kg = pricePer5kg;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}


}
