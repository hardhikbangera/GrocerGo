package com.food.dto;

public class Cart_itemDTO {

	private Long cartItemId;
	private String name;
	private String discription;
	private Double price;
	private String image_url;
	private Integer quantity;
	
	private String weightVariant;
	
	public Cart_itemDTO(){}
	public Cart_itemDTO(Long cartItemId,String name,String discription,Double price,String image_url,Integer quantity,String weightVariant){
		this.cartItemId=cartItemId;
		this.name=name;
		this.discription=discription;
		this.price=price;
		this.image_url=image_url;
		this.quantity=quantity;
		this.weightVariant=weightVariant;
	}
	
	public Long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(Long cartItemid) {
		this.cartItemId = cartItemid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getWeightVariant() {
		return weightVariant;
	}
	public void setWeightVariant(String weightVariant) {
		this.weightVariant = weightVariant;
	}
}
