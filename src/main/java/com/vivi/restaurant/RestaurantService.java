package com.vivi.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RestaurantService {
	
	private RestaurantRepository repo;
    @Autowired
	public RestaurantService(RestaurantRepository repo) {
		this.repo = repo;
	}
	public List<KanmaniRestaurant> getFoodList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	public String postFoodList(KanmaniRestaurant kannu) {
		repo.save(kannu);
		return "Food Item details successfully added by Admin";
	}
	public String deleteFoodList(String foodName) {
		List<KanmaniRestaurant> list = repo.findAll();
		for(KanmaniRestaurant kr:list)
			if(kr.getFoodName().equalsIgnoreCase(foodName)) {
				repo.deleteById(kr.id);
		return "Food item successfully deleted by Mananger";
			}
		return "food item not found";
	}
	public String putFoodlist(Long id, KanmaniRestaurant kannu) {
		if(repo.existsById(id)) {
			kannu.setId(id);
			repo.save(kannu);
			return "Food updated by manager successfully";
		}
		return "Food Not found";
	}
    
    
	
	

}
