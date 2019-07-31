package com.risk.service;

import java.util.List;

import com.risk.model.FoodMenu;

public interface FoodMenuService {

	List<FoodMenu> getFoodMenuList();

	void SaveFoodMenu(FoodMenu foodMenu);

}
