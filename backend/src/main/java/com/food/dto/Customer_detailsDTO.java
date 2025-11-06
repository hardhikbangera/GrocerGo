package com.food.dto;

import java.util.List;

public class Customer_detailsDTO {

	private String customer_name;
	private String customer_address;
	private String customer_phone_number;
	private List<Cart_itemDTO> cart_item;
	
	public Customer_detailsDTO() {}
	public Customer_detailsDTO(String customer_name,String customer_address,String customer_phone_number,List<Cart_itemDTO> cart_item) {
		this.customer_name=customer_name;
		this.customer_address=customer_address;
		this.customer_phone_number=customer_phone_number;
		this.cart_item=cart_item;
	}
	
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_phone_number() {
		return customer_phone_number;
	}
	public void setCustomer_phone_number(String customer_phoneNumber) {
		this.customer_phone_number = customer_phoneNumber;
	}
	public List<Cart_itemDTO> getCart_item() {
		return cart_item;
	}
	public void setCart_item(List<Cart_itemDTO> cart_item) {
		this.cart_item = cart_item;
	}
}
