package com.risk.dao;

import java.util.List;

import com.risk.model.FoodMenu;

public interface FoodMenuDao {
	
	List<FoodMenu> getFoodMenuList();
	 
	 void SaveFoodMenu(FoodMenu foodMenu);

}