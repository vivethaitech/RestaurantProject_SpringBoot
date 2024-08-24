package com.vivi.restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class KanmaniRestaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String foodName;
	int price;
	boolean availability;
	String quantity;
	
	public KanmaniRestaurant() {
	    // Default constructor
	}

	
	public KanmaniRestaurant(String foodName, int price, boolean availability, String quantity) {
		this.foodName = foodName;
		this.price = price;
		this.availability = availability;
		this.quantity = quantity;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}
