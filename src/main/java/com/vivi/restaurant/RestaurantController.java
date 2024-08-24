package com.vivi.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Kanmani/restaurant")
public class RestaurantController {
	
private RestaurantService service;
@Autowired
public RestaurantController(RestaurantService service) {
	this.service = service;
}
@GetMapping("/food/get")  
public List<KanmaniRestaurant> getFoodList() {
    return service.getFoodList();
}

@PostMapping("food/add")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public String postFoodList(@RequestBody KanmaniRestaurant kannu) {
	return service.postFoodList(kannu);
}

@PutMapping("food/update/{id}")
@PreAuthorize("hasRole('ROLE_ASSMANAGER')")
public String putFoodList(@PathVariable Long id, @RequestBody KanmaniRestaurant kannu) {
	return service.putFoodlist(id,kannu);
}
     
@DeleteMapping("food/delete/{foodName}")
@PreAuthorize("hasRole('ROLE_MANAGER')")
public String deleteFoodList(@PathVariable String foodName) {
	return service.deleteFoodList(foodName);
}
}
